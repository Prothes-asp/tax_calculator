package com.aspprothesbarai.taxcalculation.CustomGridPage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.aspprothesbarai.taxcalculation.MainActivity;
import com.aspprothesbarai.taxcalculation.R;

public class TaxCalculator extends AppCompatActivity {

    private EditText edBasicSalary,edHouseRent,edAgriculIncome,edBusinessIncome,edOtherIncome,edFestivalBonus,edGoldVori;
    private TextView tvDisplay1,tvDisplay2;
    private Button calculateBtn,resetBtn;
    private AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES,WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES);
        this.getSupportActionBar().hide();
        this.getWindow().setStatusBarColor(getResources().getColor(R.color.orange));
        this.getWindow().setNavigationBarColor(getResources().getColor(R.color.orange));
        setContentView(R.layout.tax_calculator);

        edBasicSalary = findViewById(R.id.edBasicSalary);
        edHouseRent = findViewById(R.id.edHouseRent);
        edAgriculIncome = findViewById(R.id.edAgriculIncome);
        edBusinessIncome = findViewById(R.id.edBusinessIncome);
        edOtherIncome = findViewById(R.id.edOtherIncome);
        edFestivalBonus = findViewById(R.id.edFestivalBonus);
        edGoldVori = findViewById(R.id.edGoldVori);

        tvDisplay1 = findViewById(R.id.tvDisplay1);
        tvDisplay2 = findViewById(R.id.tvDisplay2);
        calculateBtn = findViewById(R.id.calculateBtn);
        resetBtn = findViewById(R.id.resetBtn);

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput1 = edBasicSalary.getText().toString();
                String getInput2 = edHouseRent.getText().toString();
                String getInput3 = edAgriculIncome.getText().toString();
                String getInput4 = edBusinessIncome.getText().toString();
                String getInput5 = edOtherIncome.getText().toString();
                String getInput6 = edFestivalBonus.getText().toString();
                String getInput7 = edGoldVori.getText().toString();
                if (getInput1.length()>0 && getInput2.length()>0 && getInput3.length()>0 && getInput4.length()>0 && getInput5.length()>0 && getInput6.length()>0 && getInput7.length()>0){
                    float basicSalary = Float.parseFloat(getInput1);
                    float houseRent = Float.parseFloat(getInput2);
                    float agriculturalIncome = Float.parseFloat(getInput3);
                    float businessIncome = Float.parseFloat(getInput4);
                    float othersIncome = Float.parseFloat(getInput5);
                    float festivalBonus = Float.parseFloat(getInput6);
                    float goldVori = Float.parseFloat(getInput7);
                    float totalIncome,gold;
                    gold = goldVori * 110947.97F;
                    totalIncome = basicSalary + houseRent + agriculturalIncome + businessIncome + othersIncome + festivalBonus + gold;

                    if (totalIncome <= 330000){
                        float tax;
                        tax = totalIncome * 0;
                        tvDisplay1.setText("Your Total Income : \n" + totalIncome + " BDT");
                        tvDisplay2.setText("Your Tax is : \n" + tax + " BDT");
                        tvDisplay1.setTextSize(20);
                        tvDisplay2.setTextSize(20);
                        tvDisplay1.setTextColor(getResources().getColor(R.color.green));
                        tvDisplay2.setTextColor(getResources().getColor(R.color.green));
                    }else if (totalIncome <= 480000){
                        float tax;
                        tax = ((totalIncome-330000)*0.10F);
                        tvDisplay1.setText("Your Total Income : \n" + totalIncome + " BDT");
                        tvDisplay2.setText("Your Tax is : \n" + tax + " BDT");
                        tvDisplay1.setTextSize(20);
                        tvDisplay2.setTextSize(20);
                        tvDisplay1.setTextColor(getResources().getColor(R.color.yellow));
                        tvDisplay2.setTextColor(getResources().getColor(R.color.yellow));
                    }else if (totalIncome <= 720000){
                        float tax;
                        tax = (15000+((totalIncome-480000)*0.15F));
                        tvDisplay1.setText("Your Total Income : \n" + totalIncome + " BDT");
                        tvDisplay2.setText("Your Tax is : \n" + tax + " BDT");
                        tvDisplay1.setTextSize(20);
                        tvDisplay2.setTextSize(20);
                        tvDisplay1.setTextColor(getResources().getColor(R.color.yellow));
                        tvDisplay2.setTextColor(getResources().getColor(R.color.yellow));
                    }else if (totalIncome <= 1200000){
                        float tax;
                        tax = (15000+36000+((totalIncome-720000)*0.20F));
                        tvDisplay1.setText("Your Total Income : \n" + totalIncome + " BDT");
                        tvDisplay2.setText("Your Tax is : \n" + tax + " BDT");
                        tvDisplay1.setTextSize(20);
                        tvDisplay2.setTextSize(20);
                        tvDisplay1.setTextColor(getResources().getColor(R.color.orange));
                        tvDisplay2.setTextColor(getResources().getColor(R.color.orange));
                    }else if (totalIncome > 1200000){
                        float tax;
                        tax = (15000+36000+96000+((totalIncome-1200000)*0.25F));
                        tvDisplay1.setText("Your Total Income : \n" + totalIncome + " BDT");
                        tvDisplay2.setText("Your Tax is : \n" + tax + " BDT");
                        tvDisplay1.setTextSize(20);
                        tvDisplay2.setTextSize(20);
                        tvDisplay1.setTextColor(getResources().getColor(R.color.orange));
                        tvDisplay2.setTextColor(getResources().getColor(R.color.orange));
                    }



                }else if (getInput1.length()<=0 && getInput2.length()<=0 && getInput3.length()<=0 && getInput4.length()<=0 && getInput5.length()<=0 && getInput6.length()<=0 && getInput7.length()<=0){
                    edBasicSalary.setError("Empty");
                    edHouseRent.setError("Empty");
                    edAgriculIncome.setError("Empty");
                    edBusinessIncome.setError("Empty");
                    edOtherIncome.setError("Empty");
                    edFestivalBonus.setError("Empty");
                    edGoldVori.setError("Empty");
                    tvDisplay1.setText(null);
                    tvDisplay2.setText(null);
                }else if (getInput1.length()<=0) {
                    edBasicSalary.setError("Empty");
                    tvDisplay1.setText(null);
                    tvDisplay2.setText(null);
                }else if (getInput2.length()<=0) {
                    edHouseRent.setError("Empty");
                    tvDisplay1.setText(null);
                    tvDisplay2.setText(null);
                }else if (getInput3.length()<=0) {
                    edAgriculIncome.setError("Empty");
                    tvDisplay1.setText(null);
                    tvDisplay2.setText(null);
                }else if (getInput4.length()<=0) {
                    edBusinessIncome.setError("Empty");
                    tvDisplay1.setText(null);
                    tvDisplay2.setText(null);
                }else if (getInput5.length()<=0) {
                    edOtherIncome.setError("Empty");
                    tvDisplay1.setText(null);
                    tvDisplay2.setText(null);
                }else if (getInput6.length()<=0) {
                    edFestivalBonus.setError("Empty");
                    tvDisplay1.setText(null);
                    tvDisplay2.setText(null);
                }else if (getInput7.length()<=0) {
                    edGoldVori.setError("Empty");
                    tvDisplay1.setText(null);
                    tvDisplay2.setText(null);
                }
            }
        });


        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvDisplay1.setText(null);
                tvDisplay2.setText(null);
                edBasicSalary.setError(null);
                edHouseRent.setError(null);
                edAgriculIncome.setError(null);
                edBusinessIncome.setError(null);
                edOtherIncome.setError(null);
                edFestivalBonus.setError(null);
                edGoldVori.setError(null);

                edBasicSalary.setText(null);
                edHouseRent.setText(null);
                edAgriculIncome.setText(null);
                edBusinessIncome.setText(null);
                edOtherIncome.setText(null);
                edFestivalBonus.setText(null);
                edGoldVori.setText(null);
            }
        });

    }

    /** @noinspection deprecation*/
    @Override
    public void onBackPressed() {
        if (isTaskRoot()==false){
            alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("Warning!!!");
            alertDialogBuilder.setMessage("Do you want close this calculator?");
            alertDialogBuilder.setCancelable(false);
            alertDialogBuilder.setIcon(R.drawable.alert_orange);
            alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(TaxCalculator.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }else{
            super.onBackPressed();
        }
    }
}