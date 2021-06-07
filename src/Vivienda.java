import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Vivienda extends Inmueble {
    private Integer numeroHabitaciones;
    private String descripcion;

    //getters y setters:
    public Integer getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    public void setNumeroHabitaciones(Integer numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //constructores:

    public Vivienda() {
    }

    public Vivienda(Integer metrosCuadrados, Double precio, String nombrePueblo, Integer ID, Integer numeroHabitaciones, String descripcion) {
        super(metrosCuadrados, precio, nombrePueblo, ID);
        this.numeroHabitaciones = numeroHabitaciones;
        this.descripcion = descripcion;
    }

    //toString():
    @Override
    public String toString() {
        precioCompraventa();
        return "---------VIVIENDA--------\n" +
                "m2: " + getMetrosCuadrados() + "\n" +
                "precio (compraventa): " + String.format("%.2f",getPrecio())+"€"+ "\n" +
                "nombre del pueblo: " + getNombrePueblo() + "\n" +
                "Identificador: " + getID() + "\n" +
                "Num.Habitaciones: " + getNumeroHabitaciones() + "\n" +
                "descripcion: " + getDescripcion() + "\n";
    }

    public void añadirVivienda() {
        super.solicitarDatos();
    }

    public void solicitarDatos(Integer m2, Double precio, String nombrePueblo, Integer id) {
        //preguntamos atributos subclase:
        Integer nHabitaciones = parseInt(Utilities.makeQuestion("Número de habitaciones"));
        while(nHabitaciones==0){
            System.out.println("Ha de haber al menos una habitación\n");
            nHabitaciones = parseInt(Utilities.makeQuestion("Número de habitaciones"));
        }
        String descripcion = Utilities.makeQuestion("Descripción breve de la habitación");
        //añadimos objeto nuevo a la lista:
        Inmobiliaria.getListaInmuebles().add(new Vivienda(m2, precio, nombrePueblo, id, nHabitaciones, descripcion));
        System.out.println("\nVivienda añadida!");
    }
    public void precioCompraventa(){
        Double IVA=1.10;
        List<Inmueble> inmuebles=Inmobiliaria.getListaInmuebles();
        for (int i = 0; i < inmuebles.size(); i++) {
            if(inmuebles.get(i) instanceof Vivienda){
                inmuebles.get(i).setPrecio(getPrecio()*IVA);
            }
        }
    }
}
