package com.mygdx.game.Entities.Skills;

public class Element {
	public static enum Elements {FIRE, WATER, GRASS}
	private String name; //Element's Name
	private Elements advantage; //What this element is strong against
	private Elements weakness; //What this element is weak against
	
	public Element(Elements e) {
		if (e == Elements.FIRE) {
			name = "Fire";
			advantage = Elements.GRASS;
			weakness = Elements.WATER;
		}
		
		if (e == Elements.WATER) {
			name = "Water";
			advantage = Elements.FIRE;
			weakness = Elements.GRASS;
		}
		
		if (e == Elements.GRASS) {
			name = "Grass";
			advantage = Elements.WATER;
			weakness = Elements.FIRE;
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
	
}
