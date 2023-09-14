package operation.atplist;

import domain.ATPList;
import operation.AbstractGenericOperation;

/**
 *
 * @author DELL
 */
public class SaveATPList extends AbstractGenericOperation{
    
    private ATPList atpList;
    private String exception = "";
    private String exceptionId;
    private String exceptionName;
    private String exceptionNumberOfPlayers;

    @Override
    protected void preconditions(Object param) throws Exception {
        if (((ATPList) param).getAtpListId() == null) {
            exceptionId = "ID of ATP list cannot be null!\n";
            exception += exceptionId;
        }
        if (((ATPList) param).getName()== null) {
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
        atpList = (ATPList) repository.update((ATPList) param);
    }

    public ATPList getAtpList() {
        return atpList;
    }
    
}
