package ru.dbzukunft.predictor.server.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.dbzukunft.predictor.server.entity.DailyRates;
import ru.dbzukunft.predictor.server.session.HibernateSessionFactoryUtil;

import java.util.List;
public class DailyRatesDao {

    public DailyRates findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(DailyRates.class, id);
    }

    public void save(DailyRates dailyRates) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(dailyRates);
        tx1.commit();
        session.close();
    }

    public void update(DailyRates dailyRates) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(dailyRates);
        tx1.commit();
        session.close();
    }

    public void delete(DailyRates dailyRates) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(dailyRates);
        tx1.commit();
        session.close();
    }
}
