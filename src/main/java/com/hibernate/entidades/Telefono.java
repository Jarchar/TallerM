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
@Table (name="TelProvedor", catalog="TallerM")
public class Telefono implements java.io.Serializable{
    
    
    private Provedor provedor;
    private Integer idTelefono;
    private Integer Telefono;
    
    public Telefono(){
        
    }
    public Telefono(Integer Telefono){
        this.Telefono=Telefono;
        
        
    }
    public Telefono(Provedor idProvedor, Integer Telefono){
        this.provedor=idProvedor;
        this.Telefono=Telefono;
        
    }

    /**
     * @return the idProvedor
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROVEDOR_IDPROVEDOR", nullable = false)
    public Provedor getProvedor() {
        return this.provedor;
    }

    /**
     * @param provedor
     */
    public void setProvedor(Provedor provedor) {
        this.provedor = provedor;
    }

    /**
     * @return the idTelefono
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "IDTELEFONO", unique = true, nullable = false)
    public Integer getIdTelefono() {
        return idTelefono;
    }

    /**
     * @param idTelefono the idTelefono to set
     */
    public void setIdTelefono(Integer idTelefono) {
        this.idTelefono = idTelefono;
    }

    /**
     * @return the Telefono
     */
    @Column(name = "TELEFONO", unique = true, nullable = false, length = 10)
    public Integer getTelefono() {
        return Telefono;
    }

    /**
     * @param Telefono the Telefono to set
     */
    public void setTelefono(Integer Telefono) {
        this.Telefono = Telefono;
    }
    
}
