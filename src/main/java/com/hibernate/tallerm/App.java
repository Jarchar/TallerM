/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.tallerm;

import com.hibernate.dao.ProvedorDAO;
import com.hibernate.entidades.Direccion;
import com.hibernate.entidades.Pedido;
import com.hibernate.entidades.Provedor;
import com.hibernate.entidades.Refaccion;
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
        
        
        ProvedorDAO provedorDAO=new ProvedorDAO();
        Provedor provedor=new Provedor();
        provedor.setCorreo("cosa7@mail.com");
        provedor.setNombre("PCP");
        provedorDAO.agregaProvedor(provedor);
        

        Telefono telefono=new Telefono();
        telefono.setTelefono(228161572);
        telefono.setProvedor(provedor);
        provedor.getTelefonos().add(telefono);

        Direccion direccion=new Direccion();
        direccion.setCalle("Miguel Aleman");
        direccion.setCiudad("Xalapa");
        direccion.setNumero(8);
        direccion.setColonia("Centro");
        direccion.setCodigoPostal(91500);
        direccion.setProvedor(provedor);

        Pedido pedido=new Pedido();
        pedido.setFecha(new Date());
        pedido.setProvedor(provedor);
        
        Refaccion refaccion1,refaccion2;
        refaccion1 = new Refaccion(new Float("20.0"),"Clotch", "RGB4");
        refaccion2 = new Refaccion(new Float("30.0"),"Freno", "RGB4");
        Set<Refaccion>reffacciones=new HashSet<Refaccion>(0);
        reffacciones.add(refaccion1);
        reffacciones.add(refaccion2);
        pedido.setRefaccions(reffacciones);
        System.out.println("Done");

    
    }

    
}
