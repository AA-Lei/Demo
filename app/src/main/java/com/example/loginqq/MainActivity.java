package com.example.loginqq;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private EditText editTextname;
    private EditText editTextpassword;
    private ProgressBar progressBar;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextname = findViewById(R.id.edit_name);
        editTextpassword = findViewById(R.id.edit_password);
        button1 = findViewById(R.id.button_zhuce);
        button2 = findViewById(R.id.jdt);
        button3 = findViewById(R.id.AD);
        button4 = findViewById(R.id.PD);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        //隐藏标题
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
        intit();
        progressBar = findViewById(R.id.progress_bar);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "you click add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_tiem:
                Toast.makeText(this, "you click remove", Toast.LENGTH_SHORT).show();
                break;

        }
        return true;
    }

    private void alert() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("this is AlertDialog");
        dialog.setMessage("关闭程序吗");
        dialog.setCancelable(false);
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                System.exit(0);

            }
        });
        dialog.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }

    private void intit() {
        Intent intent = getIntent();
        String result = intent.getStringExtra("textname");
        String result2 = intent.getStringExtra("textpassword") ;
        if(result!=null && result2!=null)
            editTextname.setText(result);
            editTextpassword.setText(result2);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_zhuce:
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
                break;
            case R.id.jdt:
                if(progressBar.getVisibility() == View.GONE){
                    progressBar.setVisibility(View.VISIBLE);
                }else{
                    progressBar.setVisibility(View.GONE);
                }
                break;
            case R.id.AD:
                alert();
                break;
            case R.id.PD:
                progressdialog();
        }
    }

    private void progressdialog() {
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("this is progressDialog");
        progressDialog.setMessage("Loading");
        progressDialog.setCancelable(true);
        progressDialog.show();
    }
}

