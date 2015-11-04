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
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "IDDIRECCION", unique = true, nullable = false)
    private Integer idDireccion;
    
    @Column(name = "COLONIA",nullable = false, length=20)
    private String Colonia;
    
    @Column(name = "CALLE", nullable = false, length=20)
    private String Calle;
    
    @Column(name = "CIUDAD", nullable = false, length=15)
    private String Ciudad;
    
    @Column(name = "CODIGOPOSTAL", nullable = false)
    private Integer CodigoPostal;

    @Column(name="NUM", nullable= false)
    private Integer Numero;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "PROVEDOR_IDPROVEDOR", nullable = false)
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
