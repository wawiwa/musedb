package edu.gmu.cs.infs740.music.Controller;

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

import edu.gmu.cs.infs740.music.Model.Composition;
import edu.gmu.cs.infs740.music.dao.CompositionDAO;

import net.xqj.exist.ExistXQDataSource;

@Controller
@RequestMapping("/search")
public class SearchController {

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
