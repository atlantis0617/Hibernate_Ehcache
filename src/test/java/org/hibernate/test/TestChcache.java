package org.hibernate.test;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.model.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestChcache {
	private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    
    @Before
    public void before() {
        sessionFactory = new Configuration().configure().buildSessionFactory();// 创建SessionFactory对象
        session = sessionFactory.openSession();// 获取Session对象
        transaction = session.beginTransaction();// 开启事务
    }
     
    @After
    public void after() {
        transaction.commit();// 提交事务
        session.close();// 关闭Session
        sessionFactory.close();// 关闭SessionFactory
    }
     
    @Test
    public void init() {
        Student student = new Student(1L, "张三", new Date(), "男");
        session.save(student);
        student = new Student(2L, "李四", new Date(), "男");
        session.save(student);
    }
    
    @Test
    public void testChcache() {
        Student student = session.get(Student.class, 1L);
        System.out.println(student.getName());
        session = sessionFactory.openSession();
        student = session.get(Student.class, 1L);
        System.out.println(student.getName());
    }
    
}
