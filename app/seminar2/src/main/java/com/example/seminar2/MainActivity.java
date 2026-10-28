package com.example.seminar2;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
    }

    public void deschideAdaugare(View view) {
        Intent it = new Intent(this, ActivitateAdaugare.class);
        startActivityForResult(it, 1);
    }

    public void deschideAdaugareAI(View view) {
        Intent it = new Intent(this, ActivitateAdaugareAI.class);
        startActivityForResult(it, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String marca = bundle.getString("marca", "");
            int pret = bundle.getInt("pret", 0);
            int capacitate = bundle.getInt("capacitate", 0);
            String clasa = bundle.getString("clasa", "");
            String culoare = bundle.getString("culoare", "");
            boolean noFrost = bundle.getBoolean("noFrost", false);
            boolean smart = bundle.getBoolean("smart", false);
            float rating = bundle.getFloat("rating", 0);

            Frigider frigider = new Frigider(marca, pret, capacitate, clasa,
                    culoare, noFrost, smart, rating);

            TextView tv = findViewById(R.id.rezultat_TV);
            tv.setText(frigider.toString());
            Toast.makeText(this, frigider.toString(), Toast.LENGTH_LONG).show();
        }
    }
}