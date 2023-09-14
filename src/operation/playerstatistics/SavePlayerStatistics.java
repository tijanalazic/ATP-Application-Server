/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.playerstatistics;

import domain.PlayerStatistics;
import operation.AbstractGenericOperation;

/**
 *
 * @author DELL
 */
public class SavePlayerStatistics extends AbstractGenericOperation{
    
    private PlayerStatistics statistic;

    @Override
    protected void preconditions(Object param) throws Exception {
        //
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        statistic = (PlayerStatistics) repository.update((PlayerStatistics) param);
    }

    public PlayerStatistics getStatistic() {
        return statistic;
    }
    
}
