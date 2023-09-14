/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to update this template
 */
package repository;

import java.util.List;

/**
 *
 * @author DELL
 */
public interface Repository<T> {
    
    T create(T t) throws Exception;
    List<T> get(T t) throws Exception;
    T update(T t) throws Exception;
    boolean delete(T t) throws Exception;
}
