package com.example.examen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentOne extends Fragment {

    private EditText editText;
    private SeekBar seekBar;
    private Button changeTextButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        editText = view.findViewById(R.id.edit_text);
        seekBar = view.findViewById(R.id.seek_bar);
        changeTextButton = view.findViewById(R.id.change_text_button);

        changeTextButton.setOnClickListener(v -> {
            String text = editText.getText().toString();
            float size = seekBar.getProgress();

            // Enviar el texto y el tamaño al SecondActivity
            ((SecondActivity) requireActivity()).updateTextSize(text, size);
        });

        return view;
    }
}
