package com.mygdx.game.Entities.Skills;

import com.mygdx.game.Entities.Skills.Element.Elements;

public class Skill {
	private String name; //Skill name
	private Elements element; //Skill element bonus
	private Integer baseAttack; //Skill base attack
	private Boolean healBonus; //Skill has a bonus to heal the user.
	private Integer learnAtLevel; //The level at which this skill is learnt at.
	
	public Skill(String name, Elements element, Integer baseAttack, Boolean healBonus, Integer learnAtLevel) {
		this.name = name;
		this.element = element;
		this.baseAttack = baseAttack;
		this.healBonus = healBonus;
		this.learnAtLevel = learnAtLevel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Elements getElement() {
		return element;
	}

	public void setElement(Elements element) {
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

	public Integer getLearnAtLevel() {
		return learnAtLevel;
	}

	public void setLearnAtLevel(Integer learnAtLevel) {
		this.learnAtLevel = learnAtLevel;
	}
	
	
}
