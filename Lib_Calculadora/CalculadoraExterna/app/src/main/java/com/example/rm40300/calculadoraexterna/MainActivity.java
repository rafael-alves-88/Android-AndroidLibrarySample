package com.example.rm40300.calculadoraexterna;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.rm40300.minhabiblioteca.Calculadora;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.etNum1) EditText etNum1;
    @Bind(R.id.etNum2) EditText etNum2;
    @Bind(R.id.tvResultado) TextView tvResultado;

    Calculadora calculadora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        calculadora = new Calculadora();
    }

    @OnClick(R.id.btnSomar)
    public void somar() {
        double resultado = calculadora.somar(getNum1(), getNum2());
        tvResultado.setText(String.valueOf(resultado));
    }

    @OnClick(R.id.btnSubtrair)
    public void subtrair() {
        double resultado = calculadora.subtrair(getNum1(), getNum2());
        tvResultado.setText(String.valueOf(resultado));
    }

    @OnClick(R.id.btnMultiplicar)
    public void multiplicar() {
        double resultado = calculadora.multiplicar(getNum1(), getNum2());
        tvResultado.setText(String.valueOf(resultado));
    }

    @OnClick(R.id.btnDividir)
    public void dividir() {
        if (getNum2() != 0) {
            double resultado = calculadora.dividir(getNum1(), getNum2());
            tvResultado.setText(String.valueOf(resultado));
        } else {
            tvResultado.setText("Divisão por 0");
        }
    }

    private double getNum1() {
        double numero;

        if (etNum1.getText() != null && etNum1.getText().toString().length() > 0) {
            numero = Double.parseDouble(etNum1.getText().toString());
        } else {
            numero = 0;
        }

        return numero;
    }

    private double getNum2() {
        double numero;

        if (etNum2.getText() != null && etNum2.getText().toString().length() > 0) {
            numero = Double.parseDouble(etNum2.getText().toString());
        } else {
            numero = 0;
        }

        return numero;
    }
}
