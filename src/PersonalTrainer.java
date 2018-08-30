public class PersonalTrainer {

    private String nombre;
    private Double porcentaje;

    public PersonalTrainer(String nombre, Double porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public String getNombre() {
        return nombre;
    }
}
