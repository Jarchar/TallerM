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
@Table(name="Reparacion", catalog="TallerM")
public class Reparacion implements java.io.Serializable {
    
        @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="IDVENTA",unique=true,nullable=false) 
    private Integer idVenta;
        
    @Temporal(TemporalType.DATE)
    @Column(name="FECHA", nullable=false, length=10)     
    private Date Fecha;
    
    @Column(name="MONTOTOTAL", precision=6)
    private Float MontoTotal;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Refaccion_has_Reparacion", catalog = "TallerM", joinColumns = { 
                    @JoinColumn(name = "REPARACION_IDVENTA", nullable = false, updatable = false) }, 
                    inverseJoinColumns = { @JoinColumn(name = "REFACCION_IDREFACCION", 
                                    nullable = false, updatable = false) })
    private Set<Refaccion>Refacciones=new HashSet<Refaccion>(0);
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "AUTOMOVIL_IDAUTOMOVIL", nullable = false) 
    private Automovil automovil;

    @ManyToMany(mappedBy="reparaciones", fetch=FetchType.LAZY)
    private Set<Empleado>empleados=new HashSet<Empleado>(0);
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "SERVICIO_IDSERVICIO", nullable = false)
    private Servicio servicio;
    
    public Reparacion(){
        
    }
    public Reparacion(Date Fecha){
        this.Fecha=Fecha;
        
    }
    public Reparacion(Date Fecha, Float MontoTotal){
        this.Fecha=Fecha;
        this.MontoTotal=MontoTotal;    
    }

    /**
     * @return the idVenta
     */

    public Integer getIdVenta() {
        return idVenta;
    }

    /**
     * @param idVenta the idVenta to set
     */
    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    /**
     * @return the Fecha
     */
  
    public Date getFecha() {
        return Fecha;
    }

    /**
     * @param Fecha the Fecha to set
     */
    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    /**
     * @return the MontoTotal
     */
    public Float getMontoTotal() {
        return MontoTotal;
    }

    /**
     * @param MontoTotal the MontoTotal to set
     */
    public void setMontoTotal(Float MontoTotal) {
        this.MontoTotal = MontoTotal;
    }

    /**
     * @return the Refacciones
     */
  
    public Set<Refaccion> getRefacciones() {
        return Refacciones;
    }

    /**
     * @param Refacciones the Refacciones to set
     */
    public void setRefacciones(Set<Refaccion> Refacciones) {
        this.Refacciones = Refacciones;
    }

    public Automovil getAutomovil() {
        return automovil;
    }

    public void setAutomovil(Automovil automovil) {
        this.automovil = automovil;
    }

    /**
     * @return the empleados
     */
    public Set<Empleado> getEmpleados() {
        return empleados;
    }

    /**
     * @param empleados the empleados to set
     */
    public void setEmpleados(Set<Empleado> empleados) {
        this.empleados = empleados;
    }

    /**
     * @return the servicio
     */
    public Servicio getServicio() {
        return servicio;
    }

    /**
     * @param servicio the servicio to set
     */
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    
    
}
