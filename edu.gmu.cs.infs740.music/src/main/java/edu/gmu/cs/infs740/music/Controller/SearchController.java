package edu.gmu.cs.infs740.music.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.xmldb.api.base.*;
import org.xmldb.api.modules.*;
import org.xmldb.api.*;
import javax.xml.transform.OutputKeys;
import org.exist.xmldb.EXistResource;


@Controller
@RequestMapping("/search")
public class SearchController {

//	Hey Reza, the existdb libs are loading properly now using the pom.
//	Do Run As: maven:clean, then Run As: maven:install
//	@RequestMapping(value = "/title", method = RequestMethod.POST, headers = {"Accept=text/xml, application/xml"})
//	public @ResponseBody  findItems(@RequestParam String param) {
//
//	}
}
