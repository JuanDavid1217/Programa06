/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.DAO;

import java.util.List;

/**
 *
 * @author juand
 */
public interface IDAOGeneral <T, ID>{
    public T create(T p);
    public boolean delete(ID id);
    public T update(T p, ID id); //recibe el pojo a actualizar y lo devuelve ya actualizado
    
    public List<T> findAll();
    public T findbyID(ID id);
}
