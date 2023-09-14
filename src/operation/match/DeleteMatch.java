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
public class DeleteMatch extends AbstractGenericOperation{
    
    boolean flag = false;

    @Override
    protected void preconditions(Object param) throws Exception {
        if (((Match) param).getMatchId()== null) {
            throw new Exception("ID of match cannot be null!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        flag = repository.delete((Match) param);
    }

    public boolean isFlag() {
        return flag;
    }
}
