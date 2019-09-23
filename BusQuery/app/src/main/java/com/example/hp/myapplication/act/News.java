package com.example.hp.myapplication.act;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hp.myapplication.R;
import com.example.hp.myapplication.Textview.MyTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class News extends AppCompatActivity {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.text_beginLoading)
    MyTextView textBeginLoading;
    @BindView(R.id.text_Loading)
    MyTextView textLoading;

    @BindView(R.id.webView1)
    WebView webView1;
    WebSettings WebSetting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_news);
        ButterKnife.bind(this);
        WebSetting = webView1.getSettings();
//        webView1.loadUrl("http://news.baidu.com/");
        webView1.loadUrl("http://www.sxrb.com/");


        webView1.getSettings().setSupportZoom(true);
//设置出现缩放工具
        webView1.getSettings().setBuiltInZoomControls(true);
//扩大比例的缩放
        webView1.getSettings().setUseWideViewPort(true);

//        init();
        webView1.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        //设置WebChromeClient类
        webView1.setWebChromeClient(new WebChromeClient() {


            //获取网站标题
            @Override
            public void onReceivedTitle(WebView view, String title1) {
                System.out.println("标题在这里");
                title.setText(title1);
            }


            //获取加载进度
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress < 100) {
                    String progress = newProgress + "%";
                    textLoading.setVisibility(View.VISIBLE);

                    textLoading.setText(progress);
                } else if (newProgress == 100) {
                    String progress = newProgress + "%";
                    textLoading.setText(progress);
                    textLoading.setVisibility(View.GONE);
                }
            }
        });


        //设置WebViewClient类
        webView1.setWebViewClient(new WebViewClient() {
            //设置加载前的函数
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                System.out.println("开始加载......");
                textBeginLoading.setText("开始加载......");

            }

            //设置结束加载函数
            @Override
            public void onPageFinished(WebView view, String url) {
                textBeginLoading.setText("加载完成!");

            }
        });

    }


    //点击返回上一页面而不是退出浏览器
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView1.canGoBack()) {
            webView1.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    //销毁Webview
    @Override
    protected void onDestroy() {
        if (webView1 != null) {
            webView1.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            webView1.clearHistory();

            ((ViewGroup) webView1.getParent()).removeView(webView1);
            webView1.destroy();
            webView1 = null;
        }
        super.onDestroy();
    }

}