package com.assignment.pokemon;

public interface PokemonInterface {
	String name = null;
	int health = 0;
	String type = null;

	default Pokemon createPokemon(String name, int health, String type){
		PokemonInterface.name = name;
		this.health = health;
		this.type = type;
		return Pokemon;
	}
	
}
