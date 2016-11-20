package com.shaokat.model;

public enum ProductType {
	MILK("Milk"), BISCUT("Biscuit");

	private final String typeName;
	
	ProductType(String typeName) {
		this.typeName = typeName;

	}
	public String getTypeName(){
		return this.typeName;
	}

}
