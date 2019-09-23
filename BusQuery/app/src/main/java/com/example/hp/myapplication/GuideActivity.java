package com.example.hp.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hp.myapplication.frament.GuideFragment;
import com.example.hp.myapplication.util.Util;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuideActivity extends AppCompatActivity {


    @BindView(R.id.gudie_cont)
    RelativeLayout gudieCont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);

        Isfistrun();
    }

    /**
     * 判断用户是否第一次打开APP
     */
    private void Isfistrun() {

        boolean isFirst = (boolean) Util.sp_get("isFirst", true);

        if (isFirst) {
            //用户首次启动APP 引导界面
            getSupportFragmentManager().beginTransaction().replace(R.id.gudie_cont, new GuideFragment()).commit();
            Util.sp_put("isFirst", false);
        } else {
            //用户非首次启动APP
            startanimode();
        }
    }

    private void startanimode() {
        gudieCont.setAnimation(AnimationUtils.loadAnimation(this, R.anim.guide_start_animator));
        //3秒后进入登录界面
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(GuideActivity.this, BusMainActivity.class));
                finish();
            }
        }, 1500);

    }

}
