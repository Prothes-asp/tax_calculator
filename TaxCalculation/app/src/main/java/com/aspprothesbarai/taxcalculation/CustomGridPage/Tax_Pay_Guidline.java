package com.aspprothesbarai.taxcalculation.CustomGridPage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.aspprothesbarai.taxcalculation.R;

public class Tax_Pay_Guidline extends AppCompatActivity {
    private WebView webView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES,WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES);
        this.getSupportActionBar().hide();
        this.getWindow().setNavigationBarColor(getResources().getColor(R.color.orange));
        this.getWindow().setStatusBarColor(getResources().getColor(R.color.orange));
        setContentView(R.layout.tax_pay_guidline);

        webView2 = findViewById(R.id.webView2);
        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.setWebViewClient(new WebViewClient());
        webView2.setWebChromeClient(new WebChromeClient());
        webView2.loadUrl(getString(R.string.tax_payment_vedio_url));

    }
}