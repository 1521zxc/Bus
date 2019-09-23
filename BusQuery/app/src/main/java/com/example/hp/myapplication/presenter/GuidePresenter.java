package com.example.hp.myapplication.presenter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.example.hp.myapplication.R;
import com.example.hp.myapplication.adapter.GuideViewPagerAdatapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzh on 2018/5/27.
 */

public class GuidePresenter implements GuidePresenterInterface {

    private ImageView imageView;

    public GuidePresenter() {
    }


    @Override
    public boolean Isfist() {
        return false;
    }

    /**
     * @param viewPager    滑动引导
     * @param linearLayout 加载图片的点布局
     */
    @Override
    public void setviewpagerimgs(ViewPager viewPager, LinearLayout linearLayout , Context context) {
        Boolean fist  =  true  ;
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(35, 35);
        List<View>  list    =  new ArrayList<>();
        int[] guideImgsid = {R.drawable.fm,R.drawable.two,R.drawable.three};

        for (  int imgid:guideImgsid){

            if (fist){
                params.setMargins(10,0,0,0);

            }else {
                params.setMargins(10,0,0,0);

            }
            fist=false;
            imageView = new ImageView(context);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
            imageView.setLayoutParams(layoutParams);
            imageView.setBackgroundResource(imgid);
            list.add(imageView);
            View  view  = new View(context);
            view.setLayoutParams(params);
            view.setBackgroundResource(R.drawable.pain_noselect);
            linearLayout.addView(view);
        }
        linearLayout.getChildAt(0).setBackgroundResource(R.drawable.pain_select);


        viewPager.setAdapter(new GuideViewPagerAdatapter(list));

    }

    /**
     * 设置用户不是首次进入APP的引导
     *
     * @param viewPager
     */
    @Override
    public void setviewpagerimg(ViewPager viewPager) {

    }

    @Override
    public void setversion(TextView textViewversion) {

    }
}
