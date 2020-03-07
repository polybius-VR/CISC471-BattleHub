package com.mygdx.game.Entities.Skills;

public class Element {
	private String name; //Element's Name
	private Element advantage; //What this element is strong against
	private Element weakness; //What this element is weak against
	
	public Element() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Element getAdvantage() {
		return advantage;
	}

	public void setAdvantage(Element advantage) {
		this.advantage = advantage;
	}

	public Element getWeakness() {
		return weakness;
	}

	public void setWeakness(Element weakness) {
		this.weakness = weakness;
	}
	
	
}
