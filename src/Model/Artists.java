package Model;

public class Artists {
    private int artistID;
    private String artistName;
    private String artistBio;
    private int genreID;

    public Artists(int artistID, String name, String bio, int genreID) {
        this.artistID = artistID;
        this.artistName = name;
        this.artistBio = artistBio;
        this.genreID = genreID;
    }

    public int getArtistID() {
        return artistID;
    }

    public void setArtistID(int artistID) {
        this.artistID = artistID;
    }

    public String getName() {
        return artistName;
    }

    public void setName(String name) {
        this.artistName = artistName;
    }

    public String getBio() {
        return artistBio;
    }

    public void setBio(String bio) {
        this.artistBio = bio;
    }

    public int getGenreID() {
        return genreID;
    }

    public void setGenreID(int genreID) {
        this.genreID = genreID;
    }

}
