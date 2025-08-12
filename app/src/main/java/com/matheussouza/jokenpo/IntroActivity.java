package com.matheussouza.jokenpo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);
    }

    public void selecinoarPedra(View view) {
        verificarGanhador("Pedra");
    }

    public void selecinoarPapel(View view) {
        verificarGanhador("Papel");
    }

    public void selecinoarTesoura(View view) {
        verificarGanhador("Tesoura");
    }

    private String gerarEscolhaAleatoriaApp() {
        int numeroAleatorio = new Random().nextInt(3);
        ImageView imagemApp = findViewById(R.id.padrao);

        String[] opcoes = {"Pedra", "Papel", "Tesoura"};

        String escolhaApp = opcoes[numeroAleatorio];

        switch (escolhaApp) {
            case "Pedra":
                imagemApp.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                imagemApp.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imagemApp.setImageResource(R.drawable.tesoura);
                break;

        }
        return escolhaApp;
    }

    private void verificarGanhador(String escolhaDoUsuario) {
        String escolhaApp = gerarEscolhaAleatoriaApp();
        TextView textoResultado = findViewById(R.id.tvresultado);
        if (
                (escolhaApp.equals("Pedra") && escolhaDoUsuario.equals("Tesoura")) ||
                        (escolhaApp.equals("Tesoura") && escolhaDoUsuario.equals("Papel")) ||
                        (escolhaApp.equals("Papel") && escolhaDoUsuario.equals("Pedra"))
        ) {
            textoResultado.setText("Você perdeu :(");

        } else if (
                (escolhaDoUsuario.equals("Pedra") && escolhaApp.equals("Tesoura")) ||
                        (escolhaDoUsuario.equals("Tesoura") && escolhaApp.equals("Papel")) ||
                        (escolhaDoUsuario.equals("Papel") && escolhaApp.equals("Pedra"))
        ) {
            textoResultado.setText("Você ganhou! :)");

        } else {
            textoResultado.setText("Vocês empataram! :)");

        }
    }


}
