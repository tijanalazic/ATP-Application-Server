/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.login;

import domain.User;
import java.util.List;
import operation.AbstractGenericOperation;
import validator.ValidatorException;

/**
 *
 * @author DELL
 */
public class Login extends AbstractGenericOperation{
    
    private String exception = "";
    private String exceptionFirstname;
    private String exceptionLastname;
    private String exceptionPassword;
    private User login;

    @Override
    protected void preconditions(Object param) throws Exception {
        User user = (User) param;
        if (!(exception.equals(""))) {
            throw new ValidatorException(exception);
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        User user = (User) param;
        List<User> users = repository.get((User) param);
        for (User u : users) {
            System.out.println(u);
            if(u.getFirstName().equals(user.getFirstName()) && u.getLastName().equals(user.getLastName())
                    && u.getPassword().equals(user.getPassword())) {
                login = u;
                return;
            }
        }
    }
    
    public Object getLogin() {
        return (User)login;
    }
    
}
