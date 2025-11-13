package entity;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class User{
String username;
String password;
public ArrayList<Media> watchedMovies;
    public ArrayList<Series> watchedSeries = new ArrayList<>();
public ArrayList<Media> savedMovies;
    public ArrayList<Series> savedSeries = new ArrayList<>();


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
                for (Series series : watchedSeries) {
                    writer.write("- " + series.getTitle());
                    writer.newLine();
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

    public void updateUserFile(String path) {
        if (!path.endsWith(".txt")) path += ".txt";

        try {
            File file = new File(path);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }

            ArrayList<String> newLines = new ArrayList<>();
            newLines.add("");
            newLines.add("-- Updated --");
            newLines.add("Username: " + username);
            newLines.add("Password: " + password);
            newLines.add("");

            int counter = 0;
            newLines.add("Watched Movies:");
            if (watchedMovies.isEmpty()) {
                newLines.add("- none");
            } else {
                for (Media m : watchedMovies) {
                    counter++;
                    newLines.add(counter + ". " + m);
                }
            }
            newLines.add("");

            newLines.add("Watched Series:");
            if (watchedSeries.isEmpty()) {
                newLines.add("- none");
            } else {
                for (Series series : watchedSeries) {
                    counter++;
                    newLines.add(counter + ". " + series.getTitle());
                }
            }
            newLines.add("");

            newLines.add("Saved Movies:");
            if (savedMovies.isEmpty()) {
                newLines.add("- none");
            } else {
                for (Media m : savedMovies) {
                    counter++;
                    newLines.add(counter + ". " + m);
                }
            }
            newLines.add("");

            newLines.add("Saved Series:");
            if (savedSeries.isEmpty()) {
                newLines.add("- none");
            } else {
                for (Series series : savedSeries) {
                    counter++;
                    newLines.add(counter + ". " + series.getTitle());
                }
            }
            newLines.add("");

            java.nio.file.Files.write(
                    file.toPath(),
                    newLines,
                    java.nio.file.StandardOpenOption.APPEND
            );

        } catch (IOException e) {
            System.out.println("Fejl ved opdatering af fil: " + e.getMessage());
        }
    }


    public void showWatchedMovies(){
        int counter = 0;
        if(watchedMovies.isEmpty()){
            System.out.println("No watched movies");
        } else {
            System.out.println("Watched movies:");
            for (Media m : watchedMovies) {
                counter++;
                System.out.println(counter+". " + m);
            }
        }
    }

    public void showWatchedSeries(){
        int counter = 0;
        if(watchedSeries.isEmpty()){
            System.out.println("No watched series");
        } else {
            System.out.println("Watched series:");
            for (Series s : watchedSeries) {
                counter++;
                System.out.println(counter + ". " + s.getTitle());
            }
        }
    }

    public void showSavedMovies(){
        int counter = 0;
        if(savedMovies.isEmpty()){
            System.out.println("No saved movies");
        }
        else {
            System.out.println("Saved movies:");
            for (Media sM : savedMovies) {
                counter++;
                System.out.println(counter+". " + sM);
            }
        }
    }

    public void showSavedSeries(){
        int counter = 0;
        if(savedSeries.isEmpty()){
            System.out.println("No saved series");
        } else {
            System.out.println("Saved series:");
            for (Series s : savedSeries) {
                counter++;
                System.out.println(counter + ". " + s.getTitle());
            }
        }
    }
}

