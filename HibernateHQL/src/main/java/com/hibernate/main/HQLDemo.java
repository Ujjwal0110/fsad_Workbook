package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.hibernate.entity.Product;
import com.hibernate.util.HibernateUtil;

public class HQLDemo {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(new Product("Keyboard", "Accessories", 1200, 20));
        session.save(new Product("Mouse", "Accessories", 500, 50));
        session.save(new Product("Monitor", "Electronics", 15000, 8));

        tx.commit();
        session.close();

        System.out.println("Products inserted");
    }
}
