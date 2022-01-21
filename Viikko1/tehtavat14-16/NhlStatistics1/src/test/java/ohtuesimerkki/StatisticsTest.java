package ohtuesimerkki;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class StatisticsTest {

    Reader readerStub = new Reader() {
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics statistics;

    @Before
    public void setUp() {
        statistics = new Statistics(readerStub);
    }

    @Test
    public void searchPlayerByNameReturnsPlayer() {
        assertEquals(readerStub.getPlayers().get(0).toString(), 
            statistics.search("Semenko").toString());

        assertNotEquals(readerStub.getPlayers().get(0).toString(), 
            statistics.search("Kurri").toString());
        assertEquals(null, statistics.search("Jarno"));

    }
    @Test
    public void testPlayersFoundInRightTeam() {
        List<Player> edm = statistics.team("EDM");
        List<Player> pit = statistics.team("PIT");
        List<Player> det = statistics.team("DET");

        assertEquals(3, edm.size());
        assertEquals(1, pit.size());
        assertEquals(1, det.size());

        assertEquals("Semenko", edm.get(0).getName());
    }
    @Test
    public void rightAmountOfPlayersFount() {
        List<Player> scores = statistics.topScorers(1);
        assertEquals(1, scores.size());
        

        List<Player> scoresFive = statistics.topScorers(5);
        assertEquals(5, scoresFive.size());
    }
}
