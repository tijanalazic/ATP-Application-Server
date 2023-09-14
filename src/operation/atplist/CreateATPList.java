/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.atplist;

import domain.ATPList;
import operation.AbstractGenericOperation;

/**
 *
 * @author DELL
 */
public class CreateATPList extends AbstractGenericOperation{
    
    private ATPList atpList;
    private String exception = "";
    private String exceptionName;
    private String exceptionNumberOfPlayers;

    public CreateATPList(ATPList atpList) {
        this.atpList = atpList;
    }

    @Override
    protected void preconditions(Object param) throws Exception {
        if (((ATPList) param).getName() == null) {
            exceptionName = "Name cannot be null!\n";
            exception += exceptionName;
        }
        if (((ATPList) param).getNumberOfPlayers() == null) {
            exceptionNumberOfPlayers = "Number of players cannot be null!\n";
            exception += exceptionNumberOfPlayers;
        }
        if (!(exception.equals(""))) {
            throw new Exception(exception);
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        atpList = (ATPList) repository.create(atpList);
    }

    public ATPList getAtpList() {
        return atpList;
    }
    
    
    
}
