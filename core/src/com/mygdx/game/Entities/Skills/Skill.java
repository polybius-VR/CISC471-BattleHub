package com.mygdx.game.Entities.Skills;

public class Skill {
	private String name; //Skill name
	private Element element; //Skill element bonus
	private Integer baseAttack; //Skill base attack
	private Boolean healBonus; //Skill has a bonus to heal the user.
	
	public Skill(String name, Element element, Integer baseAttack, Boolean healBonus) {
		this.name = name;
		this.element = element;
		this.baseAttack = baseAttack;
		this.healBonus = healBonus;
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

	public Boolean getHealBonus() {
		return healBonus;
	}

	public void setHealBonus(Boolean healBonus) {
		this.healBonus = healBonus;
	}
	
	
}
