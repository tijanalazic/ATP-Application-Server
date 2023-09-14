/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to update this template
 */
package controller;

import domain.ATPList;
import domain.Match;
import domain.Player;
import domain.PlayerStatistics;
import domain.Stadium;
import domain.Tournament;
import domain.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import operation.AbstractGenericOperation;
import operation.atplist.CreateATPList;
import operation.atplist.DeleteATPList;
import operation.atplist.GetATPLists;
import operation.atplist.SaveATPList;
import operation.login.Login;
import operation.match.CreateMatch;
import operation.match.DeleteMatch;
import operation.match.GetMatches;
import operation.match.SaveMatch;
import operation.player.CreatePlayer;
import operation.player.DeletePlayer;
import operation.player.GetPlayers;
import operation.player.SavePlayer;
import operation.playerstatistics.CreatePlayerStatistics;
import operation.playerstatistics.DeletePlayerStatistics;
import operation.playerstatistics.GetPlayerStatistics;
import operation.playerstatistics.SavePlayerStatistics;
import operation.stadium.CreateStadium;
import operation.stadium.DeleteStadium;
import operation.stadium.GetStadiums;
import operation.stadium.SaveStadium;
import operation.tournament.CreateTournament;
import operation.tournament.DeleteTournament;
import operation.tournament.GetTournaments;
import operation.tournament.SaveTournament;
import repository.DbConnectionFactory;
import repository.DBRepository;

/**
 *
 * @author DELL
 */
public class Controller {
    
    private static Controller instance;
    private AbstractGenericOperation operation;

    public Controller() {
        
    }

    public static Controller getInstance() {
        if(instance == null){
            instance = new Controller();
        }
        return instance;
    }
    
    public Object login(User user) throws Exception {
        operation = new Login();
        operation.execute(user);
        return ((Login) operation).getLogin();
    }
    
    public Object create(Object object) throws Exception {
        if(object instanceof ATPList) {
            return createATPList(object);
        }
        if(object instanceof Tournament) {
            return createTournament(object);
        }
        if(object instanceof Stadium) {
            return createStadium(object);
        }
        if(object instanceof Player) {
            return createPlayer(object);
        }
        if(object instanceof Match) {
            return createMatch(object);
        }
        if(object instanceof PlayerStatistics) {
            return createPlayerStatistics(object);
        }
        return null;
    }

    public Object get(Object object) throws Exception {
        if(object instanceof ATPList) {
            return getATPLists(object);
        }
        if(object instanceof Tournament) {
            return getTournaments(object);
        }
        if(object instanceof Player) {
            return getPlayers(object);
        }
        if(object instanceof Stadium) {
            return getStadiums(object);
        }
        if(object instanceof Match) {
            return getMatches(object);
        }
        if(object instanceof PlayerStatistics) {
            return getPlayerStatistics(object);
        }
        return null;
    }

    public Object save(Object object) throws Exception {
        if(object instanceof ATPList) {
            return saveATPList(object);
        }
        if(object instanceof Stadium) {
            return saveStadium(object);
        }
        if(object instanceof Tournament) {
            return saveTournament(object);
        }
        if(object instanceof Player) {
            return savePlayer(object);
        }
        if(object instanceof Match) {
            return saveMatch(object);
        }
        if(object instanceof PlayerStatistics) {
            return savePlayerStatistics(object);
        }
        return null;
    }

    public Object delete(Object object) throws Exception {
        if(object instanceof ATPList) {
            return deleteATPList(object);
        }
        if(object instanceof Stadium) {
            return deleteStadium(object);
        }
        if(object instanceof Tournament) {
            return deleteTournament(object);
        }
        if(object instanceof Player) {
            return deletePlayer(object);
        }
        if(object instanceof Match) {
            return deleteMatch(object);
        }
        if(object instanceof PlayerStatistics) {
            return deletePlayerStatistics(object);
        }
        return null;
    }
    
    private Object createATPList(Object object) throws Exception {
        operation = new CreateATPList((ATPList) object);
        operation.execute(object);
        return ((CreateATPList) operation).getAtpList();
    }
    
