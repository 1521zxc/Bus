package com.example.hp.myapplication.act;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.hp.myapplication.BusMainActivity;
import com.example.hp.myapplication.R;
import com.example.hp.myapplication.Textview.MyTextView;
import com.example.hp.myapplication.util.Util;



import static com.example.hp.myapplication.util.App.getContext;

public class Jyfk extends Activity {
    private EditText textview3;
    private EditText textview4;
    private EditText textview5;
    private ImageView back01;
    private MyTextView wdxj;
    private Button btn_yijian;
    private Notification notification;
    private NotificationManager nm;
    private Notification myNotification;
    private NotificationManager myManager;
    private static final int NOTIFICATION_ID_1 = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fg3jianyi);
        initView();
    }
    private void initView() {
        textview3 = findViewById(R.id.textview3);
        textview4 = findViewById(R.id.textview4);
        textview5 = findViewById(R.id.textview5);
        back01 = findViewById(R.id.back01);
        wdxj = findViewById(R.id.wdxj);
  back01.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          finish();
      }
  });
        wdxj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              startActivity(new Intent(Jyfk.this,WDXJ.class));
            }
        });
        btn_yijian = findViewById(R.id.btn_yijian);
        btn_yijian.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                submit();
                if (!zhengze(textview5.getText().toString())) {
                    Toast.makeText(getContext(), "格式错误", Toast.LENGTH_SHORT).show();
                    return;
                }
                Util.sp_put("name",textview3.getText().toString());
                Util.sp_put("con",textview4.getText().toString());
                Util.sp_put("phone",textview5.getText().toString());
                send("建议反馈内容：",textview3.getText().toString(),textview4.getText().toString(),textview5.getText().toString(),1);
                Toast.makeText(getContext(), "成功", Toast.LENGTH_SHORT).show();
                finish();

            }
        });
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void send(String title, String name, String content, String phone, int i) {
        Intent intent = new Intent(getContext(), WDXJ.class);
        intent.putExtra("kk", 1);
        PendingIntent pend = PendingIntent.getActivity(getContext(), 201, intent, PendingIntent.FLAG_UPDATE_CURRENT);


        myManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Notification.Builder myBuilder = new Notification.Builder(getContext());
        myBuilder.setContentTitle(title)
                .setContentText("用户名："+name+"  ,  反馈内容：" + content+ "  ,  电话+:" + phone)
                .setTicker("您收到新的消息")
                //设置状态栏中的小图片，尺寸一般建议在24×24，这个图片同样也是在下拉状态栏中所显示
                .setSmallIcon(R.mipmap.ic_launcher)
                //设置默认声音和震动
                .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE)
                .setAutoCancel(true)//点击后取消
                .setWhen(System.currentTimeMillis())//设置通知时间
                .setPriority(Notification.PRIORITY_HIGH)//高优先级
                .setVisibility(Notification.VISIBILITY_PUBLIC)
                //android5.0加入了一种新的模式Notification的显示等级，共有三种：
                //VISIBILITY_PUBLIC  只有在没有锁屏时会显示通知
                //VISIBILITY_PRIVATE 任何情况都会显示通知
                //VISIBILITY_SECRET  在安全锁和没有锁屏的情况下显示通知
                .setContentIntent(pend);  //3.关联PendingIntent
        myNotification = myBuilder.build();
        //4.通过通知管理器来发起通知，ID区分通知
        myManager.notify(NOTIFICATION_ID_1, myNotification);

    }

    private boolean zhengze(String c) {
        String n = "^((1[3,5,7,8][0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
        if (TextUtils.isEmpty(c)) {
            return false;
        } else {
            return c.matches(n);
        }
    }

    private void submit() {
        // validate
        String textview3String = textview3.getText().toString().trim();
        if (TextUtils.isEmpty(textview3String)) {
            Toast.makeText(getContext(), "标题", Toast.LENGTH_SHORT).show();
            return;
        }

        String textview4String = textview4.getText().toString().trim();
        if (TextUtils.isEmpty(textview4String)) {
            Toast.makeText(getContext(), "请输入您的意见", Toast.LENGTH_SHORT).show();
            return;
        }

        String textview5String = textview5.getText().toString().trim();
        if (TextUtils.isEmpty(textview5String)) {
            Toast.makeText(getContext(), "phone", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
    public static class WDXJ extends Activity {
        private TextView tv1;
        private TextView tv2;
        private TextView tv3;
        private ImageView backcx;



        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.wdyj);


            initView();
        }


        private void initView() {
            String name = (String) Util.sp_get("name", "");
            String con = (String) Util.sp_get("con", "");
            String phone = (String) Util.sp_get("phone", "");
            Log.d( "initView",phone+"");
            tv1 =  findViewById(R.id.tv1);
            tv2 = findViewById(R.id.tv2);
            tv3 = findViewById(R.id.tv3);
            backcx = findViewById(R.id.back_cx);
            tv1.setText("标题:"+name);
            tv2.setText("内容:"+con);
            tv3.setText("phone:"+phone);
backcx.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        finish();
    }
});

        }
    }

}
