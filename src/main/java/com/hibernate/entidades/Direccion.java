/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author bruno
 */
@Entity
@Table(name="Direccion", catalog="TallerM")

public class Direccion implements java.io.Serializable {
    
    private Integer idDireccion;
    private String Colonia;
    private String Calle;
    private String Ciudad;
    private Integer CodigoPostal;
    private Integer Numero;
    private Provedor provedor;
    
    /**
     *
     */
    public Direccion(){}
    public Direccion(String Colonia, String Calle, Integer CodigoPostal, Integer Numero){
        this.Colonia=Colonia;
        this.Calle=Calle;
        this.CodigoPostal=CodigoPostal;
        this.Numero=Numero;
                
    }

    /**
     * @return the idDireccion
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "IDDIRECCION", unique = true, nullable = false)
    public Integer getIdDireccion() {
        return idDireccion;
    }

    /**
     * @param idDireccion the idDireccion to set
     */
    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    /**
     * @return the Colonia
     */
    @Column(name = "COLONIA",nullable = false, length=20)
    public String getColonia() {
        return Colonia;
    }

    /**
     * @param Colonia the Colonia to set
     */
    public void setColonia(String Colonia) {
        this.Colonia = Colonia;
    }

    /**
     * @return the Calle
     */
    @Column(name = "CALLE", nullable = false, length=20)
    public String getCalle() {
        return Calle;
    }

    /**
     * @param Calle the Calle to set
     */
    public void setCalle(String Calle) {
        this.Calle = Calle;
    }

    /**
     * @return the Ciudad
     */
    @Column(name = "CIUDAD", nullable = false, length=15)
    public String getCiudad() {
        return Ciudad;
    }

    /**
     * @param Ciudad the Ciudad to set
     */
    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    /**
     * @return the CodigoPostal
     */
    @Column(name = "CODIGOPOSTAL", nullable = false)
    public Integer getCodigoPostal() {
        return CodigoPostal;
    }

    /**
     * @param CodigoPostal the CodigoPostal to set
     */
    public void setCodigoPostal(Integer CodigoPostal) {
        this.CodigoPostal = CodigoPostal;
    }

    /**
     * @return the provedor
     */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "PROVEDOR_IDPROVEDOR", nullable = false)
    public Provedor getProvedor() {
        return provedor;
    }

    /**
     * @param provedor the provedor to set
     */
    public void setProvedor(Provedor provedor) {
        this.provedor = provedor;
    }

    /**
     * @return the Numero
     */
    @Column(name="NUM", nullable= false)
    public Integer getNumero() {
        return Numero;
    }

    /**
     * @param Numero the Numero to set
     */
    public void setNumero(Integer Numero) {
        this.Numero = Numero;
    }
    
}
