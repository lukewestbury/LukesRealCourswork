package Model;

public class PlaylistSongs {
    private int playlistID;
    private int songID;

    public PlaylistSongs(int playlistID, int songID) {
        this.playlistID = playlistID;
        this.songID = songID;
    }

    public int getPlaylistID() {
        return playlistID;
    }

    public void setPlaylistID(int playlistID) {
        this.playlistID = playlistID;
    }

    public int getSongID() {
        return songID;
    }

    public void setSongID(int songID) {
        this.songID = songID;
    }
}
