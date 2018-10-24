package com.melvin.entregableviewpager;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;



import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecetasFragment.RecetaListener {

    // Son variables de la clase para poder llamarlas en los otros metodos

    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecetasFragment recetasFragment = new RecetasFragment();
        final AboutFragment aboutFragment = new AboutFragment();
        drawer = findViewById(R.id.drawerMain);

        NavigationView navigationView = findViewById(R.id.navView);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                drawer.closeDrawers();

                switch (item.getItemId()){

                    case R.id.itemRecetas:
                        cargarFragment(recetasFragment);
                        return true;

                    case R.id.itemAboutUs:
                        cargarFragment(aboutFragment);
                        return true;
                }

                return false;
            }
        });

        // Inicializo el Toggle

        toggle = new ActionBarDrawerToggle(this, drawer, R.string.abirarDrawer, R.string.cerrarDrawer);

        // Se lo agrego como DrawerListener al DrawerLayout

        drawer.addDrawerListener(toggle);

        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void cargarFragment(Fragment unFragment){
        FragmentManager manager = getSupportFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();

        transaction.replace(R.id.fragmentContianer, unFragment);

        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(Gravity.START)){
            drawer.closeDrawers();
        }
        else {
            FragmentManager manager = getSupportFragmentManager();
            Fragment fragment = manager.findFragmentById(R.id.fragmentContianer);
            if (fragment != null){
                manager.beginTransaction().remove(fragment).commit();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override
    public void aDetalleActivity(ArrayList<Receta> datos, Integer posicion) {
        Intent unIntent = new Intent(MainActivity.this, DetalleActivity.class);

        Bundle unBundle = new Bundle();

        unBundle.putInt(DetalleActivity.KEY_POSICION, posicion);

        unIntent.putExtras(unBundle);

        unIntent.putParcelableArrayListExtra(DetalleActivity.KEY_RECETAS, datos);

        startActivity(unIntent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (toggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
}
