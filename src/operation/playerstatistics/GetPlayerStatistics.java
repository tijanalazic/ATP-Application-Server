/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.playerstatistics;

import domain.Match;
import domain.Player;
import domain.PlayerStatistics;
import java.util.ArrayList;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author DELL
 */
public class GetPlayerStatistics extends AbstractGenericOperation{
    
    List<PlayerStatistics> statistics = new ArrayList<>();
    List<PlayerStatistics> allStatistics;
    Match match;
    private String exception = "";
    private String exceptionPlayer;

    public GetPlayerStatistics(PlayerStatistics stat) {
        match = stat.getMatch();
    }

    @Override
    protected void preconditions(Object param) throws Exception {
        if (match == null) {
            exceptionPlayer = "Player cannot be null!\n";
            exception += exceptionPlayer;
        }
        if (!(exception.equals(""))) {
            throw new Exception(exception);
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        allStatistics = repository.get((PlayerStatistics) param);
        
    }

    public List<PlayerStatistics> getStatistics() {
        if(allStatistics != null) {
            for (PlayerStatistics s : allStatistics) {
                if(s.getMatch().getMatchId().equals(match.getMatchId())) {
                    s.setMatch(match);
                    statistics.add(s);
                }
            }
        }
        return statistics;
    }
    
    
    
}
