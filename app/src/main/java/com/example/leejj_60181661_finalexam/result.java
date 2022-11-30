package com.example.leejj_60181661_finalexam;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class result extends AppCompatActivity {
    Button home;
    Button file_save;
    TextView username_st, gender_st;
    ImageView imageView5, imageView6, imageView7;
    BitmapDrawable drawable;
    Bitmap bitmap;
    int value = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //상태바 생략
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        setTitle("대학생활 유형탐구(이진주)");

        //sd카드에 접근 권한 물어보기
        ActivityCompat.requestPermissions(this, new String[] {
                Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        username_st = (TextView) findViewById(R.id.name_st);
        gender_st = (TextView) findViewById(R.id.gender_st);
        imageView5 = (ImageView) findViewById(R.id.imageView5); //만능
        imageView6 = (ImageView) findViewById(R.id.imageView6); //평범
        imageView7 = (ImageView) findViewById(R.id.imageView7); //관심없음
        home = (Button) findViewById(R.id.back_home);
        file_save = (Button) findViewById(R.id.save_result);

        //이름, 성별, 문항에 대한 값 받아오기
        Intent intent = getIntent();
        String user_name = intent.getStringExtra("name");
        String user_gender = intent.getStringExtra("gender");
        int good = intent.getIntExtra("number", 0);
        int bad = intent.getIntExtra("number2", 0);

        //사용자 응답에 따라 맞는 결과 결과 띄어주기
        username_st.setText(user_name + "님, 당신은");
        //'네' 응답이 많은 경우
        if (good > 7) {
            gender_st.setText("모든지 다 잘하는 " + user_gender + "입니다.");
            imageView5.setImageResource(R.drawable.goodresult);
            value = 1;
            imageView6.setVisibility(View.INVISIBLE);
            imageView7.setVisibility(View.INVISIBLE);

           //'아니오' 응답이 많은 경우
        } else if (bad > 7) {
            gender_st.setText("아무 것도 모르는 " + user_gender + "입니다.");
            imageView7.setImageResource(R.drawable.badresult);
            value = 2;
            imageView5.setVisibility(View.INVISIBLE);
            imageView6.setVisibility(View.INVISIBLE);

            // 그 외에 응답
        } else {
            gender_st.setText("청춘의 끝판왕 " + user_gender + "입니다.");
            imageView6.setImageResource(R.drawable.sosoresult);
            value = 3;
            imageView5.setVisibility(View.INVISIBLE);
            imageView7.setVisibility(View.INVISIBLE);
        }

        //결과 이미지 사용자 sd카드에 저장하는 버튼
        file_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //첫번째 대학 유형 사진 저장
                if(value==1){
                    drawable = (BitmapDrawable)imageView5.getDrawable();
                    bitmap = drawable.getBitmap();

                    FileOutputStream outputStream = null;

                    //sdcard에 저장
                    final String sdCard = Environment.getExternalStorageDirectory().getAbsolutePath();
                    final File directory = new File(sdCard + "/ResultImage");
                    directory.mkdir();

                    String fileName = String.format("%d.jpg", System.currentTimeMillis());
                    File outFile = new File(directory, fileName);

                    //이미지가 성공적으로 저장되었을 경우 Toast
                    Toast.makeText(getApplicationContext(), "이미지가 저장되었습니다.", Toast.LENGTH_SHORT).show();

                    try {
                        outputStream = new FileOutputStream(outFile);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                        outputStream.flush();
                        outputStream.close();

                        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                        intent.setData(Uri.fromFile(outFile));
                        sendBroadcast(intent);

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                //두번째 대학생활 유형 사진 저장
                else if(value==2){
                    drawable = (BitmapDrawable)imageView7.getDrawable();
                    bitmap = drawable.getBitmap();

                    FileOutputStream outputStream = null;

                    //sdcard에 저장
                    final String sdCard = Environment.getExternalStorageDirectory().getAbsolutePath();
                    final File directory = new File(sdCard + "/ResultImage");
                    directory.mkdir();

                    String fileName = String.format("%d.jpg", System.currentTimeMillis());
                    File outFile = new File(directory, fileName);

                    Toast.makeText(getApplicationContext(), "이미지가 저장되었습니다.", Toast.LENGTH_SHORT).show();

                    try {
                        outputStream = new FileOutputStream(outFile);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                        outputStream.flush();
                        outputStream.close();

                        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                        intent.setData(Uri.fromFile(outFile));
                        sendBroadcast(intent);

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                //3번째 대학생활 유형 저장
                else if(value==3){
                    drawable = (BitmapDrawable)imageView6.getDrawable();
                    bitmap = drawable.getBitmap();

                    FileOutputStream outputStream = null;

                    //sdcard에 저장
                    final String sdCard = Environment.getExternalStorageDirectory().getAbsolutePath();
                    final File directory = new File(sdCard + "/ResultImage");
                    directory.mkdir();

                    String fileName = String.format("%d.jpg", System.currentTimeMillis());
                    File outFile = new File(directory, fileName);

                    Toast.makeText(getApplicationContext(), "이미지가 저장되었습니다.", Toast.LENGTH_SHORT).show();

                    try {
                        outputStream = new FileOutputStream(outFile);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                        outputStream.flush();
                        outputStream.close();

                        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                        intent.setData(Uri.fromFile(outFile));
                        sendBroadcast(intent);

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        //처음으로 돌아가는 버튼
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }


}