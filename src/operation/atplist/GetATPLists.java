/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.atplist;

import domain.ATPList;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author DELL
 */
public class GetATPLists extends AbstractGenericOperation{
    
    private List<ATPList> atpLists;

    @Override
    protected void preconditions(Object param) throws Exception {
        // nema ogranicenja
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        atpLists = repository.get((ATPList)param);
    }

    public List<ATPList> getAtpLists() {
        ATPList atpList = null;
        for (ATPList a : atpLists) {
            if(a.getAtpListId() == 0) {
                atpList = a;
            }
        }
        if(atpList != null) {
            atpLists.remove(atpList);
        }
        return atpLists;
    }
    
    
}
