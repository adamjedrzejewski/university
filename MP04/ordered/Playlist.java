package ordered;

import java.util.Collections;
import java.util.List;

public class Playlist {
    private String playlistName;
    private List<Song> songs;

    public Playlist(String playlistName, List<Song> songs) {
        if (songs == null) {
            throw new IllegalArgumentException("Playlist songs list cannot be null.");
        }

        this.songs = songs;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        if (playlistName == null) {
            throw new IllegalArgumentException("Playlist name cannot be null.");
        }
        this.playlistName = playlistName;
    }

    public List<Song> getSongs() {
        return Collections.unmodifiableList(songs);
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void removeSong(Song song) {
        if (!songs.contains(song)) {
            throw new IllegalArgumentException("This song doesn't belong to this playlist.");
        }

        songs.remove(song);
    }
}
