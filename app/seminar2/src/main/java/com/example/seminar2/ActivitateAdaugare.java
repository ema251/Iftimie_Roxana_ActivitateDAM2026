package com.example.seminar2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivitateAdaugare extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activitate_adaugare);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void salveaza(View view) {
        EditText marcaET = findViewById(R.id.marca_ET);
        EditText pretET = findViewById(R.id.pret_ET);
        EditText capacitateET = findViewById(R.id.capacitate_ET);
        Spinner clasaSP = findViewById(R.id.clasa_SP);
        RadioGroup culoareRG = findViewById(R.id.culoare_RG);
        CheckBox noFrostCB = findViewById(R.id.noFrost_CB);
        Switch smartSW = findViewById(R.id.smart_SW);
        RatingBar ratingRTB = findViewById(R.id.rating_RTB);

        if (marcaET.getText().toString().isEmpty() || pretET.getText().toString().isEmpty()
                || capacitateET.getText().toString().isEmpty()) {
            Toast.makeText(this, "Completeaza toate campurile", Toast.LENGTH_SHORT).show();
            return;
        }

        String marca = marcaET.getText().toString();
        int pret = Integer.parseInt(pretET.getText().toString());
        int capacitate = Integer.parseInt(capacitateET.getText().toString());
        String clasa = clasaSP.getSelectedItem().toString();
        RadioButton rb = findViewById(culoareRG.getCheckedRadioButtonId());
        String culoare = rb.getText().toString();
        boolean noFrost = noFrostCB.isChecked();
        boolean smart = smartSW.isChecked();
        float rating = ratingRTB.getRating();

        Frigider frigider = new Frigider(marca, pret, capacitate, clasa,
                culoare, noFrost, smart, rating);

        Intent it = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("marca", frigider.getMarca());
        bundle.putInt("pret", frigider.getPret());
        bundle.putInt("capacitate", frigider.getCapacitate());
        bundle.putString("clasa", frigider.getClasa());
        bundle.putString("culoare", frigider.getCuloare());
        bundle.putBoolean("noFrost", frigider.isNoFrost());
        bundle.putBoolean("smart", frigider.isSmart());
        bundle.putFloat("rating", frigider.getRating());
        it.putExtras(bundle);
        setResult(RESULT_OK, it);
        finish();
    }
}