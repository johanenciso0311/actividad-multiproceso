package Ejercicio3;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ping {


    public static void main(String[] args) {
        Decision();
    }

    public static boolean SystemOperations (){
        return System.getProperty("os.name").contains("Windows");
    }

    public static void Decision (){
        String decision;
        do {
            decision = opcion();
            switch (decision)
            {
                case "1":
                    Ping("1.1.1.1");
                    break;
                case "2":
                    Ping("www.google.com");
                    break;
                case "3":
                    // esto nos genera si o si un error
                    Ping("www.you3tube.com");
                    break;
                case "4":
                    System.out.println("Adios");
                    break;
                default:

            }
        }while(!decision.equals("4"));

    }

    public static String Ping (String ip){
        String line = "";
        if (SystemOperations()) {
            try {
                ProcessBuilder code = new ProcessBuilder("cmd.exe", "/c", "ping", ip);
                Process process = code.start();
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

                InputStream error = process.getErrorStream();
                InputStreamReader errorReader = new InputStreamReader(error);
                BufferedReader bufferedError = new BufferedReader(errorReader);


                String linea = bufferedError.readLine();
                while (linea != null) {
                    System.out.println(linea);
                    linea = bufferedError.readLine();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return line;
        } else {
            try {
                ProcessBuilder code = new ProcessBuilder("ping", "-c 4", ip);
                Process process = code.start();
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

                InputStream error = process.getErrorStream();
                InputStreamReader errorReader = new InputStreamReader(error);
                BufferedReader bufferedError = new BufferedReader(errorReader);


                String linea = bufferedError.readLine();
                while (linea != null) {
                    System.out.println(linea);
                    linea = bufferedError.readLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return line;
        }
    }


    public static String opcion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Introduce el numero de la opcion que quieras realizar");
        System.out.println(" 1. Cloudflare \n 2. Wikipedia \n 3. Google \n 4. Salir");
        return scanner.nextLine();
    }

}
