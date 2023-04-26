/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.DAO;

import org.uv.Entyties.Detalle_Venta;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.uv.Entyties.Producto;
/**
 *
 * @author juand
 */
public class DAOVenta_Detalle implements IDAOGeneral<Detalle_Venta, Integer> {

    @Override
    public Detalle_Venta create(Detalle_Venta p) {
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
        
        Detalle_Venta DV=findbyID(id);
        if(DV!=null){
            session.delete(DV);
            t.commit();
            Logger.getLogger(DAOProducto.class.getName()).log(Level.INFO, "El Id del Detalle se ha eliminado.");
            bandera=true;
        }else{
            Logger.getLogger(DAOProducto.class.getName()).log(Level.INFO, "El ID del Detalle ingresado no existe.");
        }
        session.close();
        return bandera;
    }

    @Override
    public Detalle_Venta update(Detalle_Venta p, Integer id) {
        Session session=HibernateUtil.getSession();
        Transaction t=session.beginTransaction();
        
        Detalle_Venta DV=findbyID(id);
        if(DV!=null){
            session.update(p);
            t.commit();
            Logger.getLogger(DAOProducto.class.getName()).log(Level.INFO, "El Detalle de venta se ha actualizado con exito.");
            
        }else{
            Logger.getLogger(DAOProducto.class.getName()).log(Level.INFO, "El ID del detalle ingresado no existe.");
        }
        session.close();
        return p;
    }

    @Override
    public List<Detalle_Venta> findAll() {
        Session session=HibernateUtil.getSession();
        Transaction t=session.beginTransaction();
        
        List <Detalle_Venta> LDV=null;
        
        LDV=session.createQuery("From Detalle_Venta").list();
        
        
        t.commit();
        session.close();
        
        return LDV;
    }
    
    public List<Detalle_Venta> findAllbyVenta(int id) {
        Session session=HibernateUtil.getSession();
        Transaction t=session.beginTransaction();
        
        List <Detalle_Venta> LDV=null;
        
        
        LDV=session.createQuery("From Detalle_Venta where id_venta="+id).list();
        
        /*Query consulta=session.createQuery("From ventas_detalle Where ID_VENTA=:ID_VENTA");
        consulta.setParameter("ID_VENTA", id);
        LDV=consulta.getResultList();*/
        
        
        t.commit();
        session.close();
        
        return LDV;
    }

    @Override
    public Detalle_Venta findbyID(Integer id) {
        Session session = HibernateUtil.getSession();
        Transaction t=  session.beginTransaction();
        
        Detalle_Venta DV=session.get(Detalle_Venta.class, id);
        
        return DV;
    }
    
}
