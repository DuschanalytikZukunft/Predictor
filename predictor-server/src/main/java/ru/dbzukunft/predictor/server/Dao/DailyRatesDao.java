package ru.dbzukunft.predictor.server.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.dbzukunft.predictor.server.entity.DailyRate;
import ru.dbzukunft.predictor.server.session.HibernateSessionFactoryUtil;

public class DailyRatesDao {

    public DailyRate findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(DailyRate.class, id);
    }

    public void save(DailyRate dailyRate) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(dailyRate);
        tx1.commit();
        session.close();
    }

    public void update(DailyRate dailyRate) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(dailyRate);
        tx1.commit();
        session.close();
    }

    public void delete(DailyRate dailyRate) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(dailyRate);
        tx1.commit();
        session.close();
    }
}
