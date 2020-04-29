package com.mygdx.game.Entities.Skills;

public class Element {
	public static enum Elements {FIRE, WATER, GRASS, NONE}
	private String name; //Element's Name
	private Elements element; //This element
	private Elements advantage; //What this element is strong against
	private Elements weakness; //What this element is weak against
	
	public Element(Elements e) {
		if (e == Elements.FIRE) {
			name = "Fire";
			element = e;
			advantage = Elements.GRASS;
			weakness = Elements.WATER;
		}
		
		if (e == Elements.WATER) {
			name = "Water";
			element = e;
			advantage = Elements.FIRE;
			weakness = Elements.GRASS;
		}
		
		if (e == Elements.GRASS) {
			name = "Grass";
			element = e;
			advantage = Elements.WATER;
			weakness = Elements.FIRE;
		}
		
		if (e == Elements.NONE) {
			name = "Neutral";
			element = e;
			advantage = Elements.NONE;
			weakness = Elements.NONE;
		}
	}

	public String getName() {
		return name;
	}

	public Elements getAdvantage() {
		return advantage;
	}

	public Elements getWeakness() {
		return weakness;
	}	
	
	public Elements getElement() {
		return element;
	}
}