    private Object createTournament(Object object) throws Exception {
        operation = new CreateTournament((Tournament) object);
        operation.execute(object);
        return ((CreateTournament) operation).getTournament();
    }
    
    private Object createStadium(Object object) throws Exception {
        operation = new CreateStadium((Stadium) object);
        operation.execute(object);
        return ((CreateStadium) operation).getStadium();
    }
    
    private Object createPlayer(Object object) throws Exception {
        operation = new CreatePlayer((Player) object);
        operation.execute(object);
        return ((CreatePlayer) operation).getPlayer();
    }
    
    private Object createMatch(Object object) throws Exception {
        operation = new CreateMatch((Match) object);
        operation.execute(object);
        return ((CreateMatch) operation).getMatch();
    }

    private Object createPlayerStatistics(Object object) throws Exception {
        operation = new CreatePlayerStatistics((PlayerStatistics) object);
        operation.execute(object);
        return ((CreatePlayerStatistics) operation).getStatistics();
    }
    
    private Object getATPLists(Object object) throws Exception {
        operation = new GetATPLists();
        operation.execute(object);
        return ((GetATPLists) operation).getAtpLists();
    }

    private Object getTournaments(Object object) throws Exception {
        operation = new GetTournaments();
        operation.execute(object);
        return ((GetTournaments) operation).getTournaments();
    }

    private Object getPlayers(Object object) throws Exception {
        operation = new GetPlayers();
        operation.execute(object);
        return ((GetPlayers) operation).getPlayers();
    }

    private Object getStadiums(Object object) throws Exception {
        operation = new GetStadiums();
        operation.execute(object);
        return ((GetStadiums) operation).getStadiums();
    }
    
    private Object getMatches(Object object) throws Exception {
        operation = new GetMatches();
        operation.execute(object);
        return ((GetMatches) operation).getMatches();
    }

    private Object getPlayerStatistics(Object object) throws Exception {
        operation = new GetPlayerStatistics((PlayerStatistics)object);
        operation.execute((PlayerStatistics)object);
        return ((GetPlayerStatistics) operation).getStatistics();
    }
    
    private Object saveATPList(Object object) throws Exception {
        operation = new SaveATPList();
        operation.execute(object);
        return ((SaveATPList) operation).getAtpList();
    }

    private Object saveStadium(Object object) throws Exception {
        operation = new SaveStadium();
        operation.execute(object);
        return ((SaveStadium) operation).getStadium();
    }

    private Object saveTournament(Object object) throws Exception {
        operation = new SaveTournament();
        operation.execute(object);
        return ((SaveTournament) operation).getTournament();
    }
    
    private Object saveMatch(Object object) throws Exception {
        operation = new SaveMatch();
        operation.execute(object);
        return ((SaveMatch) operation).getMatch();
    }

    private Object savePlayer(Object object) throws Exception {
        operation = new SavePlayer();
        operation.execute(object);
        return ((SavePlayer) operation).getPlayer();
    }
    
    private Object savePlayerStatistics(Object object) throws Exception {
        operation = new SavePlayerStatistics();
        operation.execute(object);
        return ((SavePlayerStatistics) operation).getStatistic();
    }
    
    private Object deleteStadium(Object object) throws Exception {
        operation = new DeleteStadium();
        operation.execute(object);
        return ((DeleteStadium) operation).isFlag();
    }

    private Object deleteTournament(Object object) throws Exception {
        operation = new DeleteTournament();
        operation.execute(object);
        return ((DeleteTournament) operation).isFlag();
    }

    private Object deletePlayer(Object object) throws Exception {
        operation = new DeletePlayer();
        operation.execute(object);
        return ((DeletePlayer) operation).isFlag();
    }

    private Object deleteATPList(Object object) throws Exception {
        operation = new DeleteATPList();
        operation.execute(object);
        return ((DeleteATPList) operation).isFlag();
    }

    private Object deleteMatch(Object object) throws Exception {
        operation = new DeleteMatch();
        operation.execute(object);
        return ((DeleteMatch) operation).isFlag();
    }

    private Object deletePlayerStatistics(Object object) throws Exception {
        operation = new DeletePlayerStatistics();
        operation.execute(object);
        return ((DeletePlayerStatistics) operation).isFlag();
    }
}
