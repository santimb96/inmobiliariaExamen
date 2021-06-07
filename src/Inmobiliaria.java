import java.util.ArrayList;
import java.util.List;

public class Inmobiliaria {
    private String nombre;
    private String CIF;
    private static List<Inmueble> listaInmuebles = new ArrayList<>();
    private static List<Inmobiliaria> listaInmobiliarias = new ArrayList<>();


    //getters y setters:
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public static List<Inmueble> getListaInmuebles() {
        return listaInmuebles;
    }

    public static void setListaInmuebles(List<Inmueble> listaInmuebles) {
        Inmobiliaria.listaInmuebles = listaInmuebles;
    }
    public static List<Inmobiliaria> getListaInmobiliarias() {
        return listaInmobiliarias;
    }

    public static void setListaInmobiliarias(List<Inmobiliaria> listaInmobiliarias) {
        Inmobiliaria.listaInmobiliarias = listaInmobiliarias;
    }
    //constructores:

    public Inmobiliaria(){}

    public Inmobiliaria(String nombre, String CIF) {
        this.nombre = nombre;
        this.CIF = CIF;
    }

    //toString():
    @Override
    public String toString() {
        return  "---------INMOBILIARIA--------\n"+
                "nombre: "+getNombre()+"\n"+
                "CIF: "+getCIF()+"\n";
    }
}
