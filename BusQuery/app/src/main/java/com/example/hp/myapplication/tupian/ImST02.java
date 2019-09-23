package com.example.hp.myapplication.tupian;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hp.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImST02 extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.lin_st02)
    LinearLayout linSt02;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_st02_img);
        ButterKnife.bind(this);
        init();
    }

    private void init() {

        linSt02.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.lin_st02:
                finish();
                break;
        }
    }
}
