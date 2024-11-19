package com.example.examen;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Configurar el Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Cargar los fragmentos en sus contenedores
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_one_container, new FragmentOne())
                .replace(R.id.fragment_two_container, new FragmentTwo())
                .replace(R.id.fragment_three_container, new FragmentThree())
                .commit();
    }

    // Método para recibir texto y tamaño desde el primer fragmento y enviarlo al segundo fragmento
    public void updateTextSize(String text, float size) {
        FragmentTwo fragmentTwo = (FragmentTwo) getSupportFragmentManager().findFragmentById(R.id.fragment_two_container);
        if (fragmentTwo != null) {
            fragmentTwo.updateText(text, size);
        }
    }

    // Método para recibir color desde el tercer fragmento y enviarlo al segundo fragmento
    public void updateTextColor(int color) {
        FragmentTwo fragmentTwo = (FragmentTwo) getSupportFragmentManager().findFragmentById(R.id.fragment_two_container);
        if (fragmentTwo != null) {
            fragmentTwo.updateColor(color);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflar el menú en el Toolbar
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.icon_1) {
            // Navegar a MainActivity sin animación
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            overridePendingTransition(0, 0); // Eliminar animaciones
            return true;
        } else if (id == R.id.icon_2) {
            // Navegar a SecondActivity (actual)
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
            overridePendingTransition(0, 0); // Eliminar animaciones
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
