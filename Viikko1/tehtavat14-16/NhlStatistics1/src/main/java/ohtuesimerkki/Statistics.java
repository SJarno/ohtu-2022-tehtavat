package ohtuesimerkki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Statistics {

    private List<Player> players;
    private Reader reader;

    public Statistics(Reader reader) {
        this.reader = reader;
        this.players = this.reader.getPlayers();       
    }

    public Player search(String name) {
        for (Player player : players) {
            if (player.getName().contains(name)) {
                return player;
            }
        }

        return null;
    }

    public List<Player> team(String teamName) {
        ArrayList<Player> playersOfTeam = new ArrayList<Player>();
        
        for (Player player : players) {
            if ( player.getTeam().equals(teamName)) {
                playersOfTeam.add(player);
            }
        }
        
        return playersOfTeam;
    }
    /* Haetaan n-määrä pelaajia */
    public List<Player> topScorers(int howMany) {
        Collections.sort(players);
        ArrayList<Player> topScorers = new ArrayList<Player>();
        Iterator<Player> playerIterator = players.iterator();
        
        /* Tämä korjattiin, jos haetaan yksi(1) pelaaja, pitäisi listassa myös mielestäni olla yksi */
        while (howMany>0) {
            topScorers.add( playerIterator.next() );            
            howMany--;
        }
        
        return topScorers;
    }

}
