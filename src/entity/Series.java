package entity;

import java.util.ArrayList;

public class Series extends Media {
    private String activeYears;
    private static String mediaType = "Serie";
    private int totalEpisodes;
    private String[][] episodes;

    public Series(String title, double rating, String category, String[][] episodes, String activeYears) {
        super(title, rating, category);
        this.episodes = episodes;
        this.activeYears = activeYears;
        this.totalEpisodes = countTotalEpisodes();
    }

    public static String getMediaType() {
        return mediaType;
    }

    private int countTotalEpisodes() {
        int count = 0;
        /*for (String[] season : episodes) {
            count += season.length;
        } */
        for (int i = 0; i < episodes.length; i++) {
            for (int j = 0; j < episodes[i].length; j++) {
                count++;
            }
        }
        return count;
    }

    public int getTotalEpisodes() {
        return totalEpisodes;
    }

    public String getActiveYears() {
        return activeYears;
    }

    public String[][] getEpisodes() {
        return episodes;
    }

    public void setActiveYears(String activeYears) {
        this.activeYears = activeYears;
    }

    public void setEpisode(String[][] episodes) {
        this.episodes = episodes;
        this.totalEpisodes = countTotalEpisodes();
    }

    public ArrayList<Media> getEpisodesAsMedia() {
        ArrayList<Media> episodeList = new ArrayList<>();
        for (int i = 0; i < episodes.length; i++) {
            for (int j = 0; j < episodes[i].length; j++) {
                // Lav et Media-objekt for hver episode
                String episodeTitle = getTitle() + " - " + episodes[i][j];
                episodeList.add(new Media(episodeTitle, getRating(), getCategory()));
            }
        }
        return episodeList;
    }
    @Override
    public String toString() {
        return super.toString()+
                " | Media type = " + getMediaType()
                ;
    }
}

