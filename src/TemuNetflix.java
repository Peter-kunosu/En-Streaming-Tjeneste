import entity.Media;
import entity.Movie;
import entity.Series;
import util.TextUI;
import util.FileIO;
import entity.*;

import java.util.ArrayList;

public class TemuNetflix {
    public ArrayList<Media> media;
    private ArrayList<String> options;

    TextUI ui = new TextUI();
    FileIO io = new FileIO();
    User user = new User();

    private StartMenu startMenu;

    public void menuChoices(){
        ui.displayMsg(
                "Welcome to the TemuNetflix" +
                        "\n1. Movies" +
                        "\n2. Serier" +
                        "\n3. Sete Film" +
                        "\n4. Sete Serier" +
                        "\n5. Gemte Film" +
                        "\n6. Gemte Serier"
        );

        int choice = ui.readInputNum("Vælg en mulighed:");

        switch (choice) {
            case 1:
                ui.displayMsg("Du valgte: Movies");

                break;

            case 2:
                ui.displayMsg("Du valgte: Serier");

                break;

            case 3:
                ui.displayMsg("Du valgte: Sete Film");
                user.showWatchedMovies();
                break;

            case 4:
                ui.displayMsg("Du valgte: Sete Serier");
                user.showWatchedSeries();
                break;

            case 5:
                ui.displayMsg("Du valgte: Gemte Film");
                user.showSavedMovies();
                break;

            case 6:
                ui.displayMsg("Du valgte: Gemte Serier");
                user.showSavedSeries();
                break;

            default:
                ui.displayMsg("Ugyldigt valg – prøv igen!");
                break;
        }
    }

    public void startStartMenu(){

    }
    public void loadMediaData(String path) {
        ArrayList<String> data = io.readFile(path);
        media = new ArrayList<>();

        for (String line : data) {
            // Fjern evt. whitespace
            line = line.trim();
            if (line.isEmpty()) continue;

            // Split linjen op på semikolon
            String[] parts = line.split(";");

            String title = parts[0].trim();
            String year = parts[1].trim();
            String category = parts[2].trim();
            String ratingStr = parts[3].trim().replace(",", ".");
            double rating = Double.parseDouble(ratingStr);

            // Hvis linjen indeholder episodeinformation, så er det en serie
            if (parts.length > 4 && parts[4].contains("-")) {
                String activeYears = year;
                String episodeInfo = parts[4].trim();
                String[][] episodes = parseEpisodeInfo(episodeInfo);

                Series series = new Series(title, rating, category, episodes, activeYears);
                media.add(series);
            } else {
                int releaseYear = Integer.parseInt(year);
                Movie movie = new Movie(title, rating, category, 120, releaseYear);
                media.add(movie);
            }
        }
    }
    private String[][] parseEpisodeInfo(String episodeInfo) {
        // Eksempel på format: "1-10, 2-10, 3-13"
        String[] seasons = episodeInfo.split(",");
        String[][] episodes = new String[seasons.length][];

        for (int i = 0; i < seasons.length; i++) {
            String s = seasons[i].trim();
            String[] parts = s.split("-");
            int seasonNumber = Integer.parseInt(parts[0]);
            int episodeCount = Integer.parseInt(parts[1]);
            episodes[i] = new String[episodeCount];
            for (int j = 0; j < episodeCount; j++) {
                episodes[i][j] = "S" + seasonNumber + "E" + (j + 1);
            }
        }

        return episodes;
    }
}
