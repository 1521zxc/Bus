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

public class MhAct extends AppCompatActivity {
    @BindView(R.id.bus_main_title)
    TextView busMainTitle;
    @BindView(R.id.im_fir_hcxf)
    MyImageView imFirHcxf;
    @BindView(R.id.mh_btn)
    Button mhBtn;
    private AMap aMap;
    private MapView mhMap;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mh_act_lay);
        ButterKnife.bind(this);
        init();
        mhMap = findViewById(R.id.mh_map);
        mhMap.onCreate(savedInstanceState);
        if (aMap == null) {
            aMap = mhMap.getMap();
            addMarker();
        }
    }
    private void addMarker() {
        aMap.addMarker(new MarkerOptions()//添加标记
                .position(new LatLng(35.255459,112.441107))//图标的位置
                .draggable(true)//可拖拽
                .title("蟒河"));
        aMap.moveCamera(CameraUpdateFactory.zoomTo(13));//经纬度位置的缩放比
        aMap.moveCamera(CameraUpdateFactory.changeLatLng(new LatLng(35.255459,112.441107)));//定位的当前经纬度位置
    }

    @Override
    public void onResume() {
        super.onResume();
        mhMap.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mhMap.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mhMap.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mhMap.onDestroy();
    }

    private void init() {
        mhBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MhAct.this, "订票成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
