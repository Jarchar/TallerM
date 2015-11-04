/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.entidades;

import java.io.Serializable;
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
@Table(name="TelCliente", catalog="TallerM")
public class TelCliente implements Serializable{
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "IDTELEFONO", unique = true, nullable = false) 
    private Integer idTelefono;
     
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDCLIENTE", nullable = false)
    private Cliente cliente;
     
    @Column(name = "TELEFONO", unique = true, nullable = false, length = 10)
    private Integer Telefono;
    
    public TelCliente(){
        
    }
    public TelCliente(Integer Telefono){
        this.Telefono=Telefono;
        
        
    }
    public TelCliente(Cliente cliente, Integer Telefono){
        this.cliente=cliente;
        this.Telefono=Telefono;
        
    }

    /**
     * @return the idProvedor
     */

    public Cliente getCliente() {
        return this.cliente;
    }

    /**
     * @param cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the idTelefono
     */

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
