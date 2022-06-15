package edu.kit.informatik.UB3.AufgabeA;

/**
 * A Priority-list, which is an array of simply-linked lists,
 * with a size of 6, as there are 6 numbers ( 0 to 5 ) a song can have,
 * as its priority.
 * @author uboal
 * @version 1.0
 */
public class PriorityList {

    private final SongList[] priorityList;
    private final SongList playedSongs;
    private Song firstSong;
    private int numberOfSongs;

    /**
     * Constructor, creates the array and fills the indexes 0 through 5,
     * with song-lists. Also sets the current number of the songs to 0,
     * and sets the first song as null.
     */
    public PriorityList() {

        this.priorityList = new SongList[6];
        this.playedSongs = new SongList();
        this.numberOfSongs = 0;


        for (int i = 0; i < priorityList.length; i++) {
            this.priorityList[i]  = new SongList();
        }

        this.firstSong = null;
    }


    /**
     * Aufgabe.1.2.1
     *
     * This is a method which adds a song to the priority list in the right place.
     * @param id returns the id of the song
     * @param artist returns the artist of the song
     * @param title returns the title of the song
     * @param length returns the length of the song
     * @param priority returns the priority of the song
     */
    public void add(int id, String artist, String title, int length, int priority) {
        Song newSong = new Song(id, artist, title, length, priority);
        priorityList[priority].addLast(newSong);
        numberOfSongs++;
        this.setFirstSong();
    }

    /**
     * Aufgabe.1.2.2
     *
     * A method, which removes all the songs with the given
     * id from the priority list.
     * @param id the songs with this id will be removed from
     *           the priority list.
     * @return returns the amount of deleted tracks as a string
     */
    public String remove(int id, boolean allSongs) {

        int numberOfRemovedSongs = 0;

        for (int i = 0; i < priorityList.length; i++) {
            for (int j = 0; j < priorityList[i].getSize(); j++) {

                if (priorityList[i].getSongAtIndex(j).getId() == id) {

                    if (priorityList[i].getSongAtIndex(j) == this.firstSong) {
                        this.firstSong = null;
                    }

                    numberOfRemovedSongs += priorityList[i].removeSong(id);

                    if (!allSongs) {
                        return "";
                    }

                    break;

                }
            }
        }

        return "Removed " + numberOfRemovedSongs + " songs. \n";
    }


    /**
     * Aufgabe. 1.2.3
     * This is a method which plays the songs for the given duration
     * @param length length, for which the songs will be played
     */
    public void play(int length) {
        if (this.firstSong == null) {
            return;
        }

        for (int i = 0; i < priorityList.length; i++) {
            while (priorityList[i].getSize() != 0) {
                if (length < this.firstSong.getRemainingTime()) {
                    this.firstSong.setRemainingTime(firstSong.getRemainingTime() - length);
                    return;
                }
                length -= firstSong.getRemainingTime();
                this.playedSongs.addLast(this.firstSong);
                this.priorityList[i].removeSingleSong(firstSong.getId());
                this.firstSong = null;
                this.setFirstSong();

            }
        }

    }

    /**
     * Aufgabe.1.2.4
     *
     * This is a method which skips the current song.
     */

    public void skip() {
        if (numberOfSongs == 0) {
            return;
        }
        this.removeFirstSong(firstSong.getId());
        numberOfSongs--;
        this.firstSong = null;
        this.setFirstSong();
    }

    /**
     * Aufgabe.1.2.5
     *
     * This is a method which shows the first song on the list,
     * which is next to play.
     * @return returns the first song on the priority list.
     */
    public String peek() {
        if (this.firstSong == null) {
            this.setFirstSong();
            if (this.firstSong == null) {
                return "";
            }
        }
        return  this.songToString(firstSong) + ":" + this.firstSong.getRemainingTime() + "\n";
    }

    /**
     * Aufgabe.1.2.6
     *
     * This is a method which shows all the songs in the priority-list.
     * @return returns all songs on the priority list.
     */
    public String list() {
        String list = "";
        for(int i = 0; i < priorityList.length; i++) {
            for (int j = 0; j < priorityList[i].getSize(); j++) {
                list += songToString(priorityList[i].getSongAtIndex(j))  + "\n";
            }
        }
        return  list;
    }

    /**
     * Aufgabe.1.2.7
     *
     * This is a method which shows all the songs which have been played
     * in full length
     */
    public String history() {
        String playedTracks = "";
        for (int i = 0; i < this.playedSongs.getSize(); i++) {
            playedTracks += songToString(this.playedSongs.getSongAtIndex(i))  + "\n";
        }

        return playedTracks;
    }






    //helper methods
    /**
     *
     * This is a method which sets the first song of the first
     * non-empty list as first song
     */
    private void setFirstSong() {
        for (int i = 0; i < priorityList.length; i++) {
            if(priorityList[i].getSize() != 0) {
                this.firstSong = priorityList[i].getSongAtIndex(0);
                return;
            }
        }
    }

    /**
     *
     * This is a method which removes the first song on the
     * priority list.
     * @param id id of the song to be removed.
     */
    private void removeFirstSong(int id) {
        for (int i = 0; i < priorityList.length; i++) {
            for (int j = 0; j < priorityList[i].getSize(); j++) {
                if (priorityList[i].getSongAtIndex(j).getId() == id) {
                    priorityList[i].removeSingleSong(id);
                    numberOfSongs--;
                    return;
                }
            }
        }

    }

    /**
     *
     * This is a method which builds a string in the intended way,
     * from the attributes of a song.
     * @param song song, which will be formatted into a string.
     */
    private String songToString(Song song) {
        return String.format("%05d", song.getId()) + ":" + song.getArtist() + ":" + song.getTitle() + ":" + song.getLength();
    }

    private int getFirstSong() {
        return this.firstSong.getRemainingTime();
    }

}
