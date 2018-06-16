package com.ubb.cs.microservices.controller;

import java.util.List;

public interface ICrudController<T> {
	T create(T entity);

	T update(T entity);

	List<T> getAll();

	T getById(int id);

	void delete(int id);
}
