package com.example.grid_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView display;

    double firstNumber = 0;
    double secondNumber = 0;

    String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
    }

    public void onClick(View view) {

        int id = view.getId();


        if (id == R.id.clear) {

            display.setText("0");

            firstNumber = 0;
            secondNumber = 0;
            operator = "";
        }


        else if (id == R.id.zero) {
            addNumber("0");
        }

        else if (id == R.id.one) {
            addNumber("1");
        }

        else if (id == R.id.two) {
            addNumber("2");
        }

        else if (id == R.id.three) {
            addNumber("3");
        }

        else if (id == R.id.four) {
            addNumber("4");
        }

        else if (id == R.id.five) {
            addNumber("5");
        }

        else if (id == R.id.six) {
            addNumber("6");
        }

        else if (id == R.id.seven) {
            addNumber("7");
        }

        else if (id == R.id.eight) {
            addNumber("8");
        }

        else if (id == R.id.nine) {
            addNumber("9");
        }

        // Decimal point

        else if (id == R.id.dot) {

            String value = display.getText().toString();

            if (!value.contains(".")) {

                if (value.equals("0")) {
                    display.setText("0.");
                }
                else {
                    display.append(".");
                }
            }
        }

        // Addition

        else if (id == R.id.add) {

            firstNumber =
                    Double.parseDouble(getCurrentNumber());

            operator = "+";

            display.setText(
                    getCurrentNumber() + " + "
            );
        }

        // Subtraction

        else if (id == R.id.diff) {

            firstNumber =
                    Double.parseDouble(getCurrentNumber());

            operator = "-";

            display.setText(
                    getCurrentNumber() + " - "
            );
        }

        // Multiplication

        else if (id == R.id.mul) {

            firstNumber =
                    Double.parseDouble(getCurrentNumber());

            operator = "*";

            display.setText(
                    getCurrentNumber() + " * "
            );
        }

        // Division

        else if (id == R.id.div) {

            firstNumber =
                    Double.parseDouble(getCurrentNumber());

            operator = "/";

            display.setText(
                    getCurrentNumber() + " / "
            );
        }

        // Equal

        else if (id == R.id.equal) {

            String expression = display.getText().toString();

            if (operator.equals("")) {
                return;
            }

            String[] parts = expression.split(" ");

            if (parts.length < 3) {
                return;
            }

            secondNumber =
                    Double.parseDouble(parts[2]);

            double result = 0;

            if (operator.equals("+")) {
                result = firstNumber + secondNumber;
            }

            else if (operator.equals("-")) {
                result = firstNumber - secondNumber;
            }

            else if (operator.equals("*")) {
                result = firstNumber * secondNumber;
            }

            else if (operator.equals("/")) {

                if (secondNumber == 0) {

                    display.setText("Error");

                    operator = "";

                    return;
                }

                result = firstNumber / secondNumber;
            }

            display.setText(String.valueOf(result));

            operator = "";
        }
    }


    public void addNumber(String number) {

        String current = display.getText().toString();

        if (current.equals("0")) {

            display.setText(number);
        }
        else if (current.endsWith("+ ")
                || current.endsWith("- ")
                || current.endsWith("* ")
                || current.endsWith("/ ")) {

            display.append(number);
        }

        else {

            display.append(number);
        }
    }


    public String getCurrentNumber() {

        String expression = display.getText().toString();

        String[] parts = expression.split(" ");

        if (parts.length == 1) {
            return parts[0];
        }

        return parts[parts.length - 1];
    }
}
