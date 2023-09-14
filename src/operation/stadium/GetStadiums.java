/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.stadium;

import domain.Stadium;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author DELL
 */
public class GetStadiums extends AbstractGenericOperation{
    
    private List<Stadium> stadiums;

    @Override
    protected void preconditions(Object param) throws Exception {
        // Nema ogranicenja
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        stadiums = repository.get((Stadium) param);
    }

    public List<Stadium> getStadiums() {
        Stadium stadium = null;
        for (Stadium s : stadiums) {
            if(s.getStadiumID() == 0) {
                stadium = s;
            }
        }
        if(stadium != null) {
            stadiums.remove(stadium);
        }
        return stadiums;
    }
    
    
}
