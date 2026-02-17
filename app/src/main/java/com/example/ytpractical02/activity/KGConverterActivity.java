package com.example.ytpractical02.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ytpractical02.R;

public class KGConverterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kg_converter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        findViewById(R.id.btnKGConvert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertKG();
            }
        });
    }

    private void convertKG() {
        EditText txtKg = findViewById(R.id.txtKg);
        EditText txtGram = findViewById(R.id.txtGram);
        if (Double.parseDouble(txtKg.getText().toString()) > 0) {
            txtGram.setText(String.valueOf(Double.parseDouble(txtKg.getText().toString()) * 1000));
        } else if (Double.parseDouble(txtGram.getText().toString()) > 0) {
            txtKg.setText(String.valueOf(Double.parseDouble(txtGram.getText().toString()) / 1000));
        } else {
            Toast.makeText(this, "Please enter a value", Toast.LENGTH_SHORT).show();
        }
    }

}