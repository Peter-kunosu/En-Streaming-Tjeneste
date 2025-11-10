package entity;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class User{
String username;
String password;
public ArrayList<Media> watchedMovies;
public ArrayList<ArrayList<Media>> watchedSeries;
ArrayList<Media> savedMovies;
ArrayList<Media> savedSeries;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.watchedMovies = new ArrayList<>();
        this.watchedSeries = new ArrayList<>();
        this.savedMovies = new ArrayList<>();
        this.savedSeries = new ArrayList<>();
    }

    public void CreateUserFile(String path){
        if(!path.endsWith(".txt")){
            path += ".txt";
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write("Username: "+username);
            writer.newLine();
            writer.write("Password: "+password);
            writer.newLine();
            writer.newLine();

            writer.write("Watched Movies:");
            writer.newLine();
            if(watchedMovies. isEmpty()){
                writer.write("- none");
                writer.newLine();
            } else {
                for (Media m : watchedMovies) {
                    writer.write("- " + m);
                    writer.newLine();
                }
            }
            writer.newLine();

            writer.write("Watched Series:");
            writer.newLine();
            if(watchedSeries. isEmpty()){
                writer.write("- none");
                writer.newLine();
            } else  {
                for (ArrayList<Media> series : watchedSeries) {
                    writer.write("Series:");
                    writer.newLine();
                    for (Media episode : series) {
                        writer.write(" * " + episode);
                        writer.newLine();

                    }
                }
            }
            writer.newLine();

            writer.write("Saved Movies");
            writer.newLine();
            if(savedMovies.isEmpty()){
                writer.write("- none");
                writer.newLine();
            } else {
                for (Media sM : savedMovies) {
                    writer.write("- " + sM);
                    writer.newLine();
                }
            }
            writer.newLine();

            writer.write("Saved Series");
            writer.newLine();
            if(savedSeries.isEmpty()){
                writer.write("- none");
                writer.newLine();
            } else {
                for (Media sS : savedSeries) {
                    writer.write("- " + sS);
                    writer.newLine();
                }
            }
            System.out.println("Brugerfil gemt: " + path);
        } catch (IOException e){
            System.out.println("Fejl ved skrivning af fil: " + e.getMessage());
        }
    }

    public void showWatchedMovies(){
        if(watchedMovies.isEmpty()){
            System.out.println("No watched movies");
        } else {
            System.out.println("Watched movies:");
            for (Media m : watchedMovies) {
                System.out.println(" - " + m);
            }
        }
    }

    public void showWatchedSeries(){
        if(watchedSeries.isEmpty()){
            System.out.println("No watched series");
        } else {
            System.out.println("Watched series:");
            for (ArrayList<Media> s : watchedSeries) {
                System.out.println(" - " + s);
            }
        }
    }

    public void showSavedMovies(){
        if(savedMovies.isEmpty()){
            System.out.println("No saved movies");
        }
        else {
            System.out.println("Saved movies:");
            for (Media sM : savedMovies) {
                System.out.println(" - " + sM);
            }
        }
    }

    public void showSavedSeries(){
        if(savedSeries.isEmpty()){
            System.out.println("No saved series");
        } else {
            System.out.println("Saved series:");
            for (Media sS : savedSeries) {
            System.out.println(" - " + sS);
            }
        }
    }
}

