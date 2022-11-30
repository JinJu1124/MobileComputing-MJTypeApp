package com.example.leejj_60181661_finalexam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class view_types extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //상태바 생략
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_types);
        setTitle("대학생활 유형탐구(이진주)");

        final ViewFlipper viewFlipper;

        Button btnPrev = (Button) findViewById(R.id.btnPrev);
        Button btnNext = (Button) findViewById(R.id.btnNext);
        Button btnStart = (Button) findViewById(R.id.startBtn);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewflipper);

        //미리보기의 이전 버튼
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlipper.showPrevious();
            }
        });

        //미리보기의 다음 버튼
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlipper.showNext();
            }
        });

        //유형 검사 시작
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), User_information.class);
                startActivity(intent);
                finish();
            }
        });
    }
}