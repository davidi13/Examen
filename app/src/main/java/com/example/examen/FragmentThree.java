package com.example.examen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentThree extends Fragment {

    private SeekBar redSeekBar, greenSeekBar, blueSeekBar;
    private Button changeColorButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);

        redSeekBar = view.findViewById(R.id.red_seek_bar);
        greenSeekBar = view.findViewById(R.id.green_seek_bar);
        blueSeekBar = view.findViewById(R.id.blue_seek_bar);
        changeColorButton = view.findViewById(R.id.change_color_button);

        changeColorButton.setOnClickListener(v -> {
            // Obtener valores RGB
            int red = redSeekBar.getProgress();
            int green = greenSeekBar.getProgress();
            int blue = blueSeekBar.getProgress();

            // Calcular color
            int color = (0xFF << 24) | (red << 16) | (green << 8) | blue;

            // Enviar color al SecondActivity
            ((SecondActivity) requireActivity()).updateTextColor(color);
        });

        return view;
    }
}
