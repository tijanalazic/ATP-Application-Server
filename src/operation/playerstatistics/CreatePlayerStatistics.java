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
public class CreatePlayerStatistics extends AbstractGenericOperation{
    
    private PlayerStatistics statistics;

    public CreatePlayerStatistics(PlayerStatistics statistics) {
        this.statistics = statistics;
    }

    @Override
    protected void preconditions(Object param) throws Exception {
        //
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        statistics = (PlayerStatistics) repository.create(statistics);
    }

    public PlayerStatistics getStatistics() {
        return statistics;
    }
    
}
