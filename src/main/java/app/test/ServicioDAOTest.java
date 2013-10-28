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
        
        ServicioDAOTest.getAll();
        ServicioDAOTest.get3();
        ServicioDAOTest.update3();
    }

    public static void getAll() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");
 
        List<Servicio> servicios = servicioDAO.list();
        for (Servicio servicio : servicios) {
            System.out.println(servicio.getId()+" "+servicio.getDescripcion() + " " + servicio.getCostoHora());
        }
    }
    
    public static void get3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");
        
        Servicio servicio = new Servicio();
        servicio.setId((Long) 3L);
                
        servicio = servicioDAO.get(servicio);
        
        System.out.println(servicio.getId()+" "+servicio.getDescripcion()+" "+servicio.getCostoHora());
    }
    
    public static void update3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");
        
        Servicio servicio = new Servicio();
        servicio.setId((Long) 3L);
        servicio.setDescripcion("Hola");
        servicio.setCostoHora(12.3);
        
        servicioDAO.update(servicio);
                
        servicio = servicioDAO.get(servicio);
        
        System.out.println(servicio.getId()+" "+servicio.getDescripcion()+" "+servicio.getCostoHora());
    }
}
