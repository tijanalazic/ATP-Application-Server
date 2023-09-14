/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import domain.User;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DELL
 */
public class ATPExpertsModel extends AbstractTableModel{
    
    List<User> loggedATPExperts = new ArrayList<>();
    String columnNames[] = new String[]{"Id", "Firstname", "Lastname"};
    Class columnClass[] = new Class[]{Long.class, String.class, String.class};

    public ATPExpertsModel(List<User> loggedATPExperts) {
        this.loggedATPExperts = loggedATPExperts;
    }
    
    @Override
    public int getRowCount() {
        return loggedATPExperts.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        if(column > columnNames.length) {
            return "n/a";
        }
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        User expert = loggedATPExperts.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return expert.getExpertId();
            case 1:
                return expert.getFirstName();
            case 2:
                return expert.getLastName();
                default:
                    return "n/a";
        }
    }
    
}
