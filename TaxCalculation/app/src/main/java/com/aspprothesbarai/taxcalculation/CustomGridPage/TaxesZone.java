package com.aspprothesbarai.taxcalculation.CustomGridPage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.aspprothesbarai.taxcalculation.R;

public class TaxesZone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES,WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES);
        this.getWindow().setStatusBarColor(getResources().getColor(R.color.orange));
        this.getWindow().setNavigationBarColor(getResources().getColor(R.color.orange));
        this.getSupportActionBar().hide();
        setContentView(R.layout.taxes_zone);
    }
}