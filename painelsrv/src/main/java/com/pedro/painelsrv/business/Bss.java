package com.pedro.painelsrv.business;

import java.io.Serializable;

import javax.inject.Inject;

import com.pedro.painelsrv.persistence.Dao;

public class  Bss<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	protected Dao<T> dao;

	
}