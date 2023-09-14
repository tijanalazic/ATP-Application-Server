package operation.atplist;

import domain.ATPList;
import operation.AbstractGenericOperation;

/**
 *
 * @author DELL
 */
public class DeleteATPList extends AbstractGenericOperation{
    
    boolean flag = false;

    @Override
    protected void preconditions(Object param) throws Exception {
        if (((ATPList) param).getAtpListId()== null) {
            throw new Exception("ID of ATPList cannot be null!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        flag = repository.delete((ATPList) param);
    }

    public boolean isFlag() {
        return flag;
    }
}
