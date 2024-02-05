package com.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Hibernate01 {
public static void main(String ar[]) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Query q = session.createQuery("from UserDetail where userName = 1");
		List<UserDetail> userlist = q.list();
		
		
		Query q2 = session.createQuery("from UserDetail where userName = 1");
		userlist = q2.list();
		
}}
