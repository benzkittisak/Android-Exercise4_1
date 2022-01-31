/*
 * 6206021621082
 * กิตติศักดิ์ ปานเหลือ
 * */

package com.bbgun.exercise4_1s6206021621082;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editNum;
    TextView decimalText, binaryText, octalText, hexText;
    static String decimal, binary = "";
    static int decimalNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonOnClick(View v) {

        editNum = (EditText) findViewById(R.id.editNum);
        String convertEditNumToString = editNum.getText().toString();


        if (convertEditNumToString.equals("")) {
            Toast.makeText(this, "Please enter number ", Toast.LENGTH_SHORT).show();
            return;
        }

        decimal = convertEditNumToString;
        decimalNumber = Integer.parseInt(decimal);

        decimalText = (TextView) findViewById(R.id.decimalText);
        decimalText.setText(decimal);

        binaryText = (TextView) findViewById(R.id.binaryText);
        binaryText.setText(calBinary());

        hexText = (TextView) findViewById(R.id.hexText);
        hexText.setText(calHexa());

        octalText = (TextView) findViewById(R.id.octalText);
        octalText.setText(calOctal());
    }

    public String calBinary() {
        int decimalTemp = decimalNumber;
        int temp;
        while (decimalTemp > 0) {
            temp = decimalTemp % 2;
            decimalTemp = decimalTemp / 2;
            binary = temp + binary;
        }
        return binary;
    }

    public String calHexa() {
        int temp;
        int decimalTemp = decimalNumber;
        String hex = "";
        char[] hexChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        while (decimalTemp > 0) {
            temp = decimalTemp % 16;
            hex += hexChars[temp];
            decimalTemp = decimalTemp / 16;
        }
        return hex;
    }

    public String calOctal() {
        int decimalTemp = decimalNumber;
        int temp;
        String octal = "";
        char[] octalChars = {'0', '1', '2', '3', '4', '5', '6', '7'};
        while (decimalTemp > 0) {
            temp = decimalTemp % 8;
            octal = octalChars[temp] + octal;
            decimalTemp = decimalTemp / 8;
        }

        return octal;
    }
}