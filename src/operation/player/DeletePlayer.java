/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.player;

import domain.Player;
import operation.AbstractGenericOperation;

/**
 *
 * @author DELL
 */
public class DeletePlayer extends AbstractGenericOperation{
    
    boolean flag = false;

    @Override
    protected void preconditions(Object param) throws Exception {
        if (((Player) param).getPlayerId()== null) {
            throw new Exception("ID of player cannot be null!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        flag = repository.delete((Player) param);
    }

    public boolean isFlag() {
        return flag;
    }
}
