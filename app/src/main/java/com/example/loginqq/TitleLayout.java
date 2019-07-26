package com.example.loginqq;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class TitleLayout extends LinearLayout implements View.OnClickListener {
    private Button titleExit;

    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title,this);
        titleExit = findViewById(R.id.title_exit);
        titleExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.title_exit:
                System.exit(0);
                break;
        }
    }
}
