package com.example.examen;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configurar el Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Referenciar el FrameLayout
        FrameLayout frameLayout = findViewById(R.id.frameLayout);

        // Inflar el círculo y agregarlo al FrameLayout
        View circle = getLayoutInflater().inflate(R.layout.circle_view, frameLayout, false);
        frameLayout.addView(circle);

        // Acción al hacer clic en el fondo
        frameLayout.setOnClickListener(v -> {
            // Restablecer la posición inicial del círculo
            circle.setTranslationY(0);

            // Animar el círculo hacia abajo
            circle.animate()
                    .translationY(frameLayout.getHeight() - circle.getHeight())
                    .setDuration(2000)
                    .start();

            // Cambiar el color del fondo progresivamente
            ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(),
                    Color.BLUE, Color.GRAY, Color.parseColor("#FFA500"), Color.BLACK);
            colorAnimation.setDuration(2000);
            colorAnimation.addUpdateListener(animator -> {
                int color = (int) animator.getAnimatedValue();
                frameLayout.setBackgroundColor(color);
            });
            colorAnimation.start();
        });
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
