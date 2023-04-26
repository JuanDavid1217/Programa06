/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Entyties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author juand
 */

@Entity
@Table(name="productos")
public class Producto {
    @Id
    //GeneratedValue(strategy = GenerationType.IDENTITY) para realizar un autoincrementable
    @Column(name = "ID_PRODUCTO")
    private int id_producto;
    @Column(name = "DESCRIPCION_PRO")
    private String descripcion;
    @Column(name = "PRECIO_UNITARIO")
    private float precio_unitario;
    @Column(name = "STOCK")
    private float stock;
    
    public Producto(){};
    
    public Producto(int id_producto, String descripcion, float precio_unitario, float stock){
        setId_producto(id_producto);
        setDescripcion(descripcion);
        setPrecio_unitario(precio_unitario);
        setStock(stock);
    }
    
    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(float precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public float getStock() {
        return stock;
    }

    public void setStock(float stock) {
        this.stock = stock;
    }
    
    
}
