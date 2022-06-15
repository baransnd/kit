package edu.kit.informatik.UB3.AufgabeA;

/**
 * A Songlist-Class, which creates a simply linked list, with list methods
 * such as addLast, remove, getByIndex and getSize.
 * @author uboal
 * @version 1.0
 */

public class SongList {

    /**
     * A List-cell Subclass, which creates a list cell with a song as the content,
     * and a next List-cell as an attribute.
     * @author uboal
     * @version 1.0
     */

    private class ListCell {
        Song song;
        ListCell nextSong;

        /**
         * Constructor of the List-cell.
         */

        public ListCell(Song song, ListCell nextSong) {
            this.song = song;
            this.nextSong = nextSong;
        }

    }

    private ListCell head;
    private int size;

    /**
     * Constructor of the Song-list, which is initialized empty at the start
     */

    public SongList() {
        this.head = null;
        this.size = 0;
    }


    //methods

    /**
     * A method, which adds a song at the end of the list.
     * @param song the songs which will be added to the list
     */
    public void addLast(Song song) {
        if (this.head == null) {
            this.head = new ListCell(song, null);
            size ++;
            return;
        }

        ListCell c = this.head;
        while (c.nextSong != null) {
            c = c.nextSong;
        }

        c.nextSong = new ListCell(song, null);
        size++;
    }

    /**
     * A method, which removes all the songs with the given
     * id from the song-list.
     * @param id all songs with this id will be removed from
     *           the list.
     * @return number of removed Songs will be returned
     */
    public int removeSong(int id) {

        int numberOfRemovedSongs = 0;

        ListCell c = this.head;

        while (c != null && c.song.getId() == id) {
            this.head = c = c.nextSong;
            numberOfRemovedSongs++;
        }

        //if the list is empty, can't remove
        if (c == null) {
            this.size -= numberOfRemovedSongs;
            return numberOfRemovedSongs;
        }

        while (c.nextSong != null) {
            if (c.nextSong.song.getId() == id) {
                c.nextSong = c.nextSong.nextSong;
                numberOfRemovedSongs++;
            } else {
                c = c.nextSong;
            }
        }
        this.size -= numberOfRemovedSongs;
        return numberOfRemovedSongs;
    }

    /**
     * A method, which removes  one song with the given
     * id from the song-list.
     * @param id first song with this id will be removed from
     *           the list.
     */
    public void removeSingleSong(int id) {
        ListCell c = this. head;

        if (c == null) {
            return;
        }
        if (this.head != null && c.song.getId() == id) {
            this.head = c = c.nextSong;
            size--;
            return;
        }
        while (c.nextSong != null) {
            if (c.nextSong.song.getId() == id) {
                c.nextSong = c.nextSong.nextSong;
                size--;
                return;
            } else {
                c = c.nextSong;
            }
        }

    }

    /**
     * A method, which gives the song at a given index of the list.
     * @param i index, from which the song will be returned.
     * @return song, the song at the given index.
     */

    public Song getSongAtIndex(int i) {
        ListCell c = this.head;
        int j = 0;

        while (c != null) {
            if (i == j) {
                break;
            }
            c = c.nextSong;
            j++;
        }
        return c.song;
    }

    /**
     * A method, which returns the size of the list.
     */
    public int getSize() {
        return this.size;
    }






}

