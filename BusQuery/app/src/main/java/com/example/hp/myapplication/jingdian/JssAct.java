package com.example.hp.myapplication.jingdian;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.example.hp.myapplication.R;
import com.example.hp.myapplication.imgview.MyImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JssAct extends AppCompatActivity {
    @BindView(R.id.bus_main_title)
    TextView busMainTitle;
    @BindView(R.id.im_fir_hcxf)
    MyImageView imFirHcxf;
    @BindView(R.id.jss_btn)
    Button jssBtn;
    private MapView jssMap;
    private AMap aMap;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jss_act_lay);
        ButterKnife.bind(this);
        init();
        jssMap = findViewById(R.id.jss_map);
        jssMap.onCreate(savedInstanceState);
        if (aMap == null) {
            aMap = jssMap.getMap();
            addMarker();
        }
    }
    private void addMarker() {
        aMap.addMarker(new MarkerOptions()//添加标记
                .position(new LatLng(35.321649,112.87882))//图标的位置
//        112.87882,35.321649
                .draggable(true)//可拖拽
                .title("聚寿山"));
        aMap.moveCamera(CameraUpdateFactory.zoomTo(13));//经纬度位置的缩放比
        aMap.moveCamera(CameraUpdateFactory.changeLatLng(new LatLng(35.3216490,112.87882)));//定位的当前经纬度位置
    }

    @Override
    public void onResume() {
        super.onResume();
        jssMap.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        jssMap.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        jssMap.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        jssMap.onDestroy();
    }


    private void init() {
        jssBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(JssAct.this, "订票成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
