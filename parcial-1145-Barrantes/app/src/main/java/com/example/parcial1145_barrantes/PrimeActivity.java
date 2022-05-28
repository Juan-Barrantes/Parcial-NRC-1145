package com.example.parcial1145_barrantes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.parcial1145_barrantes.adapters.UserAdapter;
import com.example.parcial1145_barrantes.databinding.ActivityPrimeBinding;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;

public class PrimeActivity extends AppCompatActivity {
    private ActivityPrimeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPrimeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        leerServicio();
    }

    private void leerServicio() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://servicios.campus.pe/visitasselect.php";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("DATOS",response);
                        llenarLista(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("DATOS",error.getMessage());
            }
        });
        queue.add(stringRequest);
    }

    private void llenarLista(String response) {
        ArrayList arrayList = new ArrayList<HashMap<String,String>>();
        try {
            JSONArray jsonArray = new JSONArray(response);
            for(int i = 0; i<jsonArray.length(); i++){
                String nombre = jsonArray.getJSONObject(i).getString("nombres");
                String email = jsonArray.getJSONObject(i).getString("correoelectronico");
                String edad  = jsonArray.getJSONObject(i).getString("edad");
                String comentario = jsonArray.getJSONObject(i).getString("comentario");
                HashMap<String,String> map = new HashMap<>();
                map.put("nombres",nombre);
                map.put("correoelectronico",email);
                map.put("edad",edad);
                map.put("comentario",comentario);
                arrayList.add(map);
            }

            String[] origen = {"nombres","correoelectronico","edad","comentario"};
            int[] destino = {R.id.tvUserNombre,R.id.tvUserCorreo,R.id.tvUserEdad, R.id.tvUserComentario};
            ListAdapter listAdapter = new SimpleAdapter(
                    this,
                    arrayList,
                    R.layout.item_users,
                    origen,
                    destino
            );

            binding.lvUser.setAdapter(listAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}