package entity;

public class Movie extends Media {
    private int duration;
    private int releaseDate;
    private static String mediaType = "Movie";

    public Movie(String title, double rating, String category, int duration, int releaseDate) {
        super(title, rating, category);
        this.duration = duration;
        this.releaseDate = releaseDate;
    }

    public static String getMediaType() {
        return mediaType;
    }

    public int getDuration() {
        return duration;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    @Override
    public String toString() {
        return super.toString()+
                " | Media type = " + getMediaType()
                ;
    }
}
