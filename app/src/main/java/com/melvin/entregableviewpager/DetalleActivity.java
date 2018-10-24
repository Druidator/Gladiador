package com.melvin.entregableviewpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class DetalleActivity extends AppCompatActivity {

    public static final String KEY_RECETAS = "recetas";
    public static final String KEY_POSICION = "posicion";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        ViewPager pager = findViewById(R.id.viewPagerDetalle);

        ArrayList<Receta> datos = getIntent().getParcelableArrayListExtra(KEY_RECETAS);

        Integer posicion = getIntent().getExtras().getInt(KEY_POSICION);

        final DetalleAdapter adapter = new DetalleAdapter(getSupportFragmentManager(), datos);

        pager.setAdapter(adapter);

        pager.setCurrentItem(posicion);


    }
}
