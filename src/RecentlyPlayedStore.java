import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RecentlyPlayedStore {
    private final int capacityPerUser;
    private final int initialCapacity;
    private final Map<String, List<String>> store;

    public RecentlyPlayedStore(int capacityPerUser, int initialCapacity) {
        this.capacityPerUser = capacityPerUser;
        this.initialCapacity = initialCapacity;
        this.store = new LinkedHashMap<>(initialCapacity);
    }

    public void addSong(String user, String song) {
        if (!store.containsKey(user)) {
            store.put(user, new LinkedList<>());
        }

        List<String> playlist = store.get(user);
        playlist.remove(song); 
        playlist.add(0, song); 
        if (playlist.size() > capacityPerUser) {
            playlist.remove(capacityPerUser);
        }
    }

    public List<String> getRecentlyPlayedSongs(String user) {
        return store.getOrDefault(user, new LinkedList<>());
    }

    public static void main(String[] args) {
        RecentlyPlayedStore store = new RecentlyPlayedStore(3, 4);

        store.addSong("user1", "S1");
        store.addSong("user1", "S2");
        store.addSong("user1", "S3");
        System.out.println(store.getRecentlyPlayedSongs("user1")); 
        store.addSong("user1", "S4");
        System.out.println(store.getRecentlyPlayedSongs("user1")); 

        store.addSong("user1", "S2");
        System.out.println(store.getRecentlyPlayedSongs("user1")); 
        store.addSong("user1", "S1");
        System.out.println(store.getRecentlyPlayedSongs("user1")); 
    }
}