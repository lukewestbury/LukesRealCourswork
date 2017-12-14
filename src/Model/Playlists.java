package Model;

public class Playlists {
    private int playlistID;
    private String playlistName;
    private String playlistBio;
    private int playlistLength;

    public Playlists(int playlistID, String playlistName, String playlistBio, int playlistLength) {
        this.playlistID = playlistID;
        this.playlistName = playlistName;
        this.playlistBio = playlistBio;
        this.playlistLength = playlistLength;
    }

    public int getPlaylistID() {
        return playlistID;
    }

    public void setPlaylistID(int playlistID) {
        this.playlistID = playlistID;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public String getPlaylistBio() {
        return playlistBio;
    }

    public void setPlaylistBio(String playlistBio) {
        this.playlistBio = playlistBio;
    }

    public int getPlaylistLength() {
        return playlistLength;
    }

    public void setPlaylistLength(int playlistLength) {
        this.playlistLength = playlistLength;
    }
}
