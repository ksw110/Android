package com.example.app0223;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    FrameLayout layout;
    BottomNavigationView bnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.Framelayout);
        bnv = findViewById(R.id.bottomNavigationView);

        // bnv 를 클릭했을 때 어떤 메뉴가 선택됬는지 검사해서 frameLayout 에 들어갈
        // frameLayout 에 들어갈 fragment 갈아 끼워주면 됨

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.Framelayout, new Fragment1()).commit();

        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId()){
                    case R.id.item1:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.Framelayout, new Fragment1()).commit();
                        break;
                    case R.id.item2:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.Framelayout, new Fragment2()).commit();
                        break;
                    case R.id.item3:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.Framelayout, new Fragment3()).commit();
                        break;
                    case R.id.item4:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.Framelayout, new Fragment4()).commit();
                        break;
                }
                // 현재 이벤트가 종료되었는지 여부를 리턴 => longClick!! 할 때
                return true;
            }
        });


    }
}