package edu.gmu.cs.infs740.music.dao;

import java.util.List;

public interface DataAccessObject<T> {

	public T findById(String id);
	public List<T> findAll();
	public void persist(T entity);
}
