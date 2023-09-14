/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.tournament;

import domain.Tournament;
import operation.AbstractGenericOperation;

/**
 *
 * @author DELL
 */
public class SaveTournament extends AbstractGenericOperation{
    
    private Tournament tournament;
    private String exception = "";
    private String exceptionId;
    private String exceptionName;
    private String exceptionCity;
    private String exceptionBeginningDate;
    private String exceptionEndingDate;
    private String exceptionNumberOfPlayers;
    private String exceptionType;

    @Override
    protected void preconditions(Object param) throws Exception {
        if(((Tournament) param).getTournamentID() == null) {
            exceptionId = "ID of the tournament cannot be null!\n";
            exception += exceptionId;
        }
        if(((Tournament) param).getName() == null) {
            exceptionName = "Name of the tournament cannot be null!\n";
            exception += exceptionName;
        }
        if(((Tournament) param).getCity() == null) {
            exceptionCity = "City cannot be null!\n";
            exception += exceptionCity;
        }
        if(((Tournament) param).getBeginningDate() == null) {
            exceptionBeginningDate = "Start date of the tournament cannot be null!\n";
            exception += exceptionBeginningDate;
        }
        if(((Tournament) param).getEndingDate() == null) {
            exceptionEndingDate = "Ending date of the tournament cannot be null!\n";
            exception += exceptionEndingDate;
        }
        if(((Tournament) param).getNumberOfPlayers() < 0) {
            exceptionNumberOfPlayers = "Number of players cannot be less than 0!\n";
            exception += exceptionNumberOfPlayers;
        }
        if(((Tournament) param).getAtpType() == null) {
            exceptionType = "Type of the tournament cannot be null!\n";
            exception += exceptionType;
        }
        if (!(exception.equals(""))) {
            throw new Exception(exception);
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        tournament = (Tournament) repository.update((Tournament)param);
    }

    public Tournament getTournament() {
        return tournament;
    }
    
}
