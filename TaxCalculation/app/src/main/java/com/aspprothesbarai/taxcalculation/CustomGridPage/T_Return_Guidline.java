package com.aspprothesbarai.taxcalculation.CustomGridPage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.aspprothesbarai.taxcalculation.R;

public class T_Return_Guidline extends AppCompatActivity {
    private WebView readWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES,WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES);
        this.getSupportActionBar().hide();
        this.getWindow().setStatusBarColor(getResources().getColor(R.color.orange));
        this.getWindow().setNavigationBarColor(getResources().getColor(R.color.orange));
        setContentView(R.layout.treturn_guidline);


        readWeb = findViewById(R.id.readWeb);
        readWeb.getSettings().setJavaScriptEnabled(true);
        readWeb.setWebChromeClient(new WebChromeClient());
        readWeb.setWebViewClient(new WebViewClient());
        readWeb.loadUrl(getString(R.string.tax_return_guidline));


    }
}