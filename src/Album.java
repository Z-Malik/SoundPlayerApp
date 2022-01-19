import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }
    public Album(){
    }

    /*
    Function to iterate through the 'songs' list and contribute to 'addSong' methods
    functionality.
     */
    public Song findSong(String title) {
        for (Song checkedSong : songs) {
            if (checkedSong.getTitle().equals(title)) {
                return checkedSong;
            }
        }
        return null;
    }
    /*
    Functionality to add new songs.
    If song is 'null' (does not exist) using the 'findSong' function,
    the new song is to be added to the 'songs' playlist.
     */
    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            songs.add(new Song(title, duration));
//            System.out.println(title + "Successfully added to the list.");
            return true;
        }
        else {
//            System.out.println("Song with name " + title + " already exists within the list.");
            return false;
        }
    }



    /*
    Function to only add songs which exist within the playlist.
    The song must already exist within our 'songs' arraylist first - only then can it be added to our playlist.
    LinkedList local parameter is used to keep track of the songs before and after the current.
     */
    public boolean addToPlayList(int trackNumber, LinkedList<Song> PlayList) {
        int index = trackNumber - 1;
        if (index > 0 && index <= this.songs.size()) {
            PlayList.add(this.songs.get(index));
            return true;
        }
//        System.out.println("This album does not have a song with this track number " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> PlayList) {
        for (Song checkedSong : this.songs) {
            if (checkedSong.getTitle().equals(title)) {
                PlayList.add(checkedSong);
                return true;
            }
        }
//        System.out.println(title + "There is no such song in this album.");
        return false;
    }
}
