package com.mygdx.game.Entities.Skills;

public class Skill {
	private String name; //Skill name
	private Element element; //Skill element bonus
	private Integer baseAttack; //Skill base attack
	
	public Skill() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public Integer getBaseAttack() {
		return baseAttack;
	}

	public void setBaseAttack(Integer baseAttack) {
		this.baseAttack = baseAttack;
	}
	
	
}
