package operation.match;

import domain.Match;
import domain.Player;
import domain.Stadium;
import domain.Tournament;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author DELL
 */
public class GetMatches extends AbstractGenericOperation{
    
    List<Match> matches;
    List<Tournament> tournaments;
    List<Player> players;
    List<Stadium> stadiums;

    @Override
    protected void preconditions(Object param) throws Exception {
        //
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        matches = repository.get((Match) param);
        tournaments = repository.get(new Tournament());
        players = repository.get(new Player());
        stadiums = repository.get(new Stadium());
        
        for (Match m : matches) {
            for (Tournament t : tournaments) {
                if(m.getTournament().getTournamentID().equals(t.getTournamentID())) {
                    m.setTournament(t);
                }
            }
            for (Stadium s : stadiums) {
                if(m.getStadium().getStadiumID().equals(s.getStadiumID())) {
                    m.setStadium(s);
                }
            }
            
            for (Player p : players) {
                if(m.getPlayer1().getPlayerId().equals(p.getPlayerId())) {
                    m.setPlayer1(p);
                }
                if(m.getPlayer2().getPlayerId().equals(p.getPlayerId())) {
                    m.setPlayer2(p);
                }
            }
        }
    }

    public List<Match> getMatches() {
        Match match = null;
        for (Match m : matches) {
            if(m.getMatchId() == 0) {
                match = m;
            }
        }
        if(match != null) {
            matches.remove(match);
        }
        return matches;
    }
    
}
