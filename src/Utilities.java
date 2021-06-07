import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Utilities {
    public static String makeQuestion(String enunciado) {
        String valor = " ";
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            System.out.print(enunciado + " ");
            valor = br.readLine();
        } catch (IOException ex) {
            System.out.println("Error");
        }
        return valor;
    }

    public static void space()
    {
        System.out.println("Pulsa ENTER para continuar.");
        Scanner scanner1 = new Scanner(System.in);
        String inputline = scanner1.nextLine();
    }

}
