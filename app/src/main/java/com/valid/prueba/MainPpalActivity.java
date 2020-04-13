package com.valid.prueba;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.valid.prueba.adapter.ListOneActivity;

import androidx.appcompat.app.AppCompatActivity;
import utilities.Message;

public class MainPpalActivity extends AppCompatActivity {

    private Button btnOne;


    //region Methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainppal);
        btnOne = findViewById(R.id.btListArtist);
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickOne();
            }
        });
    }

    //Click clickOne
    public void clickOne() {
        try {
            startActivity(new Intent(MainPpalActivity.this, ListOneActivity.class));
        } catch (Exception e) {
            Message.logMessageException(getClass(), e);
        }
    }
    //endregion
}
