package com.example.firstapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static EditText number;
    private static TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //выход из приложения с помощью нажатия кнопки НАЗАД
    @Override
    public void onBackPressed() {
        //диалоговое окно при закрытии приложения, которое отмечает, точно ли я хочу его закрыть
        AlertDialog.Builder alert_builder = new AlertDialog.Builder(MainActivity.this);
        alert_builder.setMessage("Закрыть приложение?")
                // данном случае это окно нельзя будет отменить
                .setCancelable(false)
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //полное закрытие приложения
                        finish();
                    }
                })
                .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alert_builder.create();
        alertDialog.setTitle("Закрытие приложения");
        alertDialog.show();
    }

    //переход на страницу Автор
    public void onAuthorButtonClick(View view) {
        Intent intent = new Intent(".AuthorActivity");
        startActivity(intent);
    }

    //действия кнопок вызовов функций вычисления чисел Фибоначчи
    public void onLinearButtonClick(View view) {
        number = findViewById(R.id.FirstNumber);
        result = findViewById(R.id.Result);

        double requiredNumber;
        if (number.getText().toString() == null || number.getText().toString().equals("")) {
            requiredNumber = 0;
            Toast.makeText(
                    MainActivity.this, "Enter number!", Toast.LENGTH_LONG
            ).show();
        } else {
            requiredNumber = Double.parseDouble(number.getText().toString());
        }
        long start = System.nanoTime() / 1000;
        double funcResult = Count.linearMethod(requiredNumber);
        result.setText(Double.toString(Math.floor(funcResult)) + "\nDone by Linear Method" +
                "\nin " + (System.nanoTime() / 1000 - start) + " ms");

    }

    public void onMatrixButtonClick(View view) {
        number = findViewById(R.id.FirstNumber);
        result = findViewById(R.id.Result);

        double requiredNumber;
        if (number.getText().toString() == null || number.getText().toString().equals("")) {
            requiredNumber = 0;
            //display message on screen with text "Enter number!" for 3 seconds
            Toast.makeText(
                    MainActivity.this, "Enter number!", Toast.LENGTH_LONG
            ).show();
        } else {
            requiredNumber = Double.parseDouble(number.getText().toString());
        }
        long start = System.nanoTime() / 1000;
        double funcResult = Count.matrixMethod(requiredNumber).doubleValue();
        result.setText(Double.toString(Math.floor(funcResult)) + "\nDone by Matrix Method" +
                "\nin " + (System.nanoTime() / 1000 - start) + " ms");

    }

    public void onRecursiveButtonClick(View view) {
        number = findViewById(R.id.FirstNumber);
        result = findViewById(R.id.Result);

        double requiredNumber;
        if (number.getText().toString() == null || number.getText().toString().equals("")) {
            requiredNumber = 0;
            Toast.makeText(
                    MainActivity.this, "Enter number!", Toast.LENGTH_LONG
            ).show();

        } else {
            requiredNumber = Double.parseDouble(number.getText().toString());
        }

        long start = System.nanoTime() / 1000;
        double funcResult = Count.recursiveMethod(requiredNumber);
        result.setText(Double.toString(Math.floor(funcResult)) + "\nDone by Recursive Method" +
                "\nin " + (System.nanoTime() / 1000 - start) + " ms");

    }
}
