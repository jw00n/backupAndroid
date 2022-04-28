package com.example.ex220322;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class Fragment1 extends Fragment {

    WebView webView;

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_1, container, false);

        webView = view.findViewById(R.id.webView);
        //주소 이동기능으로 쓰면 좋겠구나
        // 안드로이드에 저장된 mySDF 파일에 접근하여 url값을 읽어오기
        String url= getActivity().
                getSharedPreferences("mySDF", Context.MODE_PRIVATE).
                getString("url", "https://www.google.com"); //디폴트값


        WebSettings settings = webView.getSettings();

        settings.setJavaScriptEnabled(true);//자바스크립트 사용가능

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);

        return view;
    }
}