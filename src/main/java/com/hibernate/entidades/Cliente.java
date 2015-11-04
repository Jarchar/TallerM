/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author bruno
 */
@Entity
@Table(name="Cliente", catalog="TallerM")
public class Cliente implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente", nullable=false)
    private Integer idCliente;
    @Basic(optional = false)
    @Column(name = "Nombre", length=10)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ApellidoP", length=10)
    private String apellidoP;
    @Basic(optional = false)
    @Column(name = "ApellidoM", length=10, nullable=false)
    private String apellidoM;
    @Column(name = "CodPostal", nullable=false)
    private Integer codPostal;
    @Column(name = "Calle", length=20)
    private String calle;
    @Column(name = "Colonia", length=20)
    private String colonia;
    @Column(name = "Num", nullable=false)
    private Integer num;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
    private Set<Automovil>automoviles=new HashSet<Automovil>(0);
    
    @OneToMany(mappedBy= "cliente", fetch=FetchType.LAZY)
    private Set<TelCliente>telefonos=new HashSet<TelCliente>(0);

    public Cliente() {
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(Integer idCliente, String nombre, String apellidoP, String apellidoM) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public Integer getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(Integer codPostal) {
        this.codPostal = codPostal;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * @return the automoviles
     */
    public Set<Automovil> getAutomoviles() {
        return automoviles;
    }

    /**
     * @param automoviles the automoviles to set
     */
    public void setAutomoviles(Set<Automovil> automoviles) {
        this.automoviles = automoviles;
    }

    /**
     * @return the telefonos
     */
    public Set<TelCliente> getTelefonos() {
        return telefonos;
    }

    /**
     * @param telefonos the telefonos to set
     */
    public void setTelefonos(Set<TelCliente> telefonos) {
        this.telefonos = telefonos;
    }

    
}
