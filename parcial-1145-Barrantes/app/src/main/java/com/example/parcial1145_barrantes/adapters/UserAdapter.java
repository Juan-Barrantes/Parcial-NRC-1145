package com.example.parcial1145_barrantes.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parcial1145_barrantes.R;

import java.util.ArrayList;
import java.util.HashMap;

public class UserAdapter  extends RecyclerView.Adapter<UserAdapter.viewHolder> {
    ArrayList<HashMap<String, String>> arrayList;
    public UserAdapter(ArrayList<HashMap<String, String>> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_users,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        HashMap<String, String> map = arrayList.get(position);
        holder.mtvUserCorreo.setText(map.get("nombres"));
        holder.mtvUserCorreo.setText(map.get("correoelectronico"));
        holder.mtvUserEdad.setText(map.get("edad "));
        holder.mtvUserComentario.setText(map.get("comentario "));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView mtvUserNombres, mtvUserCorreo, mtvUserEdad, mtvUserComentario;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            mtvUserNombres = itemView.findViewById(R.id.tvUserNombre);
            mtvUserCorreo = itemView.findViewById(R.id.tvUserCorreo);
            mtvUserEdad = itemView.findViewById(R.id.tvUserEdad);
            mtvUserComentario = itemView.findViewById(R.id.tvUserComentario);
        }
    }
}
