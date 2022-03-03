package com.plateit.project.models;

import java.util.List;


public class Food extends Item{

	
	private List <Component> components;
	
	public Food() {
		
	}
	
	public List<Component> getIngredients() {
		return components;
	}
	public void setIngredients(List<Component> ingredients) {
		this.components = ingredients;
	}
	
}
