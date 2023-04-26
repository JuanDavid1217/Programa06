package org.uv.Entyties;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import org.uv.Entyties.Detalle_Venta;
import java.util.List;
import java.util.ArrayList;
import static GestionadorHora.Horario.*;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 *
 * @author juand
 */
@Entity
@Table(name="ventas")
public class Venta {
    @Id
    //GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_VENTA")
    private int id_venta;
    @Column(name="FECHA")
    private Date fecha;//UTC: tiempo universal coordinado
    @OneToMany(fetch=FetchType.EAGER, mappedBy = "venta")
    private List<Detalle_Venta> detalle_venta;
    @Column(name="TOTAL")
    private float total=0; //Float es demasiado exacto (problemas de redondeo)
    
    public Venta(){};
    
    public Venta(int id_venta){
        setId_venta(id_venta);
        fecha=StringtoDate(setFechaHora());
        detalle_venta=new ArrayList<Detalle_Venta>();
    }
    
    public Venta(int id_venta,List<Detalle_Venta> detalle_venta){
        setId_venta(id_venta);
        fecha=StringtoDate(setFechaHora());
        setDetalle_venta(detalle_venta);
    }
    
    public Venta(int id_venta, Date fecha, List<Detalle_Venta> detalle_venta){
        setId_venta(id_venta);
        setFecha(fecha);
        setDetalle_venta(detalle_venta);
    }
    
    protected Venta(int id_venta, Date fecha, List<Detalle_Venta> detalle_venta, float total){
        setId_venta(id_venta);
        setFecha(fecha);
        setDetalle_venta(detalle_venta);
        setTotal(total);
        
    }
    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha() {
        this.fecha = StringtoDate(setFechaHora());
    }
    
    protected void setFecha(Date fecha){
        this.fecha=fecha;
    }

    public List<Detalle_Venta> getDetalle_venta() {
        return detalle_venta;
    }
    
    public Detalle_Venta getDetalle_venta(int posicion){
        if(posicion>0&&posicion<detalle_venta.size()){
            return detalle_venta.get(posicion);
        }else{
           return null;
        }
    }

    public void setDetalle_venta(List<Detalle_Venta> detalle_venta) {
        this.detalle_venta = detalle_venta;
    }
    
    public void setDetalle_venta(Detalle_Venta detalle_venta){
        this.detalle_venta.add(detalle_venta);
    }
    
    public void calculartotal(){
        total=0;
        for(Detalle_Venta detalle: detalle_venta){
            total+=detalle.getSubtotal();
        }
    }
    
    public void setTotal(float total){
        this.total=total;
    }
    
    public float getTotal(){
        if (total==0){
            calculartotal();
        }
        return total;
    }
    
}
