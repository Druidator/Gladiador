public class Gladiador {

    private String nombre;
    private Double vida;
    private Double ataque;
    private Double defensa;

    public Gladiador(String nombre, Double vida, Double ataque, Double defensa) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public void curar() {
        vida= 10.0;
    }

    public void entrenar (Double porcentaje){
        vida += (porcentaje*vida);
        ataque += (porcentaje*ataque);
        defensa += (porcentaje*defensa);
    }

    @Override
    public String toString() {
        return nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getAtaque() {
        return ataque;
    }

    public Double getDefensa() {
        return defensa;
    }

    public void hacerDaño(Double daño){
        vida-= daño;
    }
}
