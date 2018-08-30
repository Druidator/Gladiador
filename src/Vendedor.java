public class Vendedor {

    private String nombre;
    private Double carisma;
    private Double experiencia;
    private Integer matricular;

    public Vendedor(String nombre, Double carisma, Double experiencia, Integer matricular) {
        this.nombre = nombre;
        this.carisma = carisma;
        this.experiencia = experiencia;
        this.matricular = matricular;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public Double getCarisma() {
        return carisma;
    }

    public Double getExperiencia() {
        return experiencia;
    }

    public String getNombre() {
        return nombre;
    }
}
