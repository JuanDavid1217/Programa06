/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.DAO;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import org.uv.Entyties.Detalle_Venta;
import org.uv.Entyties.Venta;

/**
 *
 * @author juand
 */
public class DAOVenta implements IDAOGeneral<Venta, Integer>{

    @Override
    public Venta create(Venta p) {
        Session session=HibernateUtil.getSession();
        Transaction t=session.beginTransaction();
        session.save(p);
        //Se nececita recorrer el detalle
        List<Detalle_Venta> ldv=p.getDetalle_venta();
        for(Detalle_Venta dv:ldv){
            session.save(dv);
        }
        /*for(Iterator<Detalle_Venta> iterator = p.getDetalle_venta().iterator(); iterator.hasNext();){
            session.save(iterator);
        }*/
        t.commit();
        session.close();
        
        return p;
    }

    @Override
    public boolean delete(Integer id) {
        Session session=HibernateUtil.getSession();
        Transaction t= session.beginTransaction();
        
        boolean bandera=false;
        Venta v= findbyID(id);
        if(v!=null){
            List<Detalle_Venta> ldv=v.getDetalle_venta();
            for(Detalle_Venta dv:ldv){
                session.delete(dv);
            }
            session.delete(v);
            t.commit();
            bandera=true;
            Logger.getLogger(DAOVenta.class.getName()).log(Level.INFO, "La venta se ha eliminado con exito.");
        }else{
            Logger.getLogger(DAOVenta.class.getName()).log(Level.INFO, "El id de venta ingresado no existe.");
        }
        session.close();
        return bandera;
    }

    @Override
    public Venta update(Venta p, Integer id) {
        Session session=HibernateUtil.getSession();
        Transaction t= session.beginTransaction();
        
        Venta v= findbyID(id);
        if(v!=null){
            session.update(p);
            List<Detalle_Venta> ldv=p.getDetalle_venta();
            for(Detalle_Venta dv:ldv){
                session.saveOrUpdate(dv);
            }
            t.commit();
            Logger.getLogger(DAOVenta.class.getName()).log(Level.INFO, "La venta se ha actualizado con exito.");
        }else{
            Logger.getLogger(DAOVenta.class.getName()).log(Level.INFO, "El id de venta ingresado no existe.");
        }
        session.close();
        return p;
    }

    @Override
    public List<Venta> findAll() {
        Session session=HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        
        List<Venta> Lven=null;
        Lven=session.createQuery("Select v from Venta v").list();
        
        t.commit();
        session.close();
        return Lven;
    }

    @Override
    public Venta findbyID(Integer id) {
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        
        Venta v=session.get(Venta.class, id);
        
        t.commit();
        session.close();
        
        return v;
    }
    
}
