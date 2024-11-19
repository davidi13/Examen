package com.example.examen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentTwo extends Fragment {

    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        textView = view.findViewById(R.id.text_view);
        return view;
    }

    public void updateText(String text, float size) {
        textView.setText(text);
        textView.setTextSize(size);
    }

    public void updateColor(int color) {
        textView.setTextColor(color);
    }
}
