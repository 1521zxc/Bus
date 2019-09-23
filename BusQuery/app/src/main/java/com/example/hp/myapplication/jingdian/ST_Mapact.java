package com.example.hp.myapplication.jingdian;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.example.hp.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ST_Mapact extends Activity {
    @BindView(R.id.situ_map)
    MapView situMap;
    private AMap aMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.st_lay_map);
        ButterKnife.bind(this);
//        mapView = (MapView) findViewById(R.id.situ_map);
        situMap.onCreate(savedInstanceState);
        if (aMap == null) {
            aMap = situMap.getMap();
            addMarker();
        }
    }

    private void addMarker() {
        aMap.addMarker(new MarkerOptions()//添加标记
                .position(new LatLng(35.52314,112.894959))//图标的位置
                .draggable(true)//可拖拽
                .title("司徒小镇"));
        aMap.moveCamera(CameraUpdateFactory.zoomTo(13));//经纬度位置的缩放比
        aMap.moveCamera(CameraUpdateFactory.changeLatLng(new LatLng(35.52314,112.894959)));//定位的当前经纬度位置
    }

    @Override
    public void onResume() {
        super.onResume();
        situMap.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        situMap.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        situMap.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        situMap.onDestroy();
    }



}
