package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText Number = (EditText) findViewById(R.id.editTextNumber);
        final TextView Result = (TextView) findViewById(R.id.txtResult);
        final RadioButton Euro = (RadioButton) findViewById(R.id.radBtnEuro);
        final RadioButton CanadianDollar = (RadioButton) findViewById(R.id.radBtnCNDollar);
        final RadioButton MexicanPeso = (RadioButton) findViewById(R.id.radBtnMXPeso);

        final Button Convert = (Button) findViewById(R.id.btnConvert);

        Convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double Num = Double.parseDouble(Number.getText().toString());
                double Converted_Num;
                if (Num < 100000) {
                    if (Euro.isChecked()) {
                        Converted_Num = Num * 1.16303;
                        Result.setText(Num + " USD = " + Converted_Num + " Euros");
                    } else if (MexicanPeso.isChecked()) {
                        Converted_Num = Num * 0.05;
                        Result.setText(Num + " USD = " + Converted_Num + " Mexican Pesos");
                    } else if (CanadianDollar.isChecked()) {
                        Converted_Num = Num * 0.79;
                        Result.setText(Num + " USD = " + Converted_Num + " Canadian Dollars");
                    }
                } else {
                    Toast.makeText(MainActivity.this, "US Dollars input should be < $100000", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}