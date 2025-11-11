package util;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {
    public void createFile(ArrayList<String> userInfo, String path){
        try {
            FileWriter writer = new FileWriter(path);
            for (String s : userInfo) {
                writer.write(s+"\n");
            }
            writer.close();

        }catch (IOException e) {
            System.out.println("problem: "+ e.getMessage());
        }
    }
    public ArrayList<String> readFile(String path) {
        ArrayList<String> data = new ArrayList<>();
        File file = new File(path);
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                data.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Filen findes ikke på valgte path: "+ path);
        }
        return data;
    }
    //muligt der mangler en metode til at læse filen som indeholder userInfoet
    //som er tweaket til at læse igennem for et matchene brugernavn og password

    //test
    /*public void createUserFile(String username, String password, ArrayList<String> watchedMovies,
                               ArrayList<String> watchedSeries, ArrayList<String> savedMovies,
                               String path){
        try {
            FileWriter writer = new FileWriter(path);
            for (String s : userInfo) {
                writer.write(s+"\n");
            }
            writer.close();

        }catch (IOException e) {
            System.out.println("problem: "+ e.getMessage());
        }
    } */
}
