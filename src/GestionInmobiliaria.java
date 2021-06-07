import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class GestionInmobiliaria {
    public static void main(String[] args) {
        //generamos objetos de tipo Terreno y Vivienda:

        Inmobiliaria.getListaInmuebles().add(new Terreno(40, 200.12, "Manacor", 1, "rustico"));
        Inmobiliaria.getListaInmuebles().add(new Vivienda(50, 100.12, "Sa Pobla", 2, 3, "Acogedor"));
        Inmobiliaria.getListaInmuebles().add(new Terreno(60, 100.12, "Monte", 3, "rustico"));
        Inmobiliaria.getListaInmobiliarias().add(new Inmobiliaria("Sa Millor", "45697747J"));
        Inmobiliaria.getListaInmobiliarias().add(new Inmobiliaria("Meh", "11111111P"));

        logIn();


    }
    public static void logIn() {
        String cif = Utilities.makeQuestion("CIF inmmobiliaria");

        for (int i = 0; i < Inmobiliaria.getListaInmobiliarias().size(); i++) {
            if (Inmobiliaria.getListaInmobiliarias().get(i).getCIF().equals(cif)) {
                System.out.println("\n Bienvenido, " + Inmobiliaria.getListaInmobiliarias().get(i).getNombre() + ".\n");
                menu();
            }
        }
        System.out.println("----------------- ¡ERROR! -----------------");
        logIn();
    }

    public static void menu() {
        while (true) {

            System.out.println("----------MENU-----------\n");
            System.out.println("1. Añadir terreno");
            System.out.println("2. Añadir vivienda");
            System.out.println("3. Buscar vivienda");
            System.out.println("4. Buscar terreno");
            System.out.println("5. Salir");

            Integer opcion = parseInt(Utilities.makeQuestion("Introduce opción deseada"));

            switch (opcion) {

                case 1:
                    Terreno terreno = new Terreno();
                    terreno.añadirTerreno();
                    break;
                case 2:
                    Vivienda vivienda = new Vivienda();
                    vivienda.añadirVivienda();
                    break;
                case 3:
                    Inmueble.buscarVivienda();
                    break;
                case 4:
                    Inmueble.buscarTerreno();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    return;
            }
        }
    }
}
