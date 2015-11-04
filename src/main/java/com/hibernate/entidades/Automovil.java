/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.entidades;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author bruno
 */
@Entity
@Table(name="Automovil", catalog="TallerM")
public class Automovil implements java.io.Serializable{
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="IDAUTOMOVIL",unique=true,nullable=false) 
    private Integer idAutomovil;
    
    @Column(name="MARCA", nullable=false,length=10)
    private String Marca;
    
    @Column(name="MODELO", length=15)
    private String Modelo;
    
    @Column(name="ANO")
    private String Ano;
    
    @Column(name="COLOR", length=10)
    private String Color;
    
    @Column(name="PLACA", unique=true, nullable=false)
    private String Placa;
    
    @OneToMany(mappedBy = "automovil", fetch=FetchType.LAZY)
    private Set<Reparacion>reparaciones=new HashSet<Reparacion>(0);

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "IDCLIENTE", nullable = false)
    private Cliente cliente;
    
    public Automovil(){
        
    }
    public Automovil(String Marca, String Modelo, String Ano, String Color, String Placa){
        this.Marca=Marca;
        this.Modelo=Modelo;
        this.Ano=Ano;
        this.Placa=Placa;
        this.Color=Color;
    }
    public Automovil(String Marca, String Modelo, String Placa){
        this.Marca=Marca;
        this.Modelo=Modelo;
        this.Placa=Placa;
    }
    public Automovil(String Placa){
        this.Placa=Placa;

    }
    public Automovil(String Marca, String Modelo, String Ano, String Placa){
        this.Marca=Marca;
        this.Modelo=Modelo;
        this.Ano=Ano;
        this.Placa=Placa;
    }

    /**
     * @return the idAutomovil
     */

    public Integer getIdAutomovil() {
        return idAutomovil;
    }

    /**
     * @param idAutomovil the idAutomovil to set
     */
    public void setIdAutomovil(Integer idAutomovil) {
        this.idAutomovil = idAutomovil;
    }

    /**
     * @return the Marca
     */
    public String getMarca() {
        return Marca;
    }

    /**
     * @param Marca the Marca to set
     */
    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    /**
     * @return the Modelo
     */
    public String getModelo() {
        return Modelo;
    }

    /**
     * @param Modelo the Modelo to set
     */
    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    /**
     * @return the Ano
     */
    public String getAno() {
        return Ano;
    }

    /**
     * @param Ano the Ano to set
     */
    public void setAno(String Ano) {
        this.Ano = Ano;
    }

    /**
     * @return the Color
     */
    public String getColor() {
        return Color;
    }

    /**
     * @param Color the Color to set
     */
    public void setColor(String Color) {
        this.Color = Color;
    }

    /**
     * @return the Placa
     */
    public String getPlaca() {
        return Placa;
    }

    /**
     * @param Placa the Placa to set
     */
    public void setPlaca(String Placa) {
        this.Placa = Placa;
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

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
}
