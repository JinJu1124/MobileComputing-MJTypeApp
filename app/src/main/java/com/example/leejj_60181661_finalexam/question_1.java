package com.example.leejj_60181661_finalexam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class question_1 extends AppCompatActivity {
    RadioGroup radiogroup1,radiogroup2, radiogroup3;
    RadioButton radioButton, radioButton2, radioButton3, radioButton4, radioButton5, radioButton6;
    Button nextButton;
    int number, number2;
    int response1 = 0;
    int response2 = 0;
    int response3 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //상태바 생략
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_1);
        setTitle("대학생활 유형탐구(이진주)");

        radiogroup1 = (RadioGroup)findViewById(R.id.radiogroup1);
        radiogroup2 = (RadioGroup)findViewById(R.id.radiogroup2);
        radiogroup3 = (RadioGroup)findViewById(R.id.radiogroup3);

        radioButton = (RadioButton)findViewById(R.id.radioButton);
        radioButton2 = (RadioButton)findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton)findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton)findViewById(R.id.radioButton4);
        radioButton5 = (RadioButton)findViewById(R.id.radioButton5);
        radioButton6 = (RadioButton)findViewById(R.id.radioButton6);

        TextView progress_text = (TextView)findViewById(R.id.progress_text1);
        ProgressBar progressBar = (ProgressBar)findViewById(R.id.progressBar3);

        nextButton = (Button) findViewById(R.id.button);

        number = 0; //네 값(문항에 대한)
        number2 = 0; //아니오 값 (문항에 대한)

        //질문1, 질문2, 질문3 누르면 response 값이 생성
        //응답에 프로그래스 바 게이지가 올라간다.
        radiogroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                response1 = 1;
                if (response1==1&&response2==2&&response3==3){
                    progressBar.setProgress(30);
                    progress_text.setText("Go! Go! Next!");
                }

            }
        });
        radiogroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                response2 = 2;
                if (response1==1&&response2==2&&response3==3){
                    progressBar.setProgress(30);
                    progress_text.setText("Go! Go! Next!");
                }
            }
        });
        radiogroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                response3 = 3;
                if (response1==1&&response2==2&&response3==3){
                    progressBar.setProgress(30);
                    progress_text.setText("Go! Go! Next!");
                }
            }
        });

        //User_Information.class에서 받은 내용 -> result.class까지 전달해주기
        Intent intent = getIntent();
        String user_name = intent.getStringExtra("name"); //이름
        String user_gender = intent.getStringExtra("gender"); //성별


        //다음 문항으로 넘어가는 버튼
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //모든 질문에 응답했을 경우 다음 문항으로 넘어감
                if(response1==1&&response2==2&&response3==3) {
                    Intent intent_1 = new Intent(getApplicationContext(), question_2.class);
                    cul(); //네 아니오에 대한 각 문항에 대한 값들 계산해줌
                    intent_1.putExtra("name", user_name); //이름
                    intent_1.putExtra("gender", user_gender); //성별
                    intent_1.putExtra("number", number); //문항 답 '네'의 값
                    intent_1.putExtra("number2", number2); //문항 답 '아니오'의 값
                    startActivity(intent_1);
                    finish();

                    //모든 질문에 응답을 안했을 경우 대화상자 불러옴
                } else if(response1==0||response2==0||response3==0){
                    AlertDialog.Builder dlg = new AlertDialog.Builder(question_1.this);
                    dlg.setMessage("모두 응답해주세요!");
                    dlg.setPositiveButton("넹", null);
                    dlg.show();
                }
            }
        });
    }

    //선택한 네, 아니오에 대한 값 계산 -> 이 값에 따라서 대학생활 유형이 다르게 나옴.
    public void cul (){
        int checkedRadio1 = radiogroup1.getCheckedRadioButtonId();
        RadioButton rb = (RadioButton)findViewById(checkedRadio1);
        if (rb.getText().toString().equals("네")){
            number = number + 1;
        }else{
            number2 = number2 + 1;
        }

        int checkedRadio2 = radiogroup2.getCheckedRadioButtonId();
        RadioButton rb2 = (RadioButton)findViewById(checkedRadio2);
        if (rb2.getText().toString().equals("네")){
            number =number+ 1;
        }else{
            number2 = number2+ 1;
        }

        int checkedRadio3 = radiogroup3.getCheckedRadioButtonId();
        RadioButton rb3 = (RadioButton)findViewById(checkedRadio3);
        if (rb3.getText().toString().equals("네")){
            number =number+ 1;
        }else{
            number2 =number2+ 1;
        }
    }

}