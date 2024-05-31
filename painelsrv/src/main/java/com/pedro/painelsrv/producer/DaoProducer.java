package com.pedro.painelsrv.producer;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.pedro.painelsrv.persistence.Dao;
@Dependent
public class DaoProducer {

	@PersistenceContext
	private EntityManager em;

	@Produces
	public <T> Dao<T> produzDao(InjectionPoint point) {

		ParameterizedType parameterizedType = (ParameterizedType) point.getType();
		Type[] typeArguments = parameterizedType.getActualTypeArguments();
		@SuppressWarnings("unchecked")
		Class<T> clazz = (Class<T>) typeArguments[0];

		return new Dao<T>(em, clazz);
	}
}