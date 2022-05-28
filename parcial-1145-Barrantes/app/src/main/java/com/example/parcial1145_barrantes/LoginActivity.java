package com.example.parcial1145_barrantes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.nav_hbo:
                mostrarHBO();
                return true;
            case R.id.nav_netflix:
                mostrarNetflix();
                return true;
            case R.id.nav_prime:
                mostrarPrime();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void mostrarHBO() {
        startActivity(new Intent(this, HboActivity.class));
    }

    private void mostrarPrime() {
        startActivity(new Intent(this, PrimeActivity.class));
        Toast.makeText(this, "Welcome to Privevideo", Toast.LENGTH_SHORT).show();

    }

    private void mostrarNetflix() {
        startActivity(new Intent(this, NetflixActivity.class));
    }


}