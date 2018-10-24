package com.melvin.entregableviewpager;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

public class ItemTouchHelperGestures extends android.support.v7.widget.helper.ItemTouchHelper.Callback {

    private GestureListener escuchador;

    public ItemTouchHelperGestures(GestureListener escuchador) {
        this.escuchador = escuchador;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        // Para habilitar ambas direcciones en cada caso de gesto
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipeFlags = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {

        escuchador.itemMovido(viewHolder.getAdapterPosition(), target.getAdapterPosition());

        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

        escuchador.itemBorrado(viewHolder.getAdapterPosition());
    }


    //Para habilitar los 2 gestos

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    public interface GestureListener{

        boolean itemMovido(int posicionOrigen, int posicionDestino);

        void itemBorrado(int posicion);
    }
}
