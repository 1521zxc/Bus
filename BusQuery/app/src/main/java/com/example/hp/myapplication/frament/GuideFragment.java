package com.example.hp.myapplication.frament;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.hp.myapplication.BusMainActivity;
import com.example.hp.myapplication.R;
import com.example.hp.myapplication.presenter.GuidePresenter;
import com.example.hp.myapplication.presenter.GuidePresenterInterface;


public class GuideFragment extends Fragment implements ViewPager.OnPageChangeListener, View.OnClickListener {

    private ViewPager mViewpagerGuideFragmentGuideView;
    private LinearLayout mLlGuidpointFragmentGuideView;
    private GuidePresenterInterface guidePresenterInterface;

//    private ViewPager mViewpagerGuide;
//    private LinearLayout mLlGuidpoint;
    /**
     * 开始体验
     */
    private Button mBtGuidestart;

    public GuideFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guide, container, false);
        initView(view);
        initdata();
        initselect();
        return view;
    }

    private void initselect() {
        mViewpagerGuideFragmentGuideView.addOnPageChangeListener(this);
    }

    private void initdata() {
        guidePresenterInterface = new GuidePresenter();
        guidePresenterInterface.setviewpagerimgs(mViewpagerGuideFragmentGuideView, mLlGuidpointFragmentGuideView, getActivity());
    }

    private void initView(View view) {
        mViewpagerGuideFragmentGuideView =  view.findViewById(R.id.viewpager_guide);
        mLlGuidpointFragmentGuideView = view.findViewById(R.id.ll_guidpoint);
//        mViewpagerGuide = view.findViewById(R.id.viewpager_guide);
//        mLlGuidpoint = view.findViewById(R.id.ll_guidpoint);
        mBtGuidestart = view.findViewById(R.id.bt_guidestart);
        mBtGuidestart.setOnClickListener(this);
    }

    /**
     * This method will be invoked when the current page is scrolled, either as part
     * of a programmatically initiated smooth scroll or a user initiated touch scroll.
     *
     * @param position             Position index of the first page currently being displayed.
     *                             Page position+1 will be visible if positionOffset is nonzero.
     * @param positionOffset       Value from [0, 1) indicating the offset from the page at position.
     * @param positionOffsetPixels Value in pixels indicating the offset from position.
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    /**
     * This method will be invoked when a new page becomes selected. Animation is not
     * necessarily complete.
     *
     * @param position Position index of the new selected page.
     */
    @Override
    public void onPageSelected(int position) {
        setallpainBg();
        mLlGuidpointFragmentGuideView.getChildAt(position).setBackgroundResource(R.drawable.pain_select);
        if ((mLlGuidpointFragmentGuideView.getChildCount()-1)==position){
            mBtGuidestart.setVisibility(View.VISIBLE);
        }else {
            mBtGuidestart.setVisibility(View.GONE);
        }

    }

    /**
     * Called when the scroll state changes. Useful for discovering when the user
     * begins dragging, when the pager is automatically settling to the current page,
     * or when it is fully stopped/idle.
     *
     * @param state The new scroll state.
     * @see ViewPager#SCROLL_STATE_IDLE
     * @see ViewPager#SCROLL_STATE_DRAGGING
     * @see ViewPager#SCROLL_STATE_SETTLING
     */
    @Override
    public void onPageScrollStateChanged(int state) {

    }


    /**
     * 设置点全部未选中
     */
    void setallpainBg() {
        int childCount = mLlGuidpointFragmentGuideView.getChildCount();

        for (int i = 0; i < childCount; i++) {
            mLlGuidpointFragmentGuideView.getChildAt(i).setBackgroundResource(R.drawable.pain_noselect);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_guidestart:
                startActivity(new Intent(getActivity(), BusMainActivity.class));
                getActivity().finish();
                break;
        }
    }
}
