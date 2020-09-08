package com.btxdev.testapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class OperationActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputLayout tilValue1, tilValue2, tilResult;
    private Button btnSum, btnSubt, btnMult, btnDiv, btnHigh, btnLess, btnMcm, btnMcd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation);

        tilValue1 = findViewById(R.id.tilValue1);
        tilValue2 = findViewById(R.id.tilValue2);
        tilResult = findViewById(R.id.tilResult);

        btnSum = findViewById(R.id.btnSum);
        btnSubt = findViewById(R.id.btnSubt);
        btnMult = findViewById(R.id.btnMult);
        btnDiv = findViewById(R.id.btnDiv);
        btnHigh = findViewById(R.id.btnHigh);
        btnLess = findViewById(R.id.btnLess);
        btnMcm = findViewById(R.id.btnMcm);
        btnMcd = findViewById(R.id.btnMcd);

        btnSum.setOnClickListener(this);
        btnSubt.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnHigh.setOnClickListener(this);
        btnLess.setOnClickListener(this);
        btnMcm.setOnClickListener(this);
        btnMcd.setOnClickListener(this);

    }


    private int getIntValue(TextInputLayout textInputLayout){
        return Integer.parseInt(textInputLayout.getEditText().getText().toString());
    }

    private boolean checkValues(){
        return !TextUtils.isEmpty(tilValue1.getEditText().getText())&&!TextUtils.isEmpty(tilValue2.getEditText().getText());
    }

    public int mcd(int value1, int value2){
        int mcd = 0;
        int a = Math.max(value1, value2);
        int b = Math.min(value1, value2);
        do{
            mcd = b;
            b = a%b;
            a = mcd;
        }while (b!=0);
        return mcd;
    }

    public int mcm(int value1, int value2){
        int mcm = 0;
        int a = Math.max(value1, value2);
        int b = Math.min(value1, value2);
        mcm = (a/mcd(a,b))*b;
        return mcm;
    }

    @Override
    public void onClick(View v) {

        if(checkValues()){

            int value1 = getIntValue(tilValue1);
            int value2 = getIntValue(tilValue2);

            switch (v.getId()){
                case R.id.btnSum:
                    tilResult.getEditText().setText(""+(value1+value2));

                    break;
                case R.id.btnSubt:
                    tilResult.getEditText().setText(""+(value1-value2));

                    break;
                case R.id.btnMult:
                    tilResult.getEditText().setText(""+(value1*value2));

                    break;
                case R.id.btnDiv:
                    if(value2==0){
                        tilResult.getEditText().setText(R.string.result_err);
                        Toast.makeText(getApplicationContext(),R.string.err_divide_by_zero,Toast.LENGTH_SHORT).show();
                    }else{
                        double divResult = ((double)value1)/value2;
                        tilResult.getEditText().setText(""+divResult);
                    }

                    break;
                case R.id.btnHigh:
                    if(value1>value2){
                        tilResult.getEditText().setText(R.string.result_true);
                    }else{
                        tilResult.getEditText().setText(R.string.result_false);
                    }

                    break;
                case R.id.btnLess:
                    if(value1<value2){
                        tilResult.getEditText().setText(R.string.result_true);
                    }else{
                        tilResult.getEditText().setText(R.string.result_false);
                    }

                    break;
                case R.id.btnMcm:
                    tilResult.getEditText().setText(""+mcm(value1,value2));

                    break;
                case R.id.btnMcd:
                    tilResult.getEditText().setText(""+mcd(value1,value2));

                    break;
            }
        }else{
            Toast.makeText(getApplicationContext(),R.string.invalid_values_entered,Toast.LENGTH_SHORT).show();
        }
    }
}
