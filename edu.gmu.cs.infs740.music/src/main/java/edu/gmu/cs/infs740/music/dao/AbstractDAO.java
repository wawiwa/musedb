package edu.gmu.cs.infs740.music.dao;

import java.util.ArrayList;
import java.util.List;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQSequence;

import org.w3c.dom.Element;

public abstract class AbstractDAO<T> implements DataAccessObject<T> {

	protected XQConnection conn;
	
	public AbstractDAO(XQConnection conn) {
		this.conn = conn;
	}
	
	protected abstract T readObject(Element element);
	
	protected List<T> search(String query) {
		List<T> searchResult = new ArrayList<T>();
		try {
			XQPreparedExpression expr = conn.prepareExpression(query);
			XQSequence resultSeq = expr.executeQuery();
			
			while(resultSeq.next()) {
				Element element = (Element)resultSeq.getObject();
				T entity = readObject(element);
				searchResult.add(entity);
			}
			resultSeq.close();
			expr.close();
			System.out.println("Terminated Successfully");
		} catch (XQException ex) {
			ex.printStackTrace();
		}		
		return searchResult;		
	}
}
