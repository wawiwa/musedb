package edu.gmu.cs.infs740.music.Model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Fruit-List")
public class FruitWrapper {
	
	private List<Fruit> fruitList;
	
	private String temp;
	
	public FruitWrapper() {
		fruitList = new ArrayList<Fruit>();
	}
	
	@XmlElement(name="Fruit-Item")
	public List<Fruit> getFruitList() {
		return fruitList;
	}
	
	public void setFruitList(List<Fruit> fruitList) {
		this.fruitList = fruitList;
	}

	public String getTemp() {
		return temp;
	}

	public void setTempo(String temp) {
		this.temp = temp;
	}

	public void addFruit(Fruit fruit) {
		fruitList.add(fruit);
	}
}
