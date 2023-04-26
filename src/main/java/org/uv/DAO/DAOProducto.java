/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.DAO;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.uv.Entyties.Producto;

/**
 *
 * @author juand
 */
public class DAOProducto implements IDAOGeneral<Producto, Integer> {

    @Override
    public Producto create(Producto p) {
        Session session=HibernateUtil.getSession();
        Transaction t=session.beginTransaction();
        
        session.save(p);
        
        t.commit();
        session.close();
        
        return p;
    }

    @Override
    public boolean delete(Integer id) {
        Session session=HibernateUtil.getSession();
        Transaction t=session.beginTransaction();
        boolean bandera=false;
        
        Producto p=findbyID(id);
        if(p!=null){
            session.delete(p);
            t.commit();
            Logger.getLogger(DAOProducto.class.getName()).log(Level.INFO, "Se ha eliminado el producto.");
            bandera=true;
        }else{
            Logger.getLogger(DAOProducto.class.getName()).log(Level.INFO, "El ID del producto ingresado no existe.");
        }
        session.close();
        return bandera;
    }

    @Override
    public Producto update(Producto p, Integer id) {
        Session session=HibernateUtil.getSession();
        Transaction t=session.beginTransaction();
        
        Producto pro=findbyID(id);
        if(pro!=null){
            session.update(p);
            t.commit();
            Logger.getLogger(DAOProducto.class.getName()).log(Level.INFO, "El producto se ha actualizado con exito.");
            
        }else{
            Logger.getLogger(DAOProducto.class.getName()).log(Level.INFO, "El ID del producto ingresado no existe.");
        }
        session.close();
        return p;
        
    }

    @Override
    public List<Producto> findAll() {
        Session session=HibernateUtil.getSession();
        Transaction t=session.beginTransaction();
        
        List <Producto> Lpro=null;
        
        Lpro=session.createQuery("From Producto").list();
        
        
        t.commit();
        session.close();
        
        return Lpro;
    }

    @Override
    public Producto findbyID(Integer id) {
        Session session = HibernateUtil.getSession();
        Transaction t=  session.beginTransaction();
        
        Producto p=session.get(Producto.class, id);
        
        return p;
        
    }
    
}
