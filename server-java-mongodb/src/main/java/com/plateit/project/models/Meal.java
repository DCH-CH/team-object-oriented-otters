package com.plateit.project.models;


import java.util.List;


public class Meal extends Item{

	private List <Component> components;
	private List <Side> sides;
	private Beverage beverage;
	

	public Meal() {
		
	}

	public List<Component> getComponents() {
		return components;
	}

	public void setComponents(List<Component> components) {
		this.components = components;
	}

	public List<Side> getSides() {
		return sides;
	}

	public void setSides(List<Side> sides) {
		this.sides = sides;
	}

	public Beverage getBeverage() {
		return beverage;
	}

	public void setBeverage(Beverage beverage) {
		this.beverage = beverage;
	}
	
	
}
