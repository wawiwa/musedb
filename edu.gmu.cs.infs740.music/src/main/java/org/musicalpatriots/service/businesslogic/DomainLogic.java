package org.musicalpatriots.service.businesslogic;

import java.util.ArrayList;
import java.util.List;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;

import net.xqj.exist.ExistXQDataSource;

import org.musicalpatriots.xml.dao.CompositionDao;
import org.musicalpatriots.xml.entity.CompositionEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

public class DomainLogic {
	
    public List<CompositionEntity> findByTitle (String title) {
            try {
                    XQDataSource xqs = new ExistXQDataSource();
                    xqs.setProperty("serverName", "musicalpatriots.org");
                    xqs.setProperty("port", "8899");
                    xqs.setProperty("user", "admin");
                    xqs.setProperty("password", "gmupatriots");
                    XQConnection conn = xqs.getConnection();
                    System.out.println("connection:" + conn);
                    CompositionDao dao = new CompositionDao(conn);
                    
                    List<CompositionEntity> searchResult = dao.findByTitle(title);
                    //System.out.println("search result count:" + searchResult.size());
                    //System.out.println("search result title:" + searchResult.get(0).getMainTitle());
                    
                    return searchResult;
            } catch (XQException ex) {
                    ex.printStackTrace();
            }                
            return new ArrayList<CompositionEntity>();

    }

}
