import java.util.LinkedList;

public class LinkedListClass {
    public static void main(String[] args) {
        LinkedList<String> songs = new LinkedList<String>();
        songs.add("Song 1");
        songs.add("Song 2");
        songs.add("Song 3");
        songs.add("Song 4");
        songs.add("Song 5");
        songs.add("Song 6");
        songs.add("Song 7");
        songs.addFirst("First Song");
        songs.addLast("Last Song");
        System.out.println("Size of songs : " + songs.size());
        System.out.println("Original Contents of Songs : " + songs);
        songs.remove("Song 3");
        songs.remove(5);
        System.out.println("Size of songs : " + songs.size());
        System.out.println("Original Contents of Songs : " + songs);
        System.out.println("First song is removed : " + songs.removeFirst());
        System.out.println("Last song is removied : " + songs.removeLast());    
        System.out.println("Size of songs : " + songs.size());
        System.out.println("Original Contents of Songs : " + songs);
    }
}
