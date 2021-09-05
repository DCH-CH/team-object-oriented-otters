package com.plateit.project.models;


public class Beverage extends Item{

	private UnitType unitType;
	private BeverageType type;
	private float size;
	
	public Beverage() {
		
	}

	public BeverageType getType() {
		return type;
	}

	public void setType(BeverageType type) {
		this.type = type;
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
