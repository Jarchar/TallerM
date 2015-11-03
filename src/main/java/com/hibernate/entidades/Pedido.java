/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.entidades;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author bruno
 */
@Entity
@Table(name="Pedido", catalog="TallerM")
public class Pedido implements java.io.Serializable {
    private Integer idPedido;
    private Provedor provedor;
    private Date fecha;
    private Set<Refaccion> refaccions=new HashSet<Refaccion>();
    
    public Pedido(){
        
    }
    public Pedido( Date fecha){
        this.fecha=fecha;
               
    }

    /**
     * @return the idPedido
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "IDPEDIDO", unique = true, nullable = false)
    public Integer getIdPedido() {
        return idPedido;
    }

    /**
     * @param idPedido the idPedido to set
     */
    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }


    /**
     * @return the provedor
     */
    @ManyToOne(fetch =FetchType.LAZY)
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
     * @return the fecha
     */
    @Temporal(TemporalType.DATE)
    @Column(name="FECHA",nullable=false, length=10)
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Pedido_has_Refaccion", catalog = "TallerM", joinColumns = { 
                    @JoinColumn(name = "PEDIDO_IDPEDIDO", nullable = false, updatable = false) }, 
                    inverseJoinColumns = { @JoinColumn(name = "REFACCION_IDREFACCION", 
                                    nullable = false, updatable = false) })

    public Set<Refaccion> getRefaccions() {
        return refaccions;
    }

    public void setRefaccions(Set<Refaccion> refaccions) {
        this.refaccions = refaccions;
    }
    
}
