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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author bruno
 */
@Entity
@Table(name = "Mecanico", catalog="TallerM")
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMecanico")
    private Integer idMecanico;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ApellidoP")
    private String apellidoP;
    @Column(name = "ApellidoM")
    private String apellidoM;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Mecanico_Reparacion", catalog = "TallerM", joinColumns = {
        @JoinColumn(name = "MECANICO_IDMECANICO", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "REPARACION_IDVENTA",
                    nullable = false, updatable = false) })
    private Set<Reparacion> reparaciones;

    public Empleado() {
        this.reparaciones = new HashSet<Reparacion>();
    }

    public Empleado(Integer idMecanico) {
        this.reparaciones = new HashSet<Reparacion>();
        this.idMecanico = idMecanico;
    }

    public Empleado(Integer idMecanico, String nombre, String mecanicocol) {
        this.reparaciones = new HashSet<Reparacion>();
        this.idMecanico = idMecanico;
        this.nombre = nombre;
        this.apellidoP = mecanicocol;
    }
    public Integer getIdMecanico() {
        return idMecanico;
    }

    public void setIdMecanico(Integer idMecanico) {
        this.idMecanico = idMecanico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMecanicocol() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }
     /**
     * @return the apellidoM
     */
    public String getApellidoM() {
        return apellidoM;
    }

    /**
     * @param apellidoM the apellidoM to set
     */
    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

   
     /**
     * @return the reparaciones
     */
    public Set<Reparacion> getReparaciones() {
        return reparaciones;
    }

    /**
     * @param reparaciones the reparaciones to set
     */
    public void setReparaciones(Set<Reparacion> reparaciones) {
        this.reparaciones = reparaciones;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMecanico != null ? idMecanico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idMecanico == null && other.idMecanico != null) || (this.idMecanico != null && !this.idMecanico.equals(other.idMecanico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hibernate.entidades.Empleado[ idMecanico=" + idMecanico + " ]";
    }

   

    
}
