package com.example.loginqq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button2;
    private Button button3;
    private EditText editTextname2;
    private EditText editTextpassword2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editTextname2 = findViewById(R.id.edit_name2);
        editTextpassword2 = findViewById(R.id.edit_password2);
        button2 = findViewById(R.id.button_back);
        button3 = findViewById(R.id.button_zhuce2);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.button_back:
                Intent intent3 = new Intent(SecondActivity.this,MainActivity.class);
                startActivity(intent3);
                break;
            case R.id.button_zhuce2:
                sendmessage();
                break;
        }
    }

    private void sendmessage() {
        String name = editTextname2.getText().toString();
        String password = editTextpassword2.getText().toString();
        if(!name.equals("") && !password.equals("")){
            Intent intent2 = new Intent(SecondActivity.this,MainActivity.class);
            intent2.putExtra("textname",name);
            intent2.putExtra("textpassword",password);
            startActivity(intent2);
        }else{
            String done = "注册未成功";
            Toast.makeText(SecondActivity.this,done,Toast.LENGTH_SHORT).show();
        }

    }

}
