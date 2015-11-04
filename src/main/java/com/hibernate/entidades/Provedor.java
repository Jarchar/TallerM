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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author bruno
 */
@Entity
@Table(name="Provedor", catalog="TallerM")
public class Provedor implements java.io.Serializable {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="IDPROVEDOR",unique=true,nullable=false)
    private Integer idProvedor;
    
    @Column(name = "NOMBRE", unique = true, nullable = false, length = 45)
    private String Nombre;
    
    @Column(name = "CORREO", unique = true,nullable=false, length = 45)
    private String Correo;
    
    @OneToMany(fetch = FetchType.LAZY,  mappedBy = "provedor")
    private Set<Telefono> telefonos=new HashSet<Telefono>(0);
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy = "provedor")
    private Set<Pedido> pedidos=new HashSet<Pedido>(0);
    
    @OneToMany(mappedBy = "provedor", fetch= FetchType.LAZY)
    private Set<Direccion> direccions=new HashSet<Direccion>(0);

    
    public Provedor(){
        
    }
       public Provedor(Integer idProvedor, String Nombre, String Correo){
        this.idProvedor=idProvedor;
        this.Nombre=Nombre;
        this.Correo=Correo;
    } 
       public Provedor(Integer idProvedor, String Nombre, Set<Telefono>telefonos){
        this.idProvedor=idProvedor;
        this.Nombre=Nombre;
        this.telefonos=telefonos;               
    }    
    public Provedor(Integer idProvedor, String Nombre, String Correo, Set<Telefono>telefonos){
        this.idProvedor=idProvedor;
        this.Nombre=Nombre;
        this.Correo=Correo;
        this.telefonos=telefonos;
        
        
    }

    /**
     * @return the idProvedor
     */

    public Integer getIdProvedor() {
        return idProvedor;
    }

    /**
     * @param idProvedor the idProvedor to set
     */
    public void setIdProvedor(Integer idProvedor) {
        this.idProvedor = idProvedor;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Correo
     */
    public String getCorreo() {
        return Correo;
    }

    /**
     * @param Correo the Correo to set
     */
    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    /**
     * @return the telefonos
     */
    public Set<Telefono> getTelefonos() {
        return telefonos;
    }

    /**
     * @param telefonos the telefonos to set
     */
    public void setTelefonos(Set<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    /**
     * @return the pedidos
     */
    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    /**
     * @param pedidos the pedidos to set
     */
    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Set<Direccion> getDireccions() {
        return direccions;
    }

    public void setDireccions(Set<Direccion> direccions) {
        this.direccions = direccions;
    }
    
    
}
