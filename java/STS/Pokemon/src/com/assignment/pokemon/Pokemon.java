package com.assignment.pokemon;

public class Pokemon{
	String name;
	int health;
	String type;
	private static int numOfPokemon = 0;
	
	public Pokemon(){
		setNumOfPokemon(getNumOfPokemon() + 1);
	}
	
	void attackPokemon(Pokemon pokemon) {
		this.health-= 10;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String nameOfP) {
		this.name = nameOfP;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setType(String typeOfP) {
		this.type = typeOfP;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public void setHealth(int healthOfP) {
		this.health = healthOfP;
	}

	public static int getNumOfPokemon() {
		return numOfPokemon;
	}
	
	public static void setNumOfPokemon(int numOfPokemon) {
		Pokemon.numOfPokemon = numOfPokemon;
	}
	
}
