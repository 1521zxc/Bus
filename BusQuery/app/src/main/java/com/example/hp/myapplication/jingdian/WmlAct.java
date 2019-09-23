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

public class WmlAct extends AppCompatActivity {
    @BindView(R.id.bus_main_title)
    TextView busMainTitle;
    @BindView(R.id.im_fir_hcxf)
    MyImageView imFirHcxf;
    @BindView(R.id.wml_btn)
    Button wmlBtn;

    private AMap aMap;
    private MapView wmlMap;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wml_act_lay);
        ButterKnife.bind(this);
        init();
        wmlMap = findViewById(R.id.wml_map);
        wmlMap.onCreate(savedInstanceState);
        if (aMap == null) {
            aMap = wmlMap.getMap();
            addMarker();
        }
    }
    private void addMarker() {
        aMap.addMarker(new MarkerOptions()//添加标记
                .position(new LatLng(35.6915900000, 113.5868000000))//图标的位置
                .draggable(true)//可拖拽
                .title("王莽岭"));
        aMap.moveCamera(CameraUpdateFactory.zoomTo(13));//经纬度位置的缩放比
        aMap.moveCamera(CameraUpdateFactory.changeLatLng(new LatLng(35.6915900000, 113.5868000000)));//定位的当前经纬度位置
    }

    @Override
    public void onResume() {
        super.onResume();
        wmlMap.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        wmlMap.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        wmlMap.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        wmlMap.onDestroy();
    }

    private void init() {
        wmlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(WmlAct.this, "订票成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
