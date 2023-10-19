package PaooGame.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//Clasa are rolul de a citi fisiere si de a parsa caracterele in int
public class Utils {
    //Metoda implementeaza citirea dintr-un fisier
    public static String loadFileAsString(String path) // parametrul reprezinta locatia fisierului in calculator
    {
        StringBuilder builder = new StringBuilder(); // StringBuilder ne permite sa adaugam caractere la un string

        try{
            BufferedReader br = new BufferedReader(new FileReader(path)); // acum putem folosi obiectul br sa citim din fisier
            String line;
            while((line = br.readLine()) != null) {
                builder.append(line + "\n");
            }
            br.close();
        }
        catch(IOException e)
        {
            e.printStackTrace(); // afisam eroarea pe ecran
        }

        return builder.toString();
    }

    //Metoda ce implementeaza parsarea argumentului de tip String intr-un numar intreg
    public static int parseInt(String number)
    {
        try{
            return Integer.parseInt(number);
        }
        catch(NumberFormatException e)
        {
            e.printStackTrace();
            return 0;
        }
    }
}
