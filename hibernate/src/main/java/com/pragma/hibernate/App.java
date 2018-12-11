package com.pragma.hibernate;

import java.util.List;


import com.pragma.hibernate.dao.ProfesorDaoImPlements;

import com.pragma.hibernate.model.Profesor;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      System.out.println("Hola");
      
      
      Profesor profe = new Profesor("jesus", "Sincelejo");
      ProfesorDaoImPlements profeDao = new ProfesorDaoImPlements();
      profeDao.guardarProfesor(profe);
      
   
     
      List<Profesor> profes = profeDao.listarProfes();
      
      for( Profesor p : profes) {
    	  System.out.println("Nombre: "+ p.getNombre_P());
      }
    }
}
