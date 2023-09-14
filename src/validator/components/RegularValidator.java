/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validator.components;

import validator.IValidator;
import validator.ValidatorException;

/**
 *
 * @author DELL
 */
public class RegularValidator implements IValidator{

    @Override
    public void validate(String value) throws ValidatorException {
        if(value == null || value.isEmpty()) {
            throw new ValidatorException("All fields are mandatory!");
        }
    }
    
}
