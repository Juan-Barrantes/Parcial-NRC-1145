package com.example.parcial1145_barrantes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.example.parcial1145_barrantes.databinding.ActivityHboBinding;
import com.example.parcial1145_barrantes.fragments.Hbo1Fragment;
import com.example.parcial1145_barrantes.fragments.Hbo2Fragment;


public class HboActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityHboBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hbo);
        binding = ActivityHboBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSerie1.setOnClickListener(this);
        binding.btnSerie2.setOnClickListener(this);

        mostrarSerie1();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSerie1:
                mostrarSerie1();
                break;
            case R.id.btnSerie2:
                mostrarSerie2();
                break;
        }
    }

    private void mostrarSerie1() {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new Hbo1Fragment())
                .commit();


    }

    private void mostrarSerie2() {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new Hbo2Fragment())
                .commit();

    }
}
