public class Main {

    public static void main(String[] args) {
	// write your code here

        Coliseo romano = new Coliseo();

        romano.inscribirGladiador("Aquiles", 8.70, 9.50, 5.60);
        romano.inscribirGladiador("Hercules", 10.0, 6.50, 9.60);
        romano.inscribirGladiador("Antonidas", 3.70, 12.50, 3.60);
        romano.inscribirGladiador("Julius", 5.70, 5.50, 4.60);

        romano.inscribirEnfermera("Claudia");

        romano.inscribirPersonalTrainer("Mefisto", 0.20);

        romano.inscribirVendedor("Talcahuano", 3.20, 5.60, 88659);

        romano.darAltaProducto("Agua", 3.50);

        romano.vender("Talcahuano", "Pepe", "Agua");

        romano.peleaGladiadores("Aquiles", "Antonidas");

        romano.curarGladiador("Julia", "Antonidas");

        romano.expulsarGladiador("Antonidas");
        romano.expulsarGladiador("Antonidas");

        romano.peleaGladiadores("Aquiles", "Hercules");
        romano.peleaGladiadores("Aquiles", "Julius");

        romano.entrenarGladiador("Aquiles", "Mefisto");

        romano.peleaGladiadores("Aquiles", "Hercules");

        romano.peleaGladiadores("Hercules", "Aquiles");

    }
}
