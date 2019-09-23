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

public class HcxfAct extends AppCompatActivity {
    @BindView(R.id.bus_main_title)
    TextView busMainTitle;
    @BindView(R.id.im_fir_hcxf)
    MyImageView imFirHcxf;
    @BindView(R.id.hcxf_btn)
    Button hcxfBtn;
    private AMap aMap;
    private MapView hcxfMap;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hcxf_act_lay);
        ButterKnife.bind(this);
        init();
        hcxfMap = findViewById(R.id.hcxf_map);
        hcxfMap.onCreate(savedInstanceState);
        if (aMap == null) {
            aMap = hcxfMap.getMap();
            addMarker();
        }
    }
    private void addMarker() {
        aMap.addMarker(new MarkerOptions()//添加标记
                .position(new LatLng(35.5139900000, 112.5824500000))//图标的位置
                .draggable(true)//可拖拽
                .title("皇城相府"));
        aMap.moveCamera(CameraUpdateFactory.zoomTo(13));//经纬度位置的缩放比
        aMap.moveCamera(CameraUpdateFactory.changeLatLng(new LatLng(35.5139900000, 112.5824500000)));//定位的当前经纬度位置
    }

    @Override
    public void onResume() {
        super.onResume();
        hcxfMap.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        hcxfMap.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        hcxfMap.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        hcxfMap.onDestroy();
    }

    private void init() {
        hcxfBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HcxfAct.this, "订票成功", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
