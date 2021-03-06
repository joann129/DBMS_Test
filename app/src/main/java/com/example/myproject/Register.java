package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class Register extends AppCompatActivity {

    private EditText et_name;
    private EditText et_floor;
    private EditText et_roomNum;
    private  EditText et_phoneNum;
    private  EditText et_reg_passwd;
    private  EditText et_reg_passwd_check;
    private Button btn_go;

    private String name ;
    private String floor;
    private String roomNum ;
    private String phoneNum ;
    private String reg_passwd;
    private String reg_passwd_check;
    private int passwd_flag;

    private String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_name = (EditText)findViewById(R.id.et_name);
        et_floor = (EditText)findViewById(R.id.et_floor);
        et_roomNum = (EditText)findViewById(R.id.et_roomNum);
        et_phoneNum = (EditText)findViewById(R.id.et_phoneNum);
        et_reg_passwd = (EditText)findViewById(R.id.et_reg_passwd);
        et_reg_passwd_check = (EditText)findViewById(R.id.et_reg_passwd_check);
        btn_go = (Button) findViewById(R.id.btn_go);

        name = et_name.getText().toString();
        floor = et_floor.getText().toString();
        roomNum = et_roomNum.getText().toString();
        phoneNum = et_phoneNum.getText().toString();
        reg_passwd = et_reg_passwd.getText().toString();
        reg_passwd_check = et_reg_passwd_check.getText().toString();
        passwd_flag = 1;

        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Thread thread = new Thread(mutiThread);
//                thread.start();
                if(reg_passwd.equals(reg_passwd_check)){
                    passwd_flag = 0;
                } ////////else if(如果房號不存在於資料庫)
                else {
                    //////將所有資料存到資料庫裡////////
                    Intent intent = new Intent(Register.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        if(passwd_flag == 0){
            Toast.makeText(this, "重複輸入密碼錯誤", Toast.LENGTH_LONG).show();
        }



    }

}
