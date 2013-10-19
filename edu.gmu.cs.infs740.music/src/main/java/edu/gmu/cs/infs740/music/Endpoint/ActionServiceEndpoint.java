package edu.gmu.cs.infs740.music.Endpoint;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName="ActionService")
public class ActionServiceEndpoint {
	
	@WebMethod
	public String sayHello(String name) {
		String msg = "Hello " + name + "!";
		System.out.println(msg);
		return msg;
	}

	@WebMethod
	public void checkConnection() {
		System.out.println("WS Connected!");
	}
}
