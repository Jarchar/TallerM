/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.entidades;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author bruno
 */
@Entity
@Table(name="Refaccion", catalog="TallerM")
public class Refaccion implements java.io.Serializable{
    private Integer idRefaccion;
    private Float precio;
    private String tipo;
    private String Descripcion;
    private String Nombre;
    private Set<Pedido>pedidos=new HashSet<Pedido>(0);
    private Set<Reparacion> reparacions=new HashSet<Reparacion>(0);
    
    public Refaccion(){
    }
    public Refaccion(Float precio, String tipo, String Descripcion, String Nombre){
        this.precio=precio;
        this.tipo=tipo;
        this.Descripcion=Descripcion;
        this.Nombre=Nombre;
    }
      public Refaccion(Float precio, String tipo, String Nombre){
        this.precio=precio;
        this.tipo=tipo;
        this.Nombre=Nombre;
    }
    

    /**
     * @return the idRefaccion
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="IDREFACCION",unique=true,nullable=false)  
    public Integer getIdRefaccion() {
        return idRefaccion;
    }

    /**
     * @param idRefaccion the idRefaccion to set
     */
    public void setIdRefaccion(Integer idRefaccion) {
        this.idRefaccion = idRefaccion;
    }

    /**
     * @return the precio
     */
    @Column(name="PRECIO", nullable=false)
    public Float getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    /**
     * @return the tipo
     */
    @Column(name="TIPO", nullable=false,length=20)
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the Descripcion
     */
    @Column(name="Descripcion", length=100)
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * @param Descripcion the Descripcion to set
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    /**
     * @return the pedidos
     */
    @ManyToMany(mappedBy = "refaccions", fetch=FetchType.LAZY)
    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    /**
     * @param pedidos the pedidos to set
     */
    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    /**
     * @return the Nombre
     */
    @Column(name ="NOMBRE", nullable=false, length=15)
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    @ManyToMany(mappedBy = "refacciones", fetch=FetchType.LAZY)
    public Set<Reparacion> getReparacions() {
        return reparacions;
    }

    public void setReparacions(Set<Reparacion> reparacions) {
        this.reparacions = reparacions;
    }
}
