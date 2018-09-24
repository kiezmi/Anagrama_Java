import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

//https://es.stackoverflow.com/questions/41519/identificar-una-anagrama

public class LeerFichero {


    public static void muestraContenido(String archivo, String texto) throws IOException {

        ArrayList<String> diccionario = new ArrayList<String>();
        String cadena;
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);


        while ((cadena = br.readLine()) != null) {
            diccionario.add(cadena);
        }
        br.close();

        comprobarContenido(texto, diccionario);
    }

    public static void comprobarContenido(String texto, ArrayList<String> diccionario) {
        for (int i = 0; i < diccionario.size(); i++) {

            char[] array1 = texto.toCharArray();
            char[] array2 = diccionario.get(i).toCharArray();

            Arrays.sort(array1);
            Arrays.sort(array2);

            if (new String(array1).equals(new String(array2))) {
                System.out.println("Es anagrama " + diccionario.get(i));
            }
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        System.out.println("Introduzca su texto: ");
        String texto = scan.next();
        muestraContenido("/home/kiezmi/IdeaProjects/Anagramas/wordlist.txt", texto);
    }
}
