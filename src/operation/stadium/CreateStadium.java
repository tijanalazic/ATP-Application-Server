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
public class CreateStadium extends AbstractGenericOperation{
    
    private Stadium stadium;
    private String exception = "";
    private String exceptionName;
    private String exceptionNumberOfSeats;
    private String exceptionCity;

    public CreateStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    @Override
    protected void preconditions(Object param) throws Exception {
        if(((Stadium)param).getName() == null) {
            exceptionName = "Name of stadium canot be null!\n";
            exception += exceptionName;
        }
        if(((Stadium)param).getNumberOfSeats() < 0) {
            exceptionNumberOfSeats = "Number of seats cannot be less than 0!\n";
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
        stadium = (Stadium) repository.create(stadium);
    }

    public Stadium getStadium() {
        return stadium;
    }
    
    
}
