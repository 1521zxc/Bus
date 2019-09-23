package com.example.hp.myapplication.frament;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.hp.myapplication.R;
import com.example.hp.myapplication.jingdian.HcxfAct;
import com.example.hp.myapplication.jingdian.MhAct;
import com.example.hp.myapplication.jingdian.WmlAct;
import com.example.hp.myapplication.tupian.ImHCXFact;
import com.example.hp.myapplication.tupian.ImMHact;
import com.example.hp.myapplication.tupian.ImWMLact;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Fir_ScenicSpot extends Fragment implements View.OnClickListener {
    @BindView(R.id.fir_hcxf)
    TextView firHcxf;

    @BindView(R.id.fir_wml)
    TextView firWml;

    @BindView(R.id.fir_mh)
    TextView firMh;

    Unbinder unbinder;
    @BindView(R.id.im_fir_hcxf)
    ImageView imFirHcxf;
    @BindView(R.id.im_fir_wml)
    ImageView imFirWml;
    @BindView(R.id.im_fir_mh)
    ImageView imFirMh;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fir_scenicspot, container,false);

        unbinder = ButterKnife.bind(this, view);

        firHcxf.setOnClickListener(this);
        firWml.setOnClickListener(this);
        firMh.setOnClickListener(this);
        imFirHcxf.setOnClickListener(this);
        imFirWml.setOnClickListener(this);
        imFirMh.setOnClickListener(this);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fir_hcxf:
                startActivity(new Intent(getActivity(), HcxfAct.class));
                break;
            case R.id.fir_wml:
                startActivity(new Intent(getActivity(), WmlAct.class));
                break;
            case R.id.fir_mh:
                startActivity(new Intent(getActivity(), MhAct.class));
                break;
            case R.id.im_fir_hcxf:
                startActivity(new Intent(getActivity(), ImHCXFact.class));
                break;
            case R.id.im_fir_wml:
                startActivity(new Intent(getActivity(), ImWMLact.class));
                break;
            case R.id.im_fir_mh:
                startActivity(new Intent(getActivity(), ImMHact.class));
                break;

        }

    }
}
