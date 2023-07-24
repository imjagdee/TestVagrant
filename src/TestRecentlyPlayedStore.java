import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRecentlyPlayedStore {

    private RecentlyPlayedStore store;

    @BeforeEach
    public void setUp() {
        store = new RecentlyPlayedStore(3, 4);
    }

    @Test
    public void testRecentlyPlayedSongs() {
        store.addSong("user1", "S1");
        store.addSong("user1", "S2");
        store.addSong("user1", "S3");
        assertEquals(List.of("S3", "S2", "S1"), store.getRecentlyPlayedSongs("user1"));

        store.addSong("user1", "S4");
        assertEquals(List.of("S4", "S3", "S2"), store.getRecentlyPlayedSongs("user1"));

        store.addSong("user1", "S2");
        assertEquals(List.of("S2", "S4", "S3"), store.getRecentlyPlayedSongs("user1"));

        store.addSong("user1", "S1");
        assertEquals(List.of("S1", "S2", "S4"), store.getRecentlyPlayedSongs("user1"));
    }

    @Test
    public void testEmptyRecentlyPlayedSongs() {
        assertEquals(List.of(), store.getRecentlyPlayedSongs("user1"));
    }

    @Test
    public void testAddingSameSongForDifferentUsers() {
        store.addSong("user1", "S1");
        store.addSong("user2", "S1");
        store.addSong("user3", "S1");

        assertEquals(List.of("S1"), store.getRecentlyPlayedSongs("user1"));
        assertEquals(List.of("S1"), store.getRecentlyPlayedSongs("user2"));
        assertEquals(List.of("S1"), store.getRecentlyPlayedSongs("user3"));
    }

    @Test
    public void testCapacityExceeded() {
        store.addSong("user1", "S1");
        store.addSong("user1", "S2");
        store.addSong("user1", "S3");
        store.addSong("user1", "S4");
        store.addSong("user1", "S5");

        assertEquals(List.of("S5", "S4", "S3"), store.getRecentlyPlayedSongs("user1"));
    }

    @Test
    public void testNonExistentUser() {
        assertEquals(List.of(), store.getRecentlyPlayedSongs("non_existent_user"));
    }
}
