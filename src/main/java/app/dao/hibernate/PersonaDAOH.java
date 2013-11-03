/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao.hibernate;

import app.dao.BaseHibernateDAO;
import app.dao.PersonaDAO;
import app.model.Persona;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


@Repository("personaDAO")
public class PersonaDAOH extends BaseHibernateDAO implements PersonaDAO {

    public List<Persona> list() {
        Criteria criteria = this.getSession().createCriteria(Persona.class);
        return criteria.list();
    }

    public Persona get(Persona t) {
        Criteria criteria = this.getSession().createCriteria(Persona.class);
        criteria.add(Restrictions.eq("id", t.getId()));
        return (Persona) criteria.uniqueResult();
    }

    public void save(Persona t) {
        Session sesion = this.getSession();
        Transaction tr = sesion.beginTransaction();
        sesion.save(t);
        tr.commit();
    }

    public void update(Persona t) {
        Session sesion = this.getSession();
        Transaction tr = sesion.beginTransaction();
        sesion.update(t);
        tr.commit();
    }

    public void delete(Persona t) {
        Session sesion = this.getSession();
        Transaction tr = sesion.beginTransaction();
        sesion.delete(t);
        tr.commit();
    }
    
}
