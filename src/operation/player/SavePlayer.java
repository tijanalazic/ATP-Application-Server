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
public class SavePlayer extends AbstractGenericOperation{
    
    private Player player;
    private String exception = "";
    private String exceptionId;
    private String exceptionFirstName;
    private String exceptionLastName;
    private String exceptionBirthday;
    private String exceptionState;
    private String exceptionPoints;
    private String exceptionHeight;
    private String exceptionWeight;
    private String exceptionATPList;

    @Override
    protected void preconditions(Object param) throws Exception {
        if (((Player) param).getPlayerId()== null) {
            exceptionId = "ID of player cannot be null!\n";
            exception += exceptionId;
        }
        if(((Player) param).getFirstName() == null) {
            exceptionFirstName = "Firstname cannot be null!\n";
            exception += exceptionFirstName;
        }
        if(((Player) param).getLastName() == null) {
            exceptionLastName = "Lastname cannot be null!\n";
            exception += exceptionLastName;
        }
        if(((Player) param).getBirthday() == null) {
            exceptionBirthday = "Birthday cannot be null!\n";
            exception += exceptionBirthday;
        }
        if(((Player) param).getState() == null) {
            exceptionState = "State cannot be null!\n";
            exception += exceptionState;
        }
        if(((Player) param).getPoints() == null) {
            exceptionPoints = "Points cannot be null!\n";
            exception += exceptionPoints;
        }
        if(((Player) param).getHeight() == null) {
            exceptionHeight = "Height cannot be null!\n";
            exception += exceptionHeight;
        }
        if(((Player) param).getWeight() == null) {
            exceptionWeight = "Weight cannot be null!\n";
            exception += exceptionWeight;
        }
        if(((Player) param).getAtpList() == null) {
            exceptionATPList = "ATP list cannot be null!\n";
            exception += exceptionATPList;
        }
        if (!(exception.equals(""))) {
            throw new Exception(exception);
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        player = (Player) repository.update((Player) param);
    }

    public Player getPlayer() {
        return player;
    }
    
}
