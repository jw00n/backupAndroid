package com.example.imagetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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

public class uploadActivity extends AppCompatActivity {

    Button btnUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);


       btnUpload=findViewById(R.id.btnUpload);


       btnUpload.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(Intent.ACTION_PICK);
               intent.setDataAndType(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, "downloads/*");

           }
       });
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