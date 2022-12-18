package ordered;

public class Song {
    private String title;
    private String artist;
    private int length;

    public Song(String title, String artist, int length) {
        setArtist(artist);
        setLength(length);
        setTitle(title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null) {
            throw new IllegalArgumentException("Title cannot be null");
        }
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        if (artist == null) {
            throw new IllegalArgumentException("Artist cannot be null");
        }
        this.artist = artist;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Track length must be positive.");
        }
        this.length = length;
    }
}
