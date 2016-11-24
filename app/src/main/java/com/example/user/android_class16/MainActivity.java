package com.example.user.android_class16;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView)findViewById(R.id.webView);
        initWebView();
    }
    public void initWebView(){
        WebViewClient client = new WebViewClient();
        webView.setWebViewClient(client);

        WebSettings settings = webView.getSettings();
        //開啟javascript功能
        settings.setJavaScriptEnabled(true);
        //增加一個javascriptInterface 去認識webview 並定義名稱ppking 前面為類別可以定義方法
        webView.addJavascriptInterface(new ppkingJS(),"ppking");
        //1.
        //webView.loadUrl("http://m.gamer.com.tw");
        //2.
        webView.loadUrl("file:///android_asset/ppking.html");
        //3.
        //webView.loadData("<h1>ppking2222</h1>","text/html","charset=utf-8");
    }

    //由android去控制webview網頁的javascript
    public void B1(View v){
        String name = "Bianca";
        webView.loadUrl("javascript:test1('"+ name + "')");
    }

    private class ppkingJS{
        @JavascriptInterface
        public void showUrName(String myname){
            Log.v("ppking", "OK: " + myname);
        }
    }
}
