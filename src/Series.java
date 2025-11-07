import java.util.Arrays;

public class Series extends Media {
    private String activeYears;
    private int totalEpisodes;
    private String[][] episodes;

    public Series(String title, double rating, String category, String[][] episodes, String activeYears) {
        super(title, rating, category);
        this.episodes = episodes;
        this.activeYears = activeYears;
        this.totalEpisodes = countTotalEpisodes();
    }

    private int countTotalEpisodes() {
        int count = 0;
        for (String[] season : episodes) {
            count += season.length;
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

    @Override
    public String toString() {
        return "Series{" +
                "title='" + getTitle() + '\'' +
                ", category='" + getCategory() + '\'' +
                ", rating=" + getRating() +
                ", activeYears='" + activeYears + '\'' +
                ", totalEpisodes=" + totalEpisodes +
                ", seasons=" + episodes.length +
                '}';
    }

}

