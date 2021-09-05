package com.plateit.project.models;


public class Side extends Item{

	public UnitType unitType;
	public float size;
	
	public Side () {

	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}
	
}
