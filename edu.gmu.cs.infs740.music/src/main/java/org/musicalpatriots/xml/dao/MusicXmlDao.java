package org.musicalpatriots.xml.dao;

import java.util.List;

public interface MusicXmlDao<T> {

	public T findById(String id);
	public List<T> findAll();
	public void persist(T entity);
}
