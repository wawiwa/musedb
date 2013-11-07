package edu.gmu.cs.infs740.music.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;
import java.util.List;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.xquery.*;
import javax.xml.namespace.QName;

import net.xqj.exist.ExistXQDataSource;




import edu.gmu.cs.infs740.music.Model.Composition;
import edu.gmu.cs.infs740.music.dao.CompositionDAO;
import net.xqj.exist.ExistXQDataSource;

@Controller
public class SearchController {
	
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public static String getConnection() throws Exception
	{
		logger.info("SearchController: ");
	    XQDataSource xqs = new ExistXQDataSource();
	    xqs.setProperty("serverName", "localhost");
	    xqs.setProperty("port", "8899");

	    XQConnection conn = xqs.getConnection();

	    XQPreparedExpression xqpe =
	      conn.prepareExpression("declare variable $x as xs:string external; $x");

	    xqpe.bindString(new QName("x"), "Hello World!", null);

	    XQResultSequence rs = xqpe.executeQuery();

	    while(rs.next())
	      System.out.println(rs.getItemAsString(null));
	    
	    String query = "for $composition in doc('/db/music/examplemusic.xml')//composition ";
        query += "where contains($composition/title/main_title,\'" + "Inventio" + "\')";
        query += "return $composition";
        
        XQPreparedExpression xqpe2 =
      	      conn.prepareExpression(query);

      	    //xqpe2.bindString(new QName("x"), "Hello World!", null);

      	    XQResultSequence rs2 = xqpe2.executeQuery();

      	    while(rs2.next())
      	      System.out.println(rs2.getItemAsString(null));

	    conn.close();
	    

	    return "index";
	}

	@RequestMapping(value = "/title", method = RequestMethod.POST, headers = {"Accept=application/json"})
	public @ResponseBody List<Composition> findByTitle(@RequestParam String title) {
		try {
			XQDataSource xqs = new ExistXQDataSource();
			xqs.setProperty("serverName", "localhost");
			xqs.setProperty("port", "8899");
			XQConnection conn = xqs.getConnection();
			CompositionDAO dao = new CompositionDAO(conn);
			List<Composition> searchResult = dao.findByTitle(title);
			return searchResult;
		} catch (XQException ex) {
			ex.printStackTrace();
		}		
		return new ArrayList<Composition>();

	}

}
