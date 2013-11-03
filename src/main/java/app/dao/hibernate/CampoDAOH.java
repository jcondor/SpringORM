/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao.hibernate;

import app.dao.BaseHibernateDAO;
import app.dao.CampoDAO;
import app.model.Campo;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


@Repository("campoDAO")
public class CampoDAOH extends BaseHibernateDAO implements CampoDAO {

    public List<Campo> list() {
        Criteria criteria = this.getSession().createCriteria(Campo.class);
        return criteria.list();
    }

    public Campo get(Campo t) {
        Criteria criteria = this.getSession().createCriteria(Campo.class);
        criteria.add(Restrictions.eq("id", t.getId()));
        return (Campo) criteria.uniqueResult();
    }

    public void save(Campo t) {
        Session sesion = this.getSession();
        Transaction tr = sesion.beginTransaction();
        sesion.save(t);
        tr.commit();
    }

    public void update(Campo t) {
        Session sesion = this.getSession();
        Transaction tr = sesion.beginTransaction();
        sesion.update(t);
        tr.commit();
    }

    public void delete(Campo t) {
        Session sesion = this.getSession();
        Transaction tr = sesion.beginTransaction();
        sesion.delete(t);
        tr.commit();
    }
    
}
