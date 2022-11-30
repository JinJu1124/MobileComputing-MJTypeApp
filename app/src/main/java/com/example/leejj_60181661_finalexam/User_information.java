package com.example.leejj_60181661_finalexam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class User_information extends AppCompatActivity {
    String user_name;
    EditText name;
    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //상태바 생략
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);
        setTitle("대학생활 유형탐구(이진주)");

        name = (EditText) findViewById(R.id.editText1);
        RadioButton man = (RadioButton) findViewById(R.id._man);
        RadioButton woman = (RadioButton) findViewById(R.id._woman);
        Button btnStart = (Button) findViewById(R.id.Startbutton);
        RadioGroup gender = (RadioGroup) findViewById(R.id.gender);
        ImageView mari = (ImageView) findViewById(R.id.mari);
        ImageView maru = (ImageView) findViewById(R.id.maru);

        //이름 데이터 변수
        user_name = name.getText().toString();

        //성별 고르기
        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id._man){ //남자인 경우
                    num = num+1;
                    maru.setVisibility(View.VISIBLE);
                    mari.setVisibility(View.INVISIBLE);

                } else{ //여자인 경우
                    num = num+2;
                    mari.setVisibility(View.VISIBLE);
                    maru.setVisibility(View.INVISIBLE);
                }
            }
        });

        //유형 시작하기 버튼
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //사용자가 모든 문항에 대해 다 입력했을 경우 다음으로 넘어감.
                if(num > 0 &&  name.getText().toString().length() > 0) {
                    Intent intent_1 = new Intent(getApplicationContext(), question_1.class);
                    intent_1.putExtra("name", name.getText().toString());
                    //성별 정보 전달하기
                    if (num == 1){
                        intent_1.putExtra("gender", "마루");
                    } else {
                        intent_1.putExtra("gender", "마리");
                    }
                    // 사용자 이름값을 받아와서 Toast
                    Toast.makeText(getApplicationContext(), name.getText().toString() + "님 너무 멋있는 이름이네요.", Toast.LENGTH_SHORT).show();
                    startActivity(intent_1);
                    finish();

                    // 사용자가 문항에 다 응답을 안한 경우 대화상자가 뜸
                } else{
                    AlertDialog.Builder dlg = new AlertDialog.Builder(User_information.this);
                    dlg.setMessage("모두 응답해주세요!");
                    dlg.setPositiveButton("넹", null);
                    dlg.show();
                }


            }
        });

    }
}