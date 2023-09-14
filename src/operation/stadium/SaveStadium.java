/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.stadium;

import components.ATPExpertsModel;
import domain.Stadium;
import operation.AbstractGenericOperation;

/**
 *
 * @author DELL
 */
public class SaveStadium extends AbstractGenericOperation{
    
    private Stadium stadium;
    private String exception = "";
    private String exceptionId;
    private String exceptionName;
    private String exceptionNumberOfSeats;
    private String exceptionCity;

    @Override
    protected void preconditions(Object param) throws Exception {
        if(((Stadium)param).getStadiumID() == 0 || ((Stadium)param).getStadiumID() == null) {
            exceptionName = "Name of stadium canot be null!\n";
            exception += exceptionName;
        }
        if(((Stadium)param).getName() == null) {
            exceptionName = "Name of stadium canot be null!\n";
            exception += exceptionName;
        }
        if(((Stadium)param).getNumberOfSeats() <= 0) {
            exceptionNumberOfSeats = "Number of seats cannot be less or equal to 0!\n";
            exception += exceptionNumberOfSeats;
        }
        if(((Stadium)param).getCity()== null) {
            exceptionCity = "City canot be null!\n";
            exception += exceptionCity;
        }
        if (!(exception.equals(""))) {
            throw new Exception(exception);
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        stadium = (Stadium) repository.update((Stadium)param);
    }

    public Stadium getStadium() {
        return stadium;
    }
    
}
