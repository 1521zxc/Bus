package com.example.hp.myapplication.tupian;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hp.myapplication.R;
import com.example.hp.myapplication.imgview.MyImageView;

import butterknife.BindView;
import butterknife.ButterKnife;



public class ImHCXFact extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.lin_hcxf)
    LinearLayout linHcxf;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_hcxf_img);
        ButterKnife.bind(this);
        init();
    }

    private void init() {

        linHcxf.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.lin_hcxf:
                finish();
                break;
        }
    }
}
