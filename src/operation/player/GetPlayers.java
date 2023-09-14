/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.player;

import domain.ATPList;
import domain.Player;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author DELL
 */
public class GetPlayers extends AbstractGenericOperation{
    
    private List<Player> players;
    private List<ATPList> atplists;

    @Override
    protected void preconditions(Object param) throws Exception {
        // Nema ogranicenja
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        players = repository.get((Player) param);
        atplists = repository.get(new ATPList());
        for (Player p : players) {
            for (ATPList a : atplists) {
                if(p.getAtpList().getAtpListId().equals(a.getAtpListId())) {
                    p.setAtpList(a);
                }
            }
        }
    }

    public List<Player> getPlayers() {
        Player player = null;
        for (Player p : players) {
            if(p.getPlayerId() == 0) {
                player = p;
            }
        }
        if(player != null) {
            players.remove(player);
        }
        return players;
    }
    
    
    
}
