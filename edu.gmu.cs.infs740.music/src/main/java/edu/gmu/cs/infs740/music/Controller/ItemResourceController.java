package edu.gmu.cs.infs740.music.Controller;

import edu.gmu.cs.infs740.music.Model.Fruit;
import edu.gmu.cs.infs740.music.Model.FruitWrapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/items")
public class ItemResourceController {

	private static final List<Fruit> availableFruits = new ArrayList<Fruit>();
	static {
		availableFruits.add(new Fruit("Apple", 100));
		availableFruits.add(new Fruit("Apricot", 150));
		availableFruits.add(new Fruit("Avocado", 200));
		availableFruits.add(new Fruit("Banana", 250));
		availableFruits.add(new Fruit("Blackberry", 300));
		availableFruits.add(new Fruit("Blueberry", 350));
		availableFruits.add(new Fruit("Cherry", 400));
		availableFruits.add(new Fruit("Coconut", 450));
		availableFruits.add(new Fruit("Fig", 500));
		availableFruits.add(new Fruit("Grape", 550));
		availableFruits.add(new Fruit("Lemon", 600));
		availableFruits.add(new Fruit("Mango", 650));
		availableFruits.add(new Fruit("Melon", 700));
		availableFruits.add(new Fruit("Watermelon", 750));
		availableFruits.add(new Fruit("Orange", 800));
		availableFruits.add(new Fruit("Tangerine", 850));
		availableFruits.add(new Fruit("Peach", 900));
		availableFruits.add(new Fruit("Pear", 950));
		availableFruits.add(new Fruit("Plum", 1000));
		availableFruits.add(new Fruit("Raspberry", 1050));
		availableFruits.add(new Fruit("Strawberry", 1100));
	}
	
	private Fruit getFruit(String name) {
		for (Fruit fruit : availableFruits) {
			String upperCaseName = fruit.getName().toUpperCase();
			if (upperCaseName.equals(name.toUpperCase()))
				return fruit;
		}
		return new Fruit("No Item Found!", 0);
	}
	
	private List<Fruit> findFruits(String name) {
		List<Fruit> fruitList = new ArrayList<Fruit>();
		for (Fruit fruit : availableFruits) {
			String upperCaseName = fruit.getName().toUpperCase();
			if (upperCaseName.contains(name.toUpperCase()))
				fruitList.add(fruit);
		}
		return fruitList;
	}
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET, headers = {"Accept=text/xml, application/xml"})
	public @ResponseBody Fruit getItem(@PathVariable String name) {
		String item = "Item requested: " + name + "!";
		System.out.println(item);
		Fruit requested = getFruit(name);
		return requested;
	}
	
	@RequestMapping(value = "/Find", method = RequestMethod.POST, headers = {"Accept=text/xml, application/xml"})
	public @ResponseBody FruitWrapper findItems(@RequestParam String param) {
		String item = "Item searched: " + param + "!";
		System.out.println(item);
		FruitWrapper wrapper = new FruitWrapper();
		List<Fruit> fruits = findFruits(param);
		wrapper.setFruitList(fruits);
		return wrapper;
	}
	
	@RequestMapping(value = "/json/{name}", method = RequestMethod.GET, headers = {"Accept=application/json"})
	public @ResponseBody Fruit getItemInJSON(@PathVariable String name) {
		String item = "JSON Item requested: " + name + "!";
		System.out.println(item);
		Fruit requested = getFruit(name);
		return requested;
	}
	
	@RequestMapping(value = "/json/Find", method = RequestMethod.POST, headers = {"Accept=application/json"})
	public @ResponseBody FruitWrapper findItemsInJSON(@RequestParam String param) {
		String item = "JSON Item searched: " + param + "!";
		System.out.println(item);
		FruitWrapper wrapper = new FruitWrapper();
		List<Fruit> fruits = findFruits(param);
		wrapper.setFruitList(fruits);
		wrapper.setTempo("WHAT???");
		return wrapper;
	}
}
