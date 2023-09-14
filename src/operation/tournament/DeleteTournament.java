/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.tournament;

import domain.Tournament;
import operation.AbstractGenericOperation;

/**
 *
 * @author DELL
 */
public class DeleteTournament extends AbstractGenericOperation{

    boolean flag = false;

    @Override
    protected void preconditions(Object param) throws Exception {
        if (((Tournament) param).getTournamentID()== null) {
            throw new Exception("ID of tournament cannot be null!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        flag = repository.delete((Tournament) param);
    }

    public boolean isFlag() {
        return flag;
    }
    
}
