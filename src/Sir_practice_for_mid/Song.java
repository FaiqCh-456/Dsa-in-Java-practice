package Sir_practice_for_mid;

class Song {
    String title;
    String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
}

class Node2 {
    Song song;
    Node2 next;

    public Node2(Song song) {
        this.song = song;
        this.next = null;
    }
}

class Playlist {
    Node2 head;
    Node2 tail;

    public void addSong(String title, String artist) {
        Song newSong = new Song(title, artist);
        Node2 newNode = new Node2(newSong);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void displayPlaylist() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }
        System.out.println("Playlist:");
        Node2 current = head;
        int index = 1;
        while (current != null) {
            System.out.println(index + ". " + current.song.getTitle() + " - " + current.song.getArtist());
            current = current.next;
            index++;
        }
    }

    public void removeSong(String title, String artist) {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }
        if (head.song.getTitle().equalsIgnoreCase(title) && head.song.getArtist().equalsIgnoreCase(artist)) {
            head = head.next;
            System.out.println("Song '" + title + "' by " + artist + " removed from the playlist.");
            return;
        }
        Node2 current = head;
        Node2 prev = null;
        boolean found = false;
        while (current != null) {
            if (current.song.getTitle().equalsIgnoreCase(title) && current.song.getArtist().equalsIgnoreCase(artist)) {
                prev.next = current.next;
                System.out.println("Song '" + title + "' by " + artist + " removed from the playlist.");
                found = true;
                break;
            }
            prev = current;
            current = current.next;
        }
        if (!found) {
            System.out.println("Song '" + title + "' by " + artist + " not found in the playlist.");
        }
    }

    public void shufflePlaylist() {
        // Convert linked list to array for shuffling
        int size = getSize();
        Song[] songs = new Song[size];
        Node2 current = head;
        for (int i = 0; i < size; i++) {
            songs[i] = current.song;
            current = current.next;
        }

        // Shuffle the array
        for (int i = size - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            Song temp = songs[i];
            songs[i] = songs[j];
            songs[j] = temp;
        }

        // Reconstruct the playlist from the shuffled array
        head = null;
        tail = null;
        for (Song song : songs) {
            addSong(song.getTitle(), song.getArtist());
        }
        System.out.println("Playlist shuffled successfully.");
    }

    private int getSize() {
        int size = 0;
        Node2 current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }
}
 class Main1 {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();

        // Adding songs to the playlist
        playlist.addSong("Lonely", "Akon");
        playlist.addSong("Tasweer bna k", "Sajjad Ali");
        playlist.addSong("Nahin Milta", "Bayyan");

        // Displaying the playlist
        playlist.displayPlaylist();

        // Removing a song from the playlist
        playlist.removeSong("Lonely", "Akon");
        playlist.displayPlaylist();

        // Shuffling the playlist
        playlist.shufflePlaylist();
        playlist.displayPlaylist();
    }
}

