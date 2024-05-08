package com.aspprothesbarai.taxcalculation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.aspprothesbarai.taxcalculation.CustomGridPage.E_TIN;
import com.aspprothesbarai.taxcalculation.CustomGridPage.SpotAssessment;
import com.aspprothesbarai.taxcalculation.CustomGridPage.T_Return_Guidline;
import com.aspprothesbarai.taxcalculation.CustomGridPage.TaxCalculator;
import com.aspprothesbarai.taxcalculation.CustomGridPage.Tax_Pay_Guidline;
import com.aspprothesbarai.taxcalculation.CustomGridPage.TaxesZone;

public class MainActivity extends AppCompatActivity {
    private AlertDialog.Builder alertDialogBuilder;
    private GridView gridView;
    private String gridTitle[];
    private int flags[] = {
            R.drawable.tax_e_tin,R.drawable.tax_calculator,R.drawable.chart,
            R.drawable.t_retirn_guide,R.drawable.maps,R.drawable.save_money
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES,WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES);
        this.getWindow().setStatusBarColor(getResources().getColor(R.color.orange));
        this.getWindow().setNavigationBarColor(getResources().getColor(R.color.orange));
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);
        gridTitle = getResources().getStringArray(R.array.grid_items_name);


        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(this,flags,gridTitle);
        gridView.setAdapter(customBaseAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Intent intent = new Intent(MainActivity.this, E_TIN.class);
                    startActivity(intent);
                }
                if (position == 1){
                    Intent intent = new Intent(MainActivity.this, TaxCalculator.class);
                    startActivity(intent);
                }
                if (position == 2){
                    Intent intent = new Intent(MainActivity.this, SpotAssessment.class);
                    startActivity(intent);
                }
                if (position == 3){
                    Intent intent = new Intent(MainActivity.this, T_Return_Guidline.class);
                    startActivity(intent);
                }
                if (position == 4){
                    Intent intent = new Intent(MainActivity.this, TaxesZone.class);
                    startActivity(intent);
                }
                if (position == 5){
                    Intent intent = new Intent(MainActivity.this, Tax_Pay_Guidline.class);
                    startActivity(intent);
                }
            }
        });

    }




    // BackButton
    /** @noinspection deprecation*/
    @Override
    public void onBackPressed() {
        if (isTaskRoot()){
            alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("Conformation !!");
            alertDialogBuilder.setMessage("Do you want exit");
            alertDialogBuilder.setCancelable(false);
            alertDialogBuilder.setIcon(R.drawable.alert_orange);
            alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
            alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.orange));
            alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.orange));
        }else{
            super.onBackPressed();
        }
    }
}