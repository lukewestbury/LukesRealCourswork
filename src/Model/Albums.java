package Model;

public class Albums {
    private int albumID;
    private int artistID;
    private String albumName;
    private int albumYear;
    private int albumLength;
    private int genreID;

    public Albums(int albumID, int artistID, String albumName, int albumYear, int albumLength, int genreID) {
        this.albumID = albumID;
        this.artistID = artistID;
        this.albumName = albumName;
        this.albumYear = albumYear;
        this.albumLength = albumLength;
        this.genreID = genreID;
    }

    public int getAlbumID() {
        return albumID;
    }

    public void setAlbumID(int albumID) {
        this.albumID = albumID;
    }

    public int getArtistID() {
        return artistID;
    }

    public void setArtistID(int artistID) {
        this.artistID = artistID;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public int getAlbumYear() {
        return albumYear;
    }

    public void setAlbumYear(int albumYear) {
        this.albumYear = albumYear;
    }

    public int getAlbumLength() {
        return albumLength;
    }

    public void setAlbumLength(int albumLength) {
        this.albumLength = albumLength;
    }

    public int getGenreID() {
        return genreID;
    }

    public void setGenreID(int genreID) {
        this.genreID = genreID;
    }
}
