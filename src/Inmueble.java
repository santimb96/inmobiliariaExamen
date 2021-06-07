import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public abstract class Inmueble {
    private Integer metrosCuadrados;
    private Double precio;
    private String nombrePueblo;
    private Integer ID;

    //getters y setters:
    public Integer getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public void setMetrosCuadrados(Integer metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getNombrePueblo() {
        return nombrePueblo;
    }

    public void setNombrePueblo(String nombrePueblo) {
        this.nombrePueblo = nombrePueblo;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    //constructores:
    public Inmueble() {
    }

    public Inmueble(Integer metrosCuadrados, Double precio, String nombrePueblo, Integer ID) {
        this.metrosCuadrados = metrosCuadrados;
        this.precio = precio;
        this.nombrePueblo = nombrePueblo;
        this.ID = ID;
    }

    //toString();
    @Override
    public String toString() {
        return "---------INMUEBLE--------\n" +
                "m2: " + getMetrosCuadrados() + "\n" +
                "precio: " + getPrecio() + "\n" +
                "nombre del pueblo: " + getNombrePueblo() + "\n" +
                "Identificador: " + getID();
    }

    //solicita datos comunes para ambas subclases:
    public void solicitarDatos() {
        Scanner scanner = new Scanner(System.in);
        Terreno terreno = new Terreno();
        Vivienda vivienda = new Vivienda();

        //preguntamos datos:
        System.out.println("Metros cuadrados: ");
        Integer m2 = scanner.nextInt();

        System.out.println("Precio: ");
        Double precio = scanner.nextDouble();

        System.out.println("Nombre del pueblo: ");
        String nombrePueblo = scanner.next();

        System.out.println("ID: ");
        Integer id = scanner.nextInt();

        //escogemos opción:

        System.out.println("Estás creando un Terreno(t) o una Vivienda(v)?: ");
        String opcion = scanner.next();
        //controlamos que la opción introducida sea válida y el precio mayor que 0 en ambos casos:
        //(si el precio es menor a 0, directamente no se crea el objeto a la hora de añadir)
        if (opcion.equals("t") && precio > 0) {
            terreno.solicitarDatos(m2, precio, nombrePueblo, id);
        } else if (opcion.equals("v") && precio > 0) {
            vivienda.solicitarDatos(m2, precio, nombrePueblo, id);
        } else {
            System.out.println("El precio es menor a 0 o no has introducido una opción correcta");
        }
    }

    //busca vivienda por el número de habitaciones:
    public static void buscarVivienda() {
        //guardamos la lista en una variable para que se pueda entender mejor:
        List<Inmueble> inmuebles = Inmobiliaria.getListaInmuebles();

        Integer habitaciones = parseInt(Utilities.makeQuestion("Número de habitaciones"));

        //recorremos la lista:
        for (int i = 0; i < inmuebles.size(); i++) {
            if (inmuebles.get(i) instanceof Vivienda) {
                if (((Vivienda) inmuebles.get(i)).getNumeroHabitaciones().equals(habitaciones)) {
                    System.out.println(inmuebles.get(i).toString());
                }
            }
        }
    }

    //busca terreno por clasificación:
    public static void buscarTerreno() {
        //guardamos la lista en una variable para que se pueda entender mejor:
        List<Inmueble> inmuebles = Inmobiliaria.getListaInmuebles();

        String tipo = Utilities.makeQuestion("Tipo de terreno");
        boolean encontrado = false;
        for (int i = 0; i < inmuebles.size(); i++) {
            if (inmuebles.get(i) instanceof Terreno) {
                if (((Terreno) inmuebles.get(i)).getCalificacion().equals(tipo)) {
                    System.out.println(inmuebles.get(i).toString());
                    encontrado = true;
                }
            }
            if (encontrado == true) {
                break;
            }
        }
    }
}
