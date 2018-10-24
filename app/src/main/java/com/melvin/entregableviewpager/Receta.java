package com.melvin.entregableviewpager;

import android.os.Parcel;
import android.os.Parcelable;

public class Receta implements Parcelable {

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){
        public Receta createFromParcel(Parcel in){
            return new Receta(in);
        }

        public Receta[] newArray(int size){
            return new Receta[size];
        }
    };

    private String titulo;
    private Integer foto;
    private String ingredientes;
    private String preparacion;

    public Receta(String titulo, Integer foto, String ingredientes, String preparacion) {
        this.titulo = titulo;
        this.foto = foto;
        this.ingredientes = ingredientes;
        this.preparacion = preparacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getFoto() {
        return foto;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public String getPreparacion() {
        return preparacion;
    }


    // Para poder parcelearlo

    public Receta(Parcel in){
        this.titulo = in.readString();
        this.foto = in.readInt();
        this.ingredientes = in.readString();
        this.preparacion = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.titulo);
        dest.writeInt(this.foto);
        dest.writeString(this.ingredientes);
        dest.writeString(this.preparacion);
    }
}
