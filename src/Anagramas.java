import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

//como leer anagramas
//https://es.stackoverflow.com/questions/41519/identificar-una-anagrama

class MiAnagrama {

    public static String getPalabra() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduzca su texto: ");
        String texto = scan.next();
        return texto;
    }

    public static void comprobacion(String texto, ArrayList<String> diccionario) {
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

    public static ArrayList<String> getDicionario(String archivo) throws IOException {
        ArrayList<String> diccionario = new ArrayList<String>();
        String cadena;
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);

        while ((cadena = br.readLine()) != null) {
            diccionario.add(cadena);
        }
        br.close();
        return diccionario;
    }

    public static void main(String[] args) throws IOException {
/*
        MiAnagrama.getDicionario("/home/kiezmi/IdeaProjects/Anagramas/wordlist.txt");
        MiAnagrama.getPalabra();
        */
        MiAnagrama.comprobacion(MiAnagrama.getPalabra(), MiAnagrama.getDicionario("/home/kiezmi/IdeaProjects/Anagramas/wordlist.txt"));
    }
}
