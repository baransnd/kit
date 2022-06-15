package edu.kit.informatik.UB3.AufgabeA;

/**
 * A Song-Class, which designs a song with the requested attributes,
 * plus the remaining time to use for the play method.
 * @author uboal
 * @version 1.0
 */

public class Song {
    private int id;
    private String artist;
    private String title;
    private int length;
    private int priority;
    private int remainingTime;

    /**
     * Constructor, sets the attributes of the song by initialization.
     */
    public Song(int id, String artist, String title, int duration, int priority) {
        this.id = id;
        this.artist = artist;
        this.title = title;
        this.length = duration;
        this.priority = priority;
        this.remainingTime = length;
    }

    /**
     * Getter method for the song's id.
     * @return id, id of the song
     */
    public int getId() {
        return id;
    }

    /**
     * Getter method for the song's artist.
     * @return artist, artist of the song
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Getter method for the song's title.
     * @return title, title of the song
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter method for the song's length.
     * @return length, length of the song
     */
    public int getLength() {
        return length;
    }

    /**
     * Getter method for the song's priority.
     * @return priority, priority of the song
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Getter method for the song's id.
     * @return remaining time, remaining time of the song
     */
    public int getRemainingTime() {
        return remainingTime;
    }

    /**
     * Setter method for the song's remaining time.
     * @param remainingTime, remaining time of the song,
     */
    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }
}
