package com.pedro.painelsrv.persistence;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class Dao<T> {

	private EntityManager em;
	private Class<T> clazz;

	public Dao(EntityManager em, Class<T> clazz) {
		this.em = em;
		this.clazz = clazz;
	}

	public T persit(T t) {
		em.persist(t);
		return t;
	}

	public T merge(T t) {
		em.merge(t);
		return t;
	}

	@SuppressWarnings("unchecked")
	public List<T> getList() {

		Query query = null;
		try {
			Entity annotetiopn = clazz.getAnnotation(Entity.class);
			query = em.createQuery("select o from " + annotetiopn.name() + " o", clazz);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getListJoin(String cond) {

		Query query = null;
		try {
			Entity annotetiopn = clazz.getAnnotation(Entity.class);
			query = em.createQuery("select o from " + annotetiopn.name() + " o " + cond, clazz);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> getListByCond(String cond) {

		Query query = null;
		try {
			Entity annotetion = clazz.getAnnotation(Entity.class);
			query = em.createQuery("select o from " + annotetion.name() + " o where " + cond, clazz);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getListByNativeQueryTypeless(String condicao) {

		Query query = em.createNativeQuery(condicao);
		return query.getResultList();
	}
	public T update(T entity) {

		return em.merge(entity);

	}

	public void delete(Object pk) {
		em.remove(getEntity(pk));
	}

	public T getEntity(Object pk) {
		return em.find(clazz, pk);
	}

	public Integer getNextPk(String pk) {
		return getMaxInt(pk) + 1;
	}

	public Integer getMaxInt(String pk) {

		Query query = em.createQuery("select max(" + pk + ") from " + clazz.getName());
		Object cod = query.getSingleResult();

		if (cod == null)
			return 1;

		if (cod instanceof Integer)
			return (Integer) cod;

		if (cod instanceof Long)
			return ((Long) cod).intValue();

		if (cod instanceof Short)
			return ((Short) cod).intValue();

		return (Integer) cod;
	}
}