package Ejercicio2;

import java.io.*;

public class InstalledProgramsToFile {


    public static void main(String[] args) {
        saveToFile(InstalledPrograms(), "installedPrograms.txt");
    }
    public static boolean SystemOperations (){
        return System.getProperty("os.name").contains("Windows");
    }

    public static String InstalledPrograms (){
        StringBuilder result = new StringBuilder();
        if (SystemOperations()) {
            try {
                ProcessBuilder code = new ProcessBuilder("cmd.exe", "/c", "dir", "C:\\Program Files");
                Process process = code.start();

                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line).append("\n");
                }

                InputStream errorStream = process.getErrorStream();
                BufferedReader errorReader = new BufferedReader(new InputStreamReader(errorStream));
                while ((line = errorReader.readLine()) != null) {
                    System.err.println("ERROR: " + line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                ProcessBuilder code = new ProcessBuilder("ls", "-l", "/bin");
                Process process = code.start();
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;

                while ((line = reader.readLine()) != null) {
                    result.append(line).append("\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result.toString();
    }


    public static void saveToFile(String content, String fileName) {



        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println("todo ah salido bien al parecer para el fichero " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
