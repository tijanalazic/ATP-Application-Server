/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.stadium;

import domain.Stadium;
import operation.AbstractGenericOperation;

/**
 *
 * @author DELL
 */
public class DeleteStadium extends AbstractGenericOperation{
    
    boolean flag = false;

    @Override
    protected void preconditions(Object param) throws Exception {
        if(((Stadium) param).getStadiumID() == null) {
            throw new Exception("ID of stadium cannot be null!\n");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        flag = repository.delete((Stadium) param);
    }

    public boolean isFlag() {
        return flag;
    }
    
}
