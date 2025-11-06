import java.lang.reflect.Array;

public class Series extends Media{
    private String activeYears;
    private int totalEpisodes;
    private Array[][] episode;

    public Series(String title, float rating, String category, Array[][] episode) {
        super(title, rating, category);
        this.episode = episode;
    }

    public int getTotalEpisodes() {
        totalEpisodes = episode.length;
        return totalEpisodes;
    }

    public String getActiveYears() {
        return activeYears;
    }

    public Array[][] getEpisode() {
        return episode;
    }
}
