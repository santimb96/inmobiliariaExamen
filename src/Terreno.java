import java.util.List;
import java.util.Scanner;

public class Terreno extends Inmueble {
    private String calificacion;

    //getters y setters:
    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    //constructores:

    public Terreno() {
    }

    public Terreno(Integer metrosCuadrados, Double precio, String nombrePueblo, Integer ID, String calificacion) {
        super(metrosCuadrados, precio, nombrePueblo, ID);
        this.calificacion = calificacion;
    }

    //toString:
    @Override
    public String toString() {
        precioCompraventa();
        return "---------TERRRENO--------\n" +
                "m2: " + getMetrosCuadrados() + "\n" +
                "precio (compraventa): " + String.format("%.2f", getPrecio()) + "€" + "\n" +
                "nombre del pueblo: " + getNombrePueblo() + "\n" +
                "identificador: " + getID() + "\n" +
                "calificacion: " + getCalificacion() + "\n";
    }

    //métodoAñadirTerreno:
    public void añadirTerreno() {
        super.solicitarDatos();
    }

    //override método solicitarDatos:
    public void solicitarDatos(Integer m2, Double precio, String nombrePueblo, Integer id) {
        boolean estado = false;
        //mientras el estado sea falso(no introducir opciones correctas), el while seguirá preguntando:
        while (estado == false) {
            String tipo = Utilities.makeQuestion("Tipo de terreno");
            switch (tipo) {
                case "rustico":
                    Inmobiliaria.getListaInmuebles().add(new Terreno(m2, precio, nombrePueblo, id, "rustico"));
                    estado = true;
                    System.out.println("Terreno añadido!");
                    break;
                case "urbano":
                    Inmobiliaria.getListaInmuebles().add(new Terreno(m2, precio, nombrePueblo, id, "urbano"));
                    estado = true;
                    System.out.println("Terreno añadido!");
                    break;
                case "urbanizable":
                    Inmobiliaria.getListaInmuebles().add(new Terreno(m2, precio, nombrePueblo, id, "urbanizable"));
                    estado = true;
                    System.out.println("Terreno añadido!");
                    break;
                default:
                    estado = false;
            }
        }
    }

    //método común cálculo del precio compraventa
    public void precioCompraventa() {
        Double rustico = 1.04;
        Double urbano = 1.06;
        Double urbanizable = 1.08;
        List<Inmueble> inmuebles = Inmobiliaria.getListaInmuebles();
        for (int i = 0; i < inmuebles.size(); i++) {
            if (inmuebles.get(i) instanceof Terreno) {
                if (((Terreno) inmuebles.get(i)).getCalificacion().equals("rustico")) {
                    inmuebles.get(i).setPrecio(getPrecio() * rustico);
                } else if (((Terreno) inmuebles.get(i)).getCalificacion().equals("urbano")) {
                    inmuebles.get(i).setPrecio(getPrecio() * urbano);
                } else if (((Terreno) inmuebles.get(i)).getCalificacion().equals("urbanizable")) {
                    inmuebles.get(i).setPrecio(getPrecio() * urbanizable);
                }
            }
        }
    }
}
