import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if (playList.size() == 0) {
            System.out.printf("This playlist has no song");
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }
        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("End of list. No more songs available.");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("This is the first song.");
                        forward = false;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are currently at the start of the list.");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.printf("Now playing " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached to the end of the list.");
                        }
                    }
                    break;

                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next().toString());
                        } else {
                            if (listIterator.hasPrevious()) {
                                System.out.println("Now playing " + listIterator.previous().toString());
                            }
                        }
                    }
            }
        }
    }

    private static void printMenu() {
        System.out.println("Current available options :\n press the following : ");
        System.out.println("0 - Exit\n" +
                "1 - play the next song\n" +
                "2 - play the previous song\n" +
                "3 - replay current song\n" +
                "4 - list all songs\n" +
                "5 - print all available options\n" +
                "6 - delete current song");
    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> itr = playList.iterator();
        System.out.println("===================");

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println("===================");
    }

    public static void main(String[] args) {

        Album album = new Album("album1", "Guns & Roses");

        album.addSong("TNT", 4.5);
        album.addSong("Highway to hell", 6.5);
        album.addSong("ThunderStruck", 3.2);
        albums.add(album);


        album = new Album("album2", "50 Cent");

        album.addSong("RoadStreet", 4.5);
        album.addSong("Lose yourself", 6.5);
        album.addSong("Em & ems", 3.2);
        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();

        albums.get(0).addToPlayList("TNT", playList_1);
        albums.get(0).addToPlayList("Highway to hell", playList_1);
        albums.get(0).addToPlayList("ThunderStruck", playList_1);
        albums.get(1).addToPlayList("RoadStreet", playList_1);

        play(playList_1);
    }
}
