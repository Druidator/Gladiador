public class Enfermera {

    private String nombre;

    public Enfermera(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public void curarGladiador(Gladiador unGladiador){
        unGladiador.curar();
    }
}
