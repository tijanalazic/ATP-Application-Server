/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.tournament;

import domain.Tournament;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author DELL
 */
public class GetTournaments extends AbstractGenericOperation{
    
    private List<Tournament> tournaments;

    @Override
    protected void preconditions(Object param) throws Exception {
        //
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        tournaments = repository.get((Tournament)param);
    }

    public List<Tournament> getTournaments() {
        Tournament tournament = null;
        for (Tournament t : tournaments) {
            if(t.getTournamentID() == 0) {
                tournament = t;
            }
        }
        if(tournament != null) {
            tournaments.remove(tournament);
        }
        return tournaments;
    }
    
    
}
