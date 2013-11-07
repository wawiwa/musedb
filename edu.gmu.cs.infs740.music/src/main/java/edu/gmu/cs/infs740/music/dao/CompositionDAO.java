package edu.gmu.cs.infs740.music.dao;

import java.util.List;

import javax.xml.xquery.XQConnection;

import org.w3c.dom.Element;

import edu.gmu.cs.infs740.music.Model.Composition;

public class CompositionDAO extends AbstractDAO<Composition> {

	public CompositionDAO(XQConnection conn) {
		super(conn);
	}

	@Override
	public Composition findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Composition> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void persist(Composition entity) {
		// TODO Auto-generated method stub
		
	}

	public List<Composition> findByTitle(String title) {
		String query = "for $composition in doc('/db/myrepo/ExampleMusic.xml')//composition ";
		query += "where contains($composition/title/main_title,\'" + title + "\')";
		query += "return $composition";
		
		List<Composition> result = search(query);
		return result;
	}

	@Override
	protected Composition readObject(Element element) {
		Composition composition = new Composition();
		composition.setMainTitle(element.getElementsByTagName("main_title").item(0).getTextContent());
		composition.setWorkTitle(element.getElementsByTagName("work_title").item(0).getTextContent());
		org.w3c.dom.Element publisherNode = (org.w3c.dom.Element)element.getElementsByTagName("publisher").item(0);
		composition.setPublisher(publisherNode.getElementsByTagName("name").item(0).getTextContent());
		return composition;
	}
}
