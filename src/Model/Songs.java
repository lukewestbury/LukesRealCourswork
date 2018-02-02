package Model;

public class Songs {
    private int songID;
    private int artistID;
    private int albumID;
    private int genreID;
    private String songName;
    private int trackNo;
    private int songLength;

    public Songs(int songID, int artistID, int albumID, int genreID, String songName, int trackNo, int songLength) {
        this.songID = songID;
        this.artistID = artistID;
        this.albumID = albumID;
        this.genreID = genreID;
        this.songName = songName;
        this.trackNo = trackNo;
        this.songLength = songLength;
    }

    public int getSongID() {
        return songID;
    }

    public void setSongID(int songID) {
        this.songID = songID;
    }

    public int getArtistID() {
        return artistID;
    }

    public void setArtistID(int artistID) {
        this.artistID = artistID;
    }

    public int getAlbumID() {
        return albumID;
    }

    public void setAlbumID(int albumID) {
        this.albumID = albumID;
    }

    public int getGenreID() {
        return genreID;
    }

    public void setGenreID(int genreID) {
        this.genreID = genreID;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public int getTrackNo() {
        return trackNo;
    }

    public void setTrackNo(int trackNo) {
        this.trackNo = trackNo;
    }

    public int getSongLength() {
        return songLength;
    }

    public void setSongLength(int songLength) {
        this.songLength = songLength;
    }

    @Override
    public String toString() {
        return "Songs{" +
                "songID=" + songID +
                ", artistID=" + artistID +
                ", albumID=" + albumID +
                ", genreID=" + genreID +
                ", songName='" + songName + '\'' +
                ", trackNo=" + trackNo +
                ", songLength=" + songLength +
                '}';
    }
}
