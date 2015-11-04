/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.tallerm;

import com.hibernate.dao.AutomovilDAO;
import com.hibernate.dao.ClienteDAO;
import com.hibernate.dao.DireccionDAO;
import com.hibernate.dao.PedidoDAO;
import com.hibernate.dao.ProvedorDAO;
import com.hibernate.dao.RefaccionDAO;
import com.hibernate.dao.ReparaccionDAO;
import com.hibernate.dao.TelProvedorDAO;
import com.hibernate.entidades.Automovil;
import com.hibernate.entidades.Cliente;
import com.hibernate.entidades.Direccion;
import com.hibernate.entidades.Pedido;
import com.hibernate.entidades.Provedor;
import com.hibernate.entidades.Refaccion;
import com.hibernate.entidades.Reparacion;
import com.hibernate.entidades.TelCliente;
import com.hibernate.entidades.Telefono;
import com.hibernate.init.HibernateUtil;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;

/**
 *
 * @author bruno
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hibernate one to many (Annotation)");
        
        
        /*ProvedorDAO provedorDAO=new ProvedorDAO();
        Provedor provedor=new Provedor();
        provedor.setCorreo("cbbbbbbb@hotmail.com");
        provedor.setNombre("CADF9");
        provedorDAO.agregaProvedor(provedor);
        

        TelProvedorDAO telDAO=new TelProvedorDAO();
        Telefono telefono=new Telefono();
        telefono.setTelefono(665655211);
        telefono.setProvedor(provedor);
        provedor.getTelefonos().add(telefono);
        telDAO.agregaTelProvedor(telefono);
        provedorDAO.actualizaProvedor(provedor);

        DireccionDAO dirDAO=new DireccionDAO();
        Direccion direccion=new Direccion();
        direccion.setCalle("Miguel Aleman");
        direccion.setCiudad("Xalapa");
        direccion.setNumero(8);
        direccion.setColonia("Centro");
        direccion.setCodigoPostal(91500);
        direccion.setProvedor(provedor);
        dirDAO.agregaProvedor(direccion);
        provedor.getDireccions().add(direccion);
        provedorDAO.actualizaProvedor(provedor);

        Pedido pedido=new Pedido();
        pedido.setFecha(new Date());
        pedido.setProvedor(provedor);
        PedidoDAO pedidoDAO=new PedidoDAO();
        pedidoDAO.agregaPedido(pedido);
        provedor.getPedidos().add(pedido);
        
        Refaccion refaccion1,refaccion2;
        refaccion1 = new Refaccion(new Float("20.0"),"Clotch", "RGB4");
        refaccion2 = new Refaccion(new Float("30.0"),"Freno", "RGB4");
        Set<Refaccion>reffacciones=new HashSet<Refaccion>(0);
        reffacciones.add(refaccion1);
        reffacciones.add(refaccion2);
        RefaccionDAO refaccionDAO=new RefaccionDAO();
        refaccionDAO.agregaProvedor(refaccion2);
        refaccionDAO.agregaProvedor(refaccion1);
        pedido.getRefaccions().add(refaccion2);
        pedido.getRefaccions().add(refaccion1);
        pedidoDAO.agregaPedido(pedido);
        

        
        pedido.setRefaccions(reffacciones);*/
   
        
        TelCliente telcliente=new TelCliente();
        
        
        ClienteDAO clienteDAO=new ClienteDAO();
        Cliente cliente=new Cliente();
        cliente.setNombre("Silvana");
        cliente.setApellidoM("Estrada");
        cliente.setApellidoP("Beverido");
        cliente.setColonia("Centro");
        cliente.setCalle("Altamirano");
        cliente.setCodPostal(91500);
        cliente.setNum(3);
        clienteDAO.agregaCliente(cliente);
        
        
        AutomovilDAO automovilDAO=new AutomovilDAO();
        Automovil automovil=new Automovil();
        automovil.setAno(1999);
        automovil.setMarca("Chevrolet");
        automovil.setPlaca("SGX78");
        automovilDAO.agregaAutomovil(automovil);
        cliente.getAutomoviles().add(automovil);
        clienteDAO.actualizaCliente(cliente);
        
        Refaccion refaccion1,refaccion2;
        refaccion1 = new Refaccion(new Float("20.0"),"Clotch", "RGB4");
        refaccion2 = new Refaccion(new Float("30.0"),"Freno", "RGB4");
        Set<Refaccion>reffacciones=new HashSet<Refaccion>(0);
        reffacciones.add(refaccion1);
        reffacciones.add(refaccion2);
        RefaccionDAO refaccionDAO=new RefaccionDAO();
        
        
        
        ReparaccionDAO reparacionDAO=new ReparaccionDAO();
        Reparacion reparacion=new Reparacion();
        reparacion.setAutomovil(automovil);
        reparacion.setFecha(new Date());
        reparacion.setMontoTotal(Float.valueOf("500.5"));
        reparacion.setRefacciones(reffacciones);
        reparacionDAO.agregaProvedor(reparacion);
        
        
        System.out.println("Done");

    
    }

    
}
