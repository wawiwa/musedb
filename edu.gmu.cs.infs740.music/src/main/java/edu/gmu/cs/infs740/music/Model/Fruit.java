package edu.gmu.cs.infs740.music.Model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Fruit")
public class Fruit {

	String name;
	int quantity;
	
	public Fruit() {}
	
	public Fruit(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}
	
	@XmlElement
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (this.name == null || !(obj instanceof Fruit))
			return false;
		Fruit fruit = (Fruit) obj;
		return this.name.equals(fruit.getName());
	}
}
