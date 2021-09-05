package com.plateit.project.models;

public class Component extends Item{

	private UnitType unitType;
	private float size;
	
	public Component() {
		
	}
	public UnitType getUnitType() {
		return unitType;
	}

	public void setUnitType(UnitType unitType) {
		this.unitType = unitType;
	}
	public float getSize() {
		return size;
	}
	public void setSize(float size) {
		this.size = size;
	}
	
	
}
