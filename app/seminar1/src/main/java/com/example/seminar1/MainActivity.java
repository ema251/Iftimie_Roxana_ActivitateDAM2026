package com.example.seminar1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "onCreate - VERBOSE");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart - ERROR");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w(TAG, "onResume - WARNING");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause - DEBUG");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop - INFO");
    }

    public void culegeDate(View view) {
        EditText et = findViewById(R.id.nume_ET);
        CheckBox cb = findViewById(R.id.eStudent_CB);

        String nume = et.getText().toString();
        boolean eStudent = cb.isChecked();

        Toast.makeText(this, nume + " - student: " + eStudent, Toast.LENGTH_SHORT).show();
    }
}