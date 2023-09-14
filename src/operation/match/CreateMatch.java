/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.match;

import domain.Match;
import operation.AbstractGenericOperation;

/**
 *
 * @author DELL
 */
public class CreateMatch extends AbstractGenericOperation{

    private Match match;
    String exception = "";
    String equalPlayers;

    public CreateMatch(Match match) {
        this.match = match;
    }
    
    @Override
    protected void preconditions(Object param) throws Exception {
        //
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        match = (Match) repository.create(match);
    }

    public Match getMatch() {
        return match;
    }
    
}
