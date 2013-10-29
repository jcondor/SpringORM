/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao.hibernate;

import app.dao.BaseHibernateDAO;
import app.dao.ServicioDAO;
import app.model.Servicio;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


@Repository("servicioDAO")
public class ServicioDAOH extends BaseHibernateDAO implements ServicioDAO {

    public List<Servicio> list() {
        Criteria criteria = this.getSession().createCriteria(Servicio.class);
        return criteria.list();
    }

    public Servicio get(Servicio t) {
        Criteria criteria = this.getSession().createCriteria(Servicio.class);
        criteria.add(Restrictions.eq("id", t.getId()));
        return (Servicio) criteria.uniqueResult();
    }

    public void save(Servicio t) {
        Session sesion = this.getSession();
        Transaction tr = sesion.beginTransaction();
        sesion.save(t);
        tr.commit();
    }

    public void update(Servicio t) {
        Session sesion = this.getSession();
        Transaction tr = sesion.beginTransaction();
        sesion.update(t);
        tr.commit();
    }

    public void delete(Servicio t) {
        Session sesion = this.getSession();
        Transaction tr = sesion.beginTransaction();
        sesion.delete(t);
        tr.commit();
    }
    
}
