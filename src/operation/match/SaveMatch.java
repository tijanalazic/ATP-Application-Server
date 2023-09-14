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
public class SaveMatch extends AbstractGenericOperation{

    private Match match;
    String exception = "";
    
    @Override
    protected void preconditions(Object param) throws Exception {
        //
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        match = (Match) repository.update((Match) param);
    }

    public Match getMatch() {
        return match;
    }
    
}
