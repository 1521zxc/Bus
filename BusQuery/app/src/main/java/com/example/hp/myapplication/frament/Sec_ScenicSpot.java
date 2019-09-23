package com.example.hp.myapplication.frament;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.hp.myapplication.R;
import com.example.hp.myapplication.jingdian.JsAct;
import com.example.hp.myapplication.jingdian.JssAct;
import com.example.hp.myapplication.jingdian.TgwfAct;
import com.example.hp.myapplication.tupian.ImHCXFact;
import com.example.hp.myapplication.tupian.ImJSSact;
import com.example.hp.myapplication.tupian.ImJSact;
import com.example.hp.myapplication.tupian.ImTGWFact;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Sec_ScenicSpot extends Fragment implements View.OnClickListener {
    @BindView(R.id.sec_js)
    TextView secJs;

    @BindView(R.id.sec_tgwf)
    TextView secTgwf;

    @BindView(R.id.sec_jss)
    TextView secJss;

    Unbinder unbinder;
    @BindView(R.id.im_sec_js)
    ImageView imSecJs;
    @BindView(R.id.im_sec_tgwf)
    ImageView imSecTgwf;
    @BindView(R.id.im_sec_jss)
    ImageView imSecJss;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sec_scenicspot,container,false);
        unbinder = ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {
        secJs.setOnClickListener(this);
        secJss.setOnClickListener(this);
        secTgwf.setOnClickListener(this);
        imSecJs.setOnClickListener(this);
        imSecJss.setOnClickListener(this);
        imSecTgwf.setOnClickListener(this);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sec_js:
                startActivity(new Intent(getActivity(), JsAct.class));
                break;
            case R.id.sec_jss:
                startActivity(new Intent(getActivity(), JssAct.class));
                break;
            case R.id.sec_tgwf:
                startActivity(new Intent(getActivity(), TgwfAct.class));
                break;
            case R.id.im_sec_js:
                startActivity(new Intent(getActivity(), ImJSact.class));
                break;
            case R.id.im_sec_jss:
                startActivity(new Intent(getActivity(), ImJSSact.class));
                break;
            case R.id.im_sec_tgwf:
                startActivity(new Intent(getActivity(), ImTGWFact.class));
                break;

        }
    }
}
