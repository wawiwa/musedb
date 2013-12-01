package org.musicalpatriots.xml.dao;

import java.util.List;

import javax.xml.xquery.XQConnection;

import org.musicalpatriots.xml.dao.AbstractDao;
import org.musicalpatriots.xml.entity.CompositionEntity;
import org.w3c.dom.Element;

public class CompositionDao extends AbstractDao<CompositionEntity> {

	public CompositionDao(XQConnection conn) {
		super(conn);	
	}

	public CompositionEntity findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompositionEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void persist(CompositionEntity entity) {
		// TODO Auto-generated method stub
		
	}

	public List<CompositionEntity> findByTitle(String title) {
		String query = "for $composition in doc('/db/music/musicxml/CompositionCollection.xml')/composition_collection/composition ";
		query += "where contains($composition/title/main_title,\'" + title + "\')";
		query += "return $composition";
		
		System.out.println("query: "+query);
		List<CompositionEntity> result = search(query);
		return result;
	}

	@Override
	protected CompositionEntity readObject(Element element) {
		CompositionEntity composition = new CompositionEntity();
		composition.setMainTitle(element.getElementsByTagName("main_title").item(0).getTextContent());
		composition.setWorkTitle(element.getElementsByTagName("work_title").item(0).getTextContent());
		org.w3c.dom.Element publisherNode = (org.w3c.dom.Element)element.getElementsByTagName("publisher").item(0);
		composition.setPublisher(publisherNode.getElementsByTagName("name").item(0).getTextContent());
		return composition;
	}

}
