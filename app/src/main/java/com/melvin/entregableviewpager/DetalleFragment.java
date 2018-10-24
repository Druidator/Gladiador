package com.melvin.entregableviewpager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleFragment extends Fragment {

    private static final String KEY_IMAGEN = "imagen";
    private static final String KEY_TITULO = "titulo";
    private static final String KEY_INGREDIENTES = "ingredientes";
    private static final String KEY_PREPARACION = "preparacion";

    public static DetalleFragment fabrica(Receta unaReceta){
        DetalleFragment fragment = new DetalleFragment();
        Bundle datos = new Bundle();
        datos.putInt(KEY_IMAGEN, unaReceta.getFoto());
        datos.putString(KEY_TITULO, unaReceta.getTitulo());
        datos.putString(KEY_INGREDIENTES, unaReceta.getIngredientes());
        datos.putString(KEY_PREPARACION, unaReceta.getPreparacion());
        fragment.setArguments(datos);
        return fragment;
    }


    public DetalleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalle, container, false);

        ImageView imagen = view.findViewById(R.id.imagenDetalle);
        TextView titulo = view.findViewById(R.id.titulosDetalle);
        TextView ingredientes = view.findViewById(R.id.ingredientesDetalle);
        TextView preparacion = view.findViewById(R.id.preparacionDetalle);

        Bundle datos = getArguments();

        imagen.setImageResource(datos.getInt(KEY_IMAGEN));
        titulo.setText(datos.getString(KEY_TITULO));
        ingredientes.setText(datos.getString(KEY_INGREDIENTES));
        preparacion.setText(datos.getString(KEY_PREPARACION));

        return view;
    }

}
