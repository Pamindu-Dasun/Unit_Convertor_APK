package com.example.ytpractical02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ytpractical02.activity.CelciusConverterActivity;
import com.example.ytpractical02.activity.KGConverterActivity;

public class MainActivity extends AppCompatActivity {

    public MainActivity() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageButton kgConverter = findViewById(R.id.btnClickKG);
        ImageButton celConverter = findViewById(R.id.btnClickCelcius);

        kgConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kgConvertActivity = new Intent(MainActivity.this, KGConverterActivity.class);
                startActivity(kgConvertActivity);
            }
        });

        celConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent celConvertActivity = new Intent(MainActivity.this, CelciusConverterActivity.class);
                startActivity(celConvertActivity);
            }
        });

    }
}