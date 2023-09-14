/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.playerstatistics;

import domain.Match;
import domain.PlayerStatistics;
import operation.AbstractGenericOperation;

/**
 *
 * @author DELL
 */
public class DeletePlayerStatistics extends AbstractGenericOperation{

    boolean flag = false;

    @Override
    protected void preconditions(Object param) throws Exception {
        if (((PlayerStatistics) param).getMatch().getMatchId() == null) {
            throw new Exception("ID of match cannot be null!");
        }
        if (((PlayerStatistics) param).getPlayer().getPlayerId() == null) {
            throw new Exception("ID of player cannot be null!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        flag = repository.delete((PlayerStatistics) param);
    }

    public boolean isFlag() {
        return flag;
    }
    
}
