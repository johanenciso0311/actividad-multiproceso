package Ejercicio1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class VariosComandos {

    public static void main(String[] args) {
        decision();
    }


    public static boolean SystemOperations (){
        return System.getProperty("os.name").contains("Windows");

    }

    public static String CurrentDirectory (){
        String line = "";
        if (SystemOperations()) {
            try {
                ProcessBuilder code = new ProcessBuilder("cmd.exe","/c","cd");
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


            }catch (Exception e) {
                e.printStackTrace();

            }
            return line;
        } else {
            try {
                ProcessBuilder code = new ProcessBuilder("pwd");
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
            }catch (Exception e) {
                e.printStackTrace();
            }

            return line;
        }




    }


    public static String SystemInfo (){
        String line = "";
        if(SystemOperations()){
            try {
                ProcessBuilder code = new ProcessBuilder("cmd.exe","/c","systeminfo");
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


            }catch (Exception e) {
                e.printStackTrace();
            }
            return line;
        }else {
            try {
                ProcessBuilder code = new ProcessBuilder("uname","-a");
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
            }catch (Exception e) {
                e.printStackTrace();
            }
            return line;
        }

    }

    public static String CurrentDate (){
        String line = "";

        if (SystemOperations()){
            try{
            ProcessBuilder code = new ProcessBuilder("cmd.exe","/c","date/T");
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

        }
        catch (Exception e) {
            e.printStackTrace();
        }
            return line;
        }else {
            try {
                ProcessBuilder code = new ProcessBuilder("date");
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
            }catch (Exception e) {
                e.printStackTrace();
            }
            return line;
        }


    }

    public static void decision(){
        String command;
        do {
            command = pedirDecision();
            switch (command) {
                case "1":
                    CurrentDirectory();
                    break;
                case "2":
                    SystemInfo();
                    break;
                case "3":
                    CurrentDate();
                    break;
                case "4":
                    System.out.println("Has salido del programa");
                    break;

                default:
                    System.out.println("No se ha encontrado el comando");
            }
        } while (!command.equals("4"));



    }

    public static String pedirDecision (){
        Scanner scanner = new Scanner(System.in);
        String command = "";

            System.out.println("\n\nIntroduce el comando que deseas ejecutar:  \n1 - El directorio actual, \n2 - Información del sistema, \n3 - Fecha actual, \n4 - Salir  \n\n");
            command = scanner.nextLine();




        return command;
    }

}
