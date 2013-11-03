/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.test;

import app.dao.ServicioDAO;
import app.model.Servicio;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ServicioDAOTest {
    public static void main(String[] args) {
       // ServicioDAOTest.update3();
        ServicioDAOTest.getAll();
    }

    public static void getAll() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");
 
        List<Servicio> servicios = servicioDAO.list();
        for (Servicio servicio : servicios) {
            System.out.println(servicio.getId()+" "+servicio.getDescripcion() + " " + servicio.getCostoHora());
        }
    }
    
    public static void update3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");
        
        Servicio servicio = new Servicio();
        
        servicio.setId(3L);
        servicio.setDescripcion("Jose Condor Aguayo");
        servicio.setCostoHora(1524.11);
        
        servicioDAO.update(servicio);
        
        System.out.println(servicio.getId()+" "+servicio.getDescripcion()+" "+servicio.getCostoHora());
    }
    
    
}
