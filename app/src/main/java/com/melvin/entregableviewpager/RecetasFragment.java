package com.melvin.entregableviewpager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecetasFragment extends Fragment implements AdapterReceta.AdapterRecetaListener, SearchView.OnQueryTextListener {

    // El adapter tiene que ser una variable de la clase para poder llamarla en la implementacion
    // de los metodos de Listener

    private AdapterReceta adapter;
    private ArrayList<Receta> datos;


    public RecetasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recetas, container, false);

        setHasOptionsMenu(true);

        datos = new ArrayList<>();

        datos.add(new Receta(getString(R.string.polloTitulo), R.drawable.pollo, getString(R.string.polloIngredientes), getString(R.string.polloPreparacion)));
        datos.add(new Receta(getString(R.string.conejoTitulo), R.drawable.conejo, getString(R.string.conejoIngredientes), getString(R.string.conejoPreparacion)));
        datos.add(new Receta(getString(R.string.espaguetisTitulo), R.drawable.espagueti, getString(R.string.espaguetisIngredientes), getString(R.string.espaguetisPreparacion)));
        datos.add(new Receta(getString(R.string.tartaTitulo), R.drawable.tarta, getString(R.string.tartaIngredientes), getString(R.string.tartaPreparacion)));
        datos.add(new Receta(getString(R.string.arrozTitulo), R.drawable.arroz, getString(R.string.arrozIngredientes), getString(R.string.arrozPreparacion)));
        datos.add(new Receta(getString(R.string.trufasTitulo), R.drawable.trufas, getString(R.string.trufasIngredientes), getString(R.string.trufasPreparacion)));
        datos.add(new Receta(getString(R.string.polloTitulo), R.drawable.pollo, getString(R.string.polloIngredientes), getString(R.string.polloPreparacion)));
        datos.add(new Receta(getString(R.string.conejoTitulo), R.drawable.conejo, getString(R.string.conejoIngredientes), getString(R.string.conejoPreparacion)));
        datos.add(new Receta(getString(R.string.espaguetisTitulo), R.drawable.espagueti, getString(R.string.espaguetisIngredientes), getString(R.string.espaguetisPreparacion)));
        datos.add(new Receta(getString(R.string.tartaTitulo), R.drawable.tarta, getString(R.string.tartaIngredientes), getString(R.string.tartaPreparacion)));
        datos.add(new Receta(getString(R.string.arrozTitulo), R.drawable.arroz, getString(R.string.arrozIngredientes), getString(R.string.arrozPreparacion)));
        datos.add(new Receta(getString(R.string.trufasTitulo), R.drawable.trufas, getString(R.string.trufasIngredientes), getString(R.string.trufasPreparacion)));
        datos.add(new Receta(getString(R.string.polloTitulo), R.drawable.pollo, getString(R.string.polloIngredientes), getString(R.string.polloPreparacion)));
        datos.add(new Receta(getString(R.string.conejoTitulo), R.drawable.conejo, getString(R.string.conejoIngredientes), getString(R.string.conejoPreparacion)));
        datos.add(new Receta(getString(R.string.espaguetisTitulo), R.drawable.espagueti, getString(R.string.espaguetisIngredientes), getString(R.string.espaguetisPreparacion)));
        datos.add(new Receta(getString(R.string.tartaTitulo), R.drawable.tarta, getString(R.string.tartaIngredientes), getString(R.string.tartaPreparacion)));
        datos.add(new Receta(getString(R.string.arrozTitulo), R.drawable.arroz, getString(R.string.arrozIngredientes), getString(R.string.arrozPreparacion)));
        datos.add(new Receta(getString(R.string.trufasTitulo), R.drawable.trufas, getString(R.string.trufasIngredientes), getString(R.string.trufasPreparacion)));

        RecyclerView recycler = view.findViewById(R.id.recyclerRecetas);

        recycler.setHasFixedSize(true);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        adapter = new AdapterReceta(datos, this);

        recycler.setLayoutManager(manager);

        recycler.setAdapter(adapter);

        // La clase Callback es el comunicador entre mi aplicacion y el "Receptor de toques" (ItemTouchHelper)
        // Le paso el adapter porque es el Escuchador de lo que habla mi ItemTouchHelperGestures

        ItemTouchHelper.Callback callback = new ItemTouchHelperGestures(adapter);

        // Se necesita crear primero el Callback con mi clase personalizaada
        // y con el callback crear el ItemTouchHelper

        ItemTouchHelper gestosHelper = new ItemTouchHelper(callback);

        gestosHelper.attachToRecyclerView(recycler);


        return view;
    }

    @Override
    public void aDetalle(ArrayList<Receta> datos, Integer posicion) {
        RecetaListener listener = (RecetaListener) getContext();

        listener.aDetalleActivity(datos, posicion);
    }

    public interface RecetaListener {
        void aDetalleActivity(ArrayList<Receta> datos, Integer posicion);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        // Despues de crear el menu, se infla en este metodo, buscas el item del Menu po su ID y
        // a ese tiem le pedis el ActioView y lo casteas al SearchView para ponerle el listener
        // que es (en este caso) este fragment (Que implementa OnQueryTextListener) y despues
        // con "super" que haga lo que hace el metodo originalmente

        inflater.inflate(R.menu.menu_busqueda, menu);

        MenuItem item = menu.findItem(R.id.busqueda);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(this);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        adapter.filtro(query);

        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        adapter.filtro(newText);

        return true;
    }

}
