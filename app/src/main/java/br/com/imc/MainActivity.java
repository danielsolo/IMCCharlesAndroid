package br.com.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText peso, altura, imc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.carregar();

        peso = findViewById(R.id.campoPeso);
        altura = findViewById(R.id.campoAltura);
        imc = findViewById(R.id.campoResultado);

    }

        public void calcular(View v) {

            double n1 = Double.parseDouble(peso.getText().toString());
            double n2 = Double.parseDouble(altura.getText().toString());

            Imc ImcACalcular = new Imc();

            double resultado = ImcACalcular.getImc(n1,n2);


            imc.setText(String.valueOf(resultado));

            imc.setText(String.format("%.2f", resultado));
        }


        public void salvar(View v){

            double n1 = Double.parseDouble(peso.getText().toString());
            double n2 = Double.parseDouble(altura.getText().toString());


            Imc ImcAserSalvo = new Imc();

            ImcAserSalvo.setPeso(n1);
            ImcAserSalvo.setAltura(n2);

            double resultado = ImcAserSalvo.setImc(n1,n2);

            ImcRepository repositorio = new ImcRepository();


        }

        public ArrayList<Imc> carregar() {
            ImcRepository repositorio = new ImcRepository(getApplicationContext());

            ArrayList<Imc> todosOsImcs;


            todosOsImcs = repositorio.listarTodos();

            imc.setText(todosOsImcs);

            imc.setText(String.valueOf(todosOsImcs));

            imc.setText(String.format("%.2f", todosOsImcs));

        }




    }

