package com.example.hp.myapplication.frament;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.hp.myapplication.R;
import com.example.hp.myapplication.jingdian.ST_Mapact;
import com.example.hp.myapplication.jingdian.TgwfAct;
import com.example.hp.myapplication.tupian.ImJSact;
import com.example.hp.myapplication.tupian.ImST00;
import com.example.hp.myapplication.tupian.ImST01;
import com.example.hp.myapplication.tupian.ImST02;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Thi_ScenicSpot extends Fragment implements View.OnClickListener {
    @BindView(R.id.situ_btn)
    Button situBtn;
    Unbinder unbinder;
    @BindView(R.id.thi_situ)
    TextView thiSitu;
    @BindView(R.id.situ00)
    ImageView situ00;
    @BindView(R.id.situ01)
    ImageView situ01;
    @BindView(R.id.situ02)
    ImageView situ02;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.thi_scenicspot, container,false);
        unbinder = ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {
        situBtn.setOnClickListener(this);
        situ00.setOnClickListener(this);
        situ01.setOnClickListener(this);
        situ02.setOnClickListener(this);
        thiSitu.setOnClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.situ_btn:
                Toast.makeText(getContext(), "订票成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.thi_situ:
                startActivity(new Intent(getActivity(), ST_Mapact.class));
                break;
            case R.id.situ00:
                startActivity(new Intent(getActivity(), ImST00.class));
                break;
            case R.id.situ01:
                startActivity(new Intent(getActivity(), ImST01.class));
                break;
            case R.id.situ02:
                startActivity(new Intent(getActivity(), ImST02.class));
                break;
        }
    }
}
