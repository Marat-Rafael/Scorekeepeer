package com.example.scorekeepeer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int contador_team_1;
    int contador_team_2;
    ImageButton button_team1_minus;
    ImageButton button_team2_minus;
    ImageButton button_team1_mas;
    ImageButton button_team2_mas;
    TextView tv_team_1;
    TextView tv_team_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // identificamos botones
        button_team1_minus = findViewById(R.id.btn_team1_menos);
        button_team1_mas = findViewById(R.id.btn_team1_mas);
        button_team2_minus = findViewById(R.id.btn_team2_menos);
        button_team2_mas = findViewById(R.id.btn_team2_mas);
        // identificamos textView donde mostramos contador
        tv_team_1 = findViewById(R.id.tv_contador_team1);
        tv_team_2 = findViewById(R.id.tv_contador_team2);
        // iniciamos contador a zero
        contador_team_1 = 0;
        contador_team_2 = 0;

        // si hay un bundle lo cargamos
        if (savedInstanceState != null) {
            contador_team_1 = savedInstanceState.getInt("CONTADOR_1");
            contador_team_2 = savedInstanceState.getInt("CONTADOR_2");

            // establecemos valor
            tv_team_1.setText(String.valueOf(contador_team_1));
            tv_team_2.setText(String.valueOf(contador_team_2));
        }

    }

    /**
     * metodo para aumentar
     *
     * @param view
     */
    public void increaseScore(View view) {
        // identificamos que button espa pulsado
        int viewID = view.getId();
        switch (viewID) {
            // si es Team 1
            case R.id.btn_team1_mas:
                // aumentamos en uno
                contador_team_1++;
                tv_team_1.setText(String.valueOf(contador_team_1));
                break;
            // si es Team 2
            case R.id.btn_team2_mas:
                // mas en uno
                contador_team_2++;
                tv_team_2.setText(String.valueOf(contador_team_2));
                break;
        }

    }


    /**
     * metodo pada disminuir
     *
     * @param view
     */
    public void decreaseScore(View view) {
        // identificamos que button espa pulsado
        int viewID = view.getId();
        switch (viewID) {
            // si es Team 1
            case R.id.btn_team1_menos:
                // minus uno
                contador_team_1--;
                // aseguramos que contador no sea menor que cero
                if (contador_team_1 < 0) {
                    contador_team_1 = 0;
                }
                tv_team_1.setText(String.valueOf(contador_team_1));
                break;
            // si es Team 2
            case R.id.btn_team2_menos:
                // minus uno
                contador_team_2--;
                // aseguramos que contador no sea menor que cero
                if (contador_team_2 < 0) {
                    contador_team_2 = 0;
                }
                tv_team_2.setText(String.valueOf(contador_team_2));
                break;
        }
    }


    /**
     * Creamos menu
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);

        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }


    /**
     * Metodo sobreescrito
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        //  cojer elemento selecionado
        if (item.getItemId() == R.id.night_mode) {
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            // establecemos modo de noche
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            // volver a crear
            recreate();
        }
        return true;
    }


    /**
     * Metodo para guardar valores que deseamos y pasarlo con bundle
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        // guardamos puntuacion
        outState.putInt("CONTADOR_1", contador_team_1);
        outState.putInt("CONTADOR_2", contador_team_2);
        super.onSaveInstanceState(outState);

    }
}