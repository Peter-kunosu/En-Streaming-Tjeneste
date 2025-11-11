import entity.Media;
import entity.Movie;
import entity.Series;
import util.TextUI;
import util.FileIO;

import java.util.ArrayList;

public class TemuNetflix {
    public ArrayList<Media> media;
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
            line = line.trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split(";");


            if (parts.length < 4) continue;

            String title = parts[0].trim();
            String year = parts[1].trim();
            String category = parts[2].trim();
            String ratingStr = parts[3].trim().replace(",", ".");
            double rating = Double.parseDouble(ratingStr);


            if (parts.length > 4 && parts[4].contains("-")) {
                Series series = loadSeries(title, year, category, rating, parts[4].trim());
                media.add(series);
            } else {
                Movie movie = loadMovie(title, year, category, rating);
                media.add(movie);
            }
        }
    }


    private Movie loadMovie(String title, String year, String category, double rating) {
        int releaseYear;
        try {
            releaseYear = Integer.parseInt(year);
        } catch (NumberFormatException e) {
            releaseYear = 0;
        }
        return new Movie(title, rating, category, 120, releaseYear);
    }


    private Series loadSeries(String title, String activeYears, String category, double rating, String episodeInfo) {
        String[][] episodes = parseEpisodeInfo(episodeInfo);
        return new Series(title, rating, category, episodes, activeYears);
    }


    private String[][] parseEpisodeInfo(String episodeInfo) {
        String[] seasons = episodeInfo.split(",");
        String[][] episodes = new String[seasons.length][];

        for (int i = 0; i < seasons.length; i++) {
            String s = seasons[i].trim();
            String[] parts = s.split("-");
            if (parts.length < 2) continue;

            int seasonNumber = Integer.parseInt(parts[0]);
            int episodeCount = Integer.parseInt(parts[1]);

            episodes[i] = new String[episodeCount];
            for (int j = 0; j < episodeCount; j++) {
                episodes[i][j] = "S" + seasonNumber + "E" + (j + 1);
            }
        }
        return episodes;
    }

    public ArrayList<Media> getMedia() {
        return media;
    }
}
