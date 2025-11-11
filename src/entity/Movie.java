package entity;

public class Movie extends Media {
    private int duration;
    private int releaseDate;

    public Movie(String title, double rating, String category, int duration, int releaseDate) {
        super(title, rating, category);
        this.duration = duration;
        this.releaseDate = releaseDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setRealeaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "entity.Movie{"+
                "title='" + super.getTitle() + '\'' +
                ", rating=" + super.getRating() +
                ", category='" + super.getCategory() + '\''+
                "duration=" + duration +
                ", realeaseDate=" + releaseDate +
                '}';
    }
}
