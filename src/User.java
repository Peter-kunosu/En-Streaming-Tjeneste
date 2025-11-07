import java.lang.reflect.Array;
import java.util.ArrayList;

public class User{
String username;
String password;
ArrayList<Media> watchedMovies;
ArrayList<ArrayList<Media>> watchedSeries;
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

