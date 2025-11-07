public class Movie extends Media{
    private int duration;
    private int releaseDate;

    public Movie(String title, double rating, String category, int duration, int realeaseDate) {
        super(title, rating, category);
        this.duration = duration;
        this.releaseDate = realeaseDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getRealeaseDate() {
        return releaseDate;
    }

    public void setRealeaseDate(int realeaseDate) {
        this.releaseDate = realeaseDate;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "duration=" + duration +
                ", realeaseDate=" + releaseDate +
                '}';
    }
}
