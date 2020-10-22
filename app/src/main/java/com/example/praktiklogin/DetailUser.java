package com.example.praktiklogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.praktiklogin.Database.DatabaseHelper;
import com.example.praktiklogin.Model.ModelUser;

public class DetailUser extends AppCompatActivity {
    ListView listView;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);
        listView = findViewById(R.id.listview);
        dbHelper = new DatabaseHelper(DetailUser.this);
        listView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModelUser MU = new ModelUser(listView.getText())
            }
        });
    }
}