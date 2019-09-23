package com.example.hp.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.hp.myapplication.Textview.MyTextView;
import com.example.hp.myapplication.act.Jyfk;
import com.example.hp.myapplication.act.News;
import com.example.hp.myapplication.frament.BusFirstfunciton;
import com.example.hp.myapplication.frament.BusSecondfunciton;
import com.example.hp.myapplication.frament.BusThirdfunciton;
import com.example.hp.myapplication.viewpager.MyViewPager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BusMainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.busmain_viewpar)
    MyViewPager busmainViewpar;
    @BindView(R.id.busmain_first_function)
    TextView busmainFirstFunction;
    @BindView(R.id.busmain_two_function)
    TextView busmainTwoFunction;
    @BindView(R.id.busmain_three_function)
    TextView busmainThreeFunction;
    @BindView(R.id.bus_main_title)
    TextView busMainTitle;
    @BindView(R.id.im_busmain_first_function)
    ImageView imBusmainFirstFunction;
    @BindView(R.id.im_busmain_two_function)
    ImageView imBusmainTwoFunction;
    @BindView(R.id.im_busmain_three_function)
    ImageView imBusmainThreeFunction;
    @BindView(R.id.bus_main_jy)
    MyTextView busMainJy;
    @BindView(R.id.bus_main_xinwen)
    MyTextView busMainXinwen;
    @BindView(R.id.main_gy)
    TextView mainGy;
    private ArrayList<Fragment> list;
    private String[] titles = {"晋城天气", "公交查询", "旅游景点推荐"};
    int pos = 0;
    private long firstTime = 0;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        busmainFirstFunction.setOnClickListener(this);
        busmainTwoFunction.setOnClickListener(this);
        busmainThreeFunction.setOnClickListener(this);
        busMainXinwen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BusMainActivity.this, News.class));
            }
        });
        busMainJy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BusMainActivity.this, Jyfk.class));
            }
        });
        list = new ArrayList<>();
        list.add(new BusFirstfunciton());
        list.add(new BusSecondfunciton());
        list.add(new BusThirdfunciton());
//引用viewpager
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }
        };

        busmainViewpar.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pos = position;
                busMainTitle.setText(titles[position]);
                busmainViewpar.setCurrentItem(position);
                if (position == 0) {
                    busmainFirstFunction.setTextColor(Color.BLUE);
                    busmainTwoFunction.setTextColor(Color.BLACK);
                    imBusmainFirstFunction.setImageResource(R.drawable.ic_cloud_wea);
                    imBusmainTwoFunction.setImageResource(R.drawable.ic_search_black);
                    imBusmainThreeFunction.setImageResource(R.drawable.ic_store_scenic_spot1);
                    busmainThreeFunction.setTextColor(Color.BLACK);
                } else if (position == 1) {
                    busmainTwoFunction.setTextColor(Color.BLUE);
                    imBusmainFirstFunction.setImageResource(R.drawable.ic_cloud_queue_wea_black);
                    imBusmainTwoFunction.setImageResource(R.drawable.ic_search_blue);
                    imBusmainThreeFunction.setImageResource(R.drawable.ic_store_scenic_spot1);
                    busmainFirstFunction.setTextColor(Color.BLACK);
                } else {
                    imBusmainFirstFunction.setImageResource(R.drawable.ic_cloud_queue_wea_black);
                    imBusmainTwoFunction.setImageResource(R.drawable.ic_search_black);
                    imBusmainThreeFunction.setImageResource(R.drawable.ic_store_scenic_spot);
                    busmainThreeFunction.setTextColor(Color.BLUE);
                    busmainFirstFunction.setTextColor(Color.BLACK);
                    busmainTwoFunction.setTextColor(Color.BLACK);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        busmainViewpar.setCurrentItem(0);
        busmainViewpar.setAdapter(adapter);
        imBusmainFirstFunction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                busmainViewpar.setCurrentItem(0);
                busMainTitle.setText(titles[0]);
                imBusmainFirstFunction.setImageResource(R.drawable.ic_cloud_wea);
                imBusmainTwoFunction.setImageResource(R.drawable.ic_search_black);
                imBusmainThreeFunction.setImageResource(R.drawable.ic_store_scenic_spot1);
                busmainFirstFunction.setTextColor(Color.BLUE);
                busmainTwoFunction.setTextColor(Color.BLACK);
                busmainThreeFunction.setTextColor(Color.BLACK);
            }
        });
        imBusmainTwoFunction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                busmainViewpar.setCurrentItem(1);
                busMainTitle.setText(titles[1]);
                imBusmainFirstFunction.setImageResource(R.drawable.ic_cloud_queue_wea_black);
                imBusmainTwoFunction.setImageResource(R.drawable.ic_search_blue);
                imBusmainThreeFunction.setImageResource(R.drawable.ic_store_scenic_spot1);
                busmainTwoFunction.setTextColor(Color.BLUE);
                busmainFirstFunction.setTextColor(Color.BLACK);
                busmainThreeFunction.setTextColor(Color.BLACK);
            }
        });
        imBusmainThreeFunction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                busmainViewpar.setCurrentItem(2);
                busMainTitle.setText(titles[2]);
                imBusmainFirstFunction.setImageResource(R.drawable.ic_cloud_queue_wea_black);
                imBusmainTwoFunction.setImageResource(R.drawable.ic_search_black);
                imBusmainThreeFunction.setImageResource(R.drawable.ic_store_scenic_spot);
                busmainThreeFunction.setTextColor(Color.BLUE);
                busmainFirstFunction.setTextColor(Color.BLACK);
                busmainTwoFunction.setTextColor(Color.BLACK);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.busmain_first_function:
                busmainViewpar.setCurrentItem(0);
                busMainTitle.setText(titles[0]);
                busmainFirstFunction.setTextColor(Color.BLUE);
                busmainTwoFunction.setTextColor(Color.BLACK);
                busmainThreeFunction.setTextColor(Color.BLACK);
                imBusmainFirstFunction.setImageResource(R.drawable.ic_cloud_wea);
                imBusmainTwoFunction.setImageResource(R.drawable.ic_search_black);
                imBusmainThreeFunction.setImageResource(R.drawable.ic_store_scenic_spot1);
                break;
            case R.id.busmain_two_function:
                busmainViewpar.setCurrentItem(1);
                busMainTitle.setText(titles[1]);
                imBusmainFirstFunction.setImageResource(R.drawable.ic_cloud_queue_wea_black);
                imBusmainTwoFunction.setImageResource(R.drawable.ic_search_blue);
                imBusmainThreeFunction.setImageResource(R.drawable.ic_store_scenic_spot1);
                busmainTwoFunction.setTextColor(Color.BLUE);
                busmainFirstFunction.setTextColor(Color.BLACK);
                busmainThreeFunction.setTextColor(Color.BLACK);
                break;
            case R.id.busmain_three_function:
                busmainViewpar.setCurrentItem(2);
                busMainTitle.setText(titles[2]);
                imBusmainFirstFunction.setImageResource(R.drawable.ic_cloud_queue_wea_black);
                imBusmainTwoFunction.setImageResource(R.drawable.ic_search_black);
                imBusmainThreeFunction.setImageResource(R.drawable.ic_store_scenic_spot);
                busmainThreeFunction.setTextColor(Color.BLUE);
                busmainFirstFunction.setTextColor(Color.BLACK);
                busmainTwoFunction.setTextColor(Color.BLACK);
                break;

        }
    }

    //退出
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {

            long secondTime = System.currentTimeMillis();

            if (secondTime - firstTime > 2000) {
                Toast.makeText(BusMainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                firstTime = secondTime;
                return true;
            } else {

                finish();
            }
        }
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent i = new Intent(Intent.ACTION_MAIN);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.addCategory(Intent.CATEGORY_HOME);
            startActivity(i);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    @OnClick(R.id.main_gy)
    public void onViewClicked() {

            dialogs();


        }
    private void dialogs(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
         builder.setTitle("代码所在地：");
         builder.setMessage("https://github.com/1521zxc/Bus");
         builder.setNegativeButton("确定",null);
         builder.setPositiveButton("取消",null);
        alertDialog = builder.create();
        builder.setCancelable(false);

        builder.show();
    }

}
