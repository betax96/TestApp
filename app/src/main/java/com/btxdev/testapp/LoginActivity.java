package com.btxdev.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout tilName, tilPassword;
    private Button btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tilName = findViewById(R.id.tilName);
        tilPassword = findViewById(R.id.tilPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(tilName.getEditText().getText())||TextUtils.isEmpty(tilPassword.getEditText().getText())){
                    Toast.makeText(getApplicationContext(),R.string.invalid_values_entered,Toast.LENGTH_SHORT).show();
                }else{
                    startActivity(new Intent(LoginActivity.this, OperationActivity.class));
                }
            }
        });
    }
}