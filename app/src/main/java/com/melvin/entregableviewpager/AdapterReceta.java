package com.melvin.entregableviewpager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterReceta extends RecyclerView.Adapter implements ItemTouchHelperGestures.GestureListener{

    private ArrayList<Receta> datos;
    private ArrayList<Receta> datosCopia = new ArrayList<>();
    private AdapterRecetaListener listener;

    public AdapterReceta(ArrayList<Receta> datos, AdapterRecetaListener listener) {
        this.datos = datos;
        this.listener = listener;
        this.datosCopia.addAll(this.datos);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();

        LayoutInflater inflador = LayoutInflater.from(context);

        View view = inflador.inflate(R.layout.layout_item_receta, parent, false);

        ViewHolderReceta holder = new ViewHolderReceta(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ViewHolderReceta holderReceta = (ViewHolderReceta) holder;

        holderReceta.cargar(datos.get(position));

    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    private class ViewHolderReceta extends RecyclerView.ViewHolder{

        private TextView titulo;
        private ImageView imagen;


        public ViewHolderReceta(View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.textoTitulo);
            imagen = itemView.findViewById(R.id.imagen);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.aDetalle(datos, getAdapterPosition());
                }
            });
        }

        public void cargar(Receta unaReceta){
            titulo.setText(unaReceta.getTitulo());
            imagen.setImageResource(unaReceta.getFoto());
        }
    }

    public interface AdapterRecetaListener {
        void aDetalle(ArrayList<Receta> datos, Integer posicion);
    }


    @Override
    public boolean itemMovido(int posicionOrigen, int posicionDestino) {
        Receta unaReceta = datos.get(posicionOrigen);
        datos.remove(posicionOrigen);
        datos.add(posicionDestino, unaReceta);
        notifyItemMoved(posicionOrigen, posicionDestino);
        return true;
    }

    @Override
    public void itemBorrado(int posicion) {
        datos.remove(posicion);
        notifyItemRemoved(posicion);
    }


    public void filtro(String texto){
        datos.clear();
        if (texto.isEmpty())
            datos.addAll(datosCopia);
        else {
            texto = texto.toLowerCase();
            for (Receta unaReceta : datosCopia){
                if (unaReceta.getTitulo().toLowerCase().contains(texto)){
                    datos.add(unaReceta);
                }
            }
        }
        notifyDataSetChanged();
    }


}
