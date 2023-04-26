
package org.uv.Entyties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



/**
 *
 * @author juand
 */
@Entity

@Table(name="ventas_detalle")
public class Detalle_Venta {
    @Id
    //GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_DETALLE_VENTA")
    private int id_detalle_venta;
    @ManyToOne()
    @JoinColumn(name="ID_VENTA")
    private Venta venta;
    //Se recomienda poner clave del producto por separado para generar datos historicos.
    @ManyToOne()
    @JoinColumn(name="ID_PRODUCTO")
    private Producto producto;
    @Column(name="PRECIO_VENTA")
    private float precio_venta;
    @Column(name="CANTIDAD")
    private float cantidad;
    @Column(name="SUBTOTAL")
    private float subtotal;
    
    public Detalle_Venta(){};
    
    public Detalle_Venta(int id_detalle_venta, Venta venta, Producto producto, float cantidad){
        setId_detalle_venta(id_detalle_venta);
        setVenta(venta);
        setProducto(producto);
        setCantidad(cantidad);
        setPrecio_venta();
        setSubtotal();
    };
    
    public Detalle_Venta(int id_detalle_venta, Venta venta, Producto producto, float precio_venta, float cantidad, float subtotal){
        setId_detalle_venta(id_detalle_venta);
        setVenta(venta);
        setProducto(producto);
        setPrecio_venta(precio_venta);
        setCantidad(cantidad);
        setSubtotal(subtotal);
    };

    public int getId_detalle_venta() {
        return id_detalle_venta;
    }

    public void setId_detalle_venta(int id_detalle_venta) {
        this.id_detalle_venta = id_detalle_venta;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public float getPrecio_venta() {
        return precio_venta;
    }

    protected void setPrecio_venta(float precio_venta) {
        this.precio_venta = precio_venta;
    }
    
    public void setPrecio_venta(){
        precio_venta=producto.getPrecio_unitario();
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public float getSubtotal() {
        return subtotal;
    }

    protected void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }
    
    public void setSubtotal(){
        subtotal=precio_venta*cantidad;
    }
    
}
