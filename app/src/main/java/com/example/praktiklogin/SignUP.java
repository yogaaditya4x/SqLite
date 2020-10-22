package com.example.praktiklogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.praktiklogin.Database.DatabaseHelper;
import com.example.praktiklogin.Model.ModelUser;

public class SignUP extends AppCompatActivity {
    EditText editUsername, editPassword;
    Button DaftarBTN;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_u_p);
        editUsername = findViewById(R.id.usernamesignup);
        editPassword = findViewById(R.id.passwordsignup);
        DaftarBTN = findViewById(R.id.daftar);
        dbHelper = new DatabaseHelper(SignUP.this);
        DaftarBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModelUser MU = new ModelUser(editUsername.getText().toString(),editPassword.getText().toString());
                dbHelper.SaveLogin(MU);
                Toast.makeText(SignUP.this,"Berhasil daftar", Toast.LENGTH_LONG).show();
            }
        });
    }
}