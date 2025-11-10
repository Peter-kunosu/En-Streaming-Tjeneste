import entity.Media;
import entity.Movie;
import entity.Series;
import util.TextUI;
import util.FileIO;

import java.util.ArrayList;

public class TemuNetflix {
    private ArrayList<Media> media;
    private ArrayList<String> options;

    TextUI ui = new TextUI();
    FileIO io = new FileIO();

    private StartMenu startMenu;

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
