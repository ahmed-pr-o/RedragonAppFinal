package com.example.redragonapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PaymentActivity extends AppCompatActivity {

    EditText etCardNumber, etExpiry, etCvv;
    Button btnConfirmPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        etCardNumber = findViewById(R.id.etCardNumber);
        etExpiry = findViewById(R.id.etExpiry);
        etCvv = findViewById(R.id.etCvv);
        btnConfirmPayment = findViewById(R.id.btnConfirmPayment);

        btnConfirmPayment.setOnClickListener(v -> {
            String card = etCardNumber.getText().toString();
            String expiry = etExpiry.getText().toString();
            String cvv = etCvv.getText().toString();

            if(card.isEmpty() || expiry.isEmpty() || cvv.isEmpty()) {
                Toast.makeText(this, "Please fill out all fields\n", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Payment completed successfully!\n", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
