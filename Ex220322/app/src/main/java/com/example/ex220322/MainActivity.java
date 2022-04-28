package com.example.ex220322;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav= findViewById(R.id.bottomNav);

        fragment1 = new Fragment1();
        fragment2 =new Fragment2();
        fragment3= new Fragment3();
        // 액티비티에 보여질 첫 프래그먼트 화면 설정
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragment1).commit();

        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int postion=item.getItemId();

                if(postion==R.id.item1){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragment1).commit();

                }else if(postion==R.id.item2){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragment2).commit();

                }else{
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragment3).commit();

                }


                return true;//선택된 메뉴 활성화
            }
        });

    }
}