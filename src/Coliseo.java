import java.util.ArrayList;
import java.util.List;

public class Coliseo {

    private List<Gladiador> gladiadores;
    private List<PersonalTrainer> personalTrainers;
    private List<Producto> productos;
    private List<Vendedor> vendedores;
    private List<Enfermera> enfermeras;

    public Coliseo() {
        gladiadores = new ArrayList<>();
        personalTrainers = new ArrayList<>();
        productos = new ArrayList<>();
        vendedores = new ArrayList<>();
        enfermeras = new ArrayList<>();
    }

    public void inscribirGladiador (String nombre, Double nivelVida, Double nivelAtaque, Double nivelDefensa){
        Gladiador unGladiador = new Gladiador(nombre, nivelVida, nivelAtaque, nivelDefensa);
        gladiadores.add(unGladiador);
    }

    public void inscribirPersonalTrainer(String nombre, Double porcentaje){
        PersonalTrainer unPersonal = new PersonalTrainer(nombre, porcentaje);
        personalTrainers.add(unPersonal);
    }

    public void inscribirEnfermera(String nombre){
        Enfermera unaEnfermera = new Enfermera(nombre);
        enfermeras.add(unaEnfermera);
    }

    public void inscribirVendedor(String nombre, Double carisma, Double experiencia, Integer matricula){
        Vendedor unVendedor = new Vendedor(nombre, carisma, experiencia, matricula);
        vendedores.add(unVendedor);
    }

    public void expulsarGladiador(String nombre){
        Gladiador unGladiador = buscarGladiador(nombre);
        if(unGladiador!= null){
            gladiadores.remove(unGladiador);
            System.out.println(unGladiador+" ha sido expulsado");
        }
        else {
            System.out.println("No existe el gladiador "+nombre);
        }

    }

    public void entrenarGladiador (String gladiador, String entrenador){
        Gladiador unGladiador = buscarGladiador(gladiador);
        PersonalTrainer unEntrenador = buscarPersonalTrainer(entrenador);
        if (unEntrenador != null){
            if(unGladiador!= null){
                unGladiador.entrenar(unEntrenador.getPorcentaje());
                actualizarGladiador(unGladiador);
                System.out.println(entrenador+" entreno a "+unGladiador);
            }
            else {
                System.out.println("No existe el Gladiador "+unGladiador);
            }
        }
        else {
            System.out.println("No existe el Personal Trainer "+unEntrenador);
        }
    }


    public void vender(String vendedor, String espectador, String producto){
        Vendedor unVendedor = buscarVendedor(vendedor);
        Producto unProducto = buscarProducto(producto);
        Double precio = unProducto.getPrecio();

        if (unProducto!= null){
            if (unVendedor!= null){
                precio+= unVendedor.getCarisma()+unVendedor.getExperiencia();
                System.out.println(unVendedor+" le vendio a "+espectador+" 1 "+unProducto+" a "+precio);
            }
            else {
                System.out.println("No existe el vendedor "+unVendedor);
            }
        }
        else {
            System.out.println("No existe el producto "+unProducto);
        }
    }

    public void curarGladiador (String enfermera, String gladiador){
        Enfermera unaEnfermera = new Enfermera(enfermera);
        Gladiador unGladiador = buscarGladiador(gladiador);
        unaEnfermera.curarGladiador(unGladiador);
        System.out.println(unaEnfermera+" curo a "+unGladiador);
    }

    public void peleaGladiadores (String gladiadorAtacante, String gladiadorAtacado){
        Gladiador gladiadorATQ = buscarGladiador(gladiadorAtacante);
        Gladiador gladiadorDEF = buscarGladiador(gladiadorAtacado);
        Double daño = gladiadorATQ.getAtaque()-gladiadorDEF.getDefensa();

        if (gladiadorATQ.getAtaque()<=gladiadorDEF.getDefensa()){
            System.out.println("El gladiador "+gladiadorDEF+" se defendio exitosamente de el gladiador "+gladiadorATQ);
        }
        else {
            System.out.println("El gladiador "+gladiadorATQ+" le hizo "+daño+" de daño a el gladiador "+gladiadorDEF);
            gladiadorDEF.hacerDaño(daño);
            actualizarGladiador(gladiadorDEF);
        }
    }

    public void darAltaProducto(String nombre, Double precio){
        Producto unProducto = new Producto(nombre, precio);
        productos.add(unProducto);
    }


    public Gladiador buscarGladiador(String nombre){
        Gladiador unGladiador = null;
        for (Gladiador gladiadorB:gladiadores) {
            if (gladiadorB.getNombre().equals(nombre)){
                unGladiador = gladiadorB;
            }
        }
        return unGladiador;
    }

    public Vendedor buscarVendedor(String nombre){
        Vendedor unVendedor = null;
        for (Vendedor vendedorB : vendedores) {
            if (vendedorB.getNombre().equals(nombre)){
                unVendedor = vendedorB;
            }
        }
        return unVendedor;
    }

    public PersonalTrainer buscarPersonalTrainer(String nombre){
        PersonalTrainer unPersonal = null;

        for (PersonalTrainer personalB : personalTrainers){
            if (personalB.getNombre().equals(nombre)){
                unPersonal= personalB;
            }
        }
        return unPersonal;
    }

    public void actualizarGladiador (Gladiador unGladiador){
        for (Gladiador gladiadorB : gladiadores){
            if (gladiadorB.getNombre().equals(unGladiador.getNombre())){
                gladiadorB = unGladiador;
            }
        }
    }

    public Producto buscarProducto (String nombre){
        Producto unProducto = null;

        for (Producto productoB : productos) {
            if (productoB.getNombre().equals(nombre)){
                unProducto = productoB;
            }
        }
        return unProducto;
    }
}
