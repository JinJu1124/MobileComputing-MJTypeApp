package com.example.leejj_60181661_finalexam;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //상태바 생략
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setTitle("대학생활 유형탐구(이진주)");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start_button = (Button) findViewById(R.id.start);
        Button view_type = (Button) findViewById(R.id.view_type);
        Button quit_button = (Button) findViewById(R.id.quit);

        //유형검사 시작버튼
        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), User_information.class);
                startActivity(intent);
            }
        });
        //유형 미리보기 버튼
        view_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), view_types.class);
                startActivity(intent);
            }
        });
        //나가기 버튼
        quit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //사용자가 나갈 건지에 대한 대화상자
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("나가기");
                dlg.setMessage("정말로 나가실건가요?");

                // 대화상자의 '네'버튼을 누르면 어플이 종류됨
                dlg.setPositiveButton("네", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ActivityCompat.finishAffinity(MainActivity.this);
                    }
                });
                dlg.setNegativeButton("아니요", null);
                dlg.show();
            }
        });
    }
}