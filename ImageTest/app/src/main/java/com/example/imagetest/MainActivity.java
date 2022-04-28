package com.example.imagetest;

import static android.content.ContentValues.TAG;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkLossHandler;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3Client;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private ActivityResultLauncher<Intent> resultLauncher;
    Button btnload, btnselect;
    private final int GET_GALLERY_IMAGE = 200;
    ImageView imageview1;
    Uri selectedImageUri;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnload = findViewById(R.id.uploadBtn);
        btnselect = findViewById(R.id.selectBtn);
        imageview1 = findViewById(R.id.imageview1);

        //권한 요청
        if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 0x0000001);
        }

// User 갤러리에서 가져온 이미지 uri를 file객체로 변환


        btnselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, 200);

            }
        });


        btnload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user="member";
                /* ------------ OnClick에서 호출------------ */
                uploadWithTransferUtilty(user+1+"jpg", file); // file.getName()으로 파일 이름 가져옴
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GET_GALLERY_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri selectedImageUri = data.getData();
            imageview1.setImageURI(selectedImageUri);

            String path = getPathFromUri(selectedImageUri);

            file = new File(path);

        }

    }

    @SuppressLint("Range")
    public String getPathFromUri(Uri uri){
        Cursor cursor = getContentResolver().query(uri, null, null, null, null );
        cursor.moveToNext();
        String path = cursor.getString( cursor.getColumnIndex( "_data" ) );
        cursor.close();
        return path;
    }


    public void uploadWithTransferUtilty(String fileName, File file) {

        AWSCredentials awsCredentials = new BasicAWSCredentials("AKIASSS4QVJUPHIBRAOF", "yjOkST71e9ZXfla5iIpJMkfHoAcwz1GaJxHwbL95");    // IAM 생성하며 받은 것 입력
        AmazonS3Client s3Client = new AmazonS3Client(awsCredentials, Region.getRegion(Regions.US_EAST_2));

        TransferUtility transferUtility = TransferUtility.builder().s3Client(s3Client).context(getApplicationContext()).build();
        TransferNetworkLossHandler.getInstance(getApplicationContext());

        TransferObserver uploadObserver = transferUtility.upload("momoyami/moim", fileName, file);    // (bucket api, file이름, file객체)

        uploadObserver.setTransferListener(new TransferListener() {
            @Override
            public void onStateChanged(int id, TransferState state) {
                if (state == TransferState.COMPLETED) {
                    // Handle a completed upload
                }
            }

            @Override
            public void onProgressChanged(int id, long current, long total) {
                int done = (int) (((double) current / total) * 100.0);
                Log.d("MYTAG", "UPLOAD - - ID: $id, percent done = $done");
            }

            @Override
            public void onError(int id, Exception ex) {
                Log.d("MYTAG", "UPLOAD ERROR - - ID: $id - - EX:" + ex.toString());
            }
        });
    }





}