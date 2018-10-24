package com.melvin.entregableviewpager;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class DetalleAdapter extends FragmentPagerAdapter {

    private List<Receta> datos;
    private List<DetalleFragment> fragments = new ArrayList<>();

    public DetalleAdapter(FragmentManager fm, List<Receta> datos) {
        super(fm);
        this.datos = datos;

        for (Receta unaReceta : datos){
            DetalleFragment fragment = DetalleFragment.fabrica(unaReceta);

            fragments.add(fragment);
        }
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return datos.size();
    }
}
