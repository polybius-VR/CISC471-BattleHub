package com.mygdx.game.Entities;

import java.util.List;

import com.mygdx.game.Entities.Skills.Element.Elements;
import com.mygdx.game.Entities.Skills.Skill;

public class BattleEntity extends GameEntity{
	protected String name; //Entity name	
	protected Integer x_pos; //Entity's X position relative to the screen
	protected Integer y_pos; //Entity's Y position relative to the screen
	protected Integer maxHealth;  //Entity's max HP
	protected Integer health; //Entity's current HP
	protected Integer attack; //Entity's base ATK
	protected Integer defense; //Entity's base DEF
	protected Integer speed; //Entity's base SPD
	protected Integer level; //Entity's level (used to multiply it's base stats)
	protected Integer experience; //Entity's Experience tracker
	protected Elements element; //Entity's magic element
	protected Elements weakness;
	protected Elements advantage;
	protected Boolean isDefeat; //a flag to keep track whether or not this entity was defeated in battle.
	protected Boolean isNPC; //a flag to keep track whether this is a playable or non playable character.
	protected List<Skill> skills; //list of skills
	
	public BattleEntity() {
		this.isGoal = Boolean.FALSE;
		this.isHeal = Boolean.FALSE;
		this.isSolid = Boolean.FALSE;
		this.isDefeat = Boolean.FALSE;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getX_pos() {
		return x_pos;
	}
	public void setX_pos(Integer x_pos) {
		this.x_pos = x_pos;
	}
	public Integer getY_pos() {
		return y_pos;
	}
	public void setY_pos(Integer y_pos) {
		this.y_pos = y_pos;
	}
	public Integer getHealth() {
		return health;
	}
	public void setHealth(Integer health) {
		if (health <= 0) {
			this.isDefeat = Boolean.TRUE;
			health = 0;
		}
		this.health = health;
	}
	public Integer getAttack() {
		return attack;
	}
	public void setAttack(Integer attack) {
		this.attack = attack;
	}
	public Integer getDefense() {
		return defense;
	}
	public void setDefense(Integer defense) {
		this.defense = defense;
	}
	public Integer getSpeed() {
		return speed;
	}
	public void setSpeed(Integer speed) {
		this.speed = speed;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getExperience() {
		return experience;
	}
	public void setExperience(Integer experience) {
		this.experience = experience;
	}
	public Elements getElement() {
		return element;
	}
	public void setElement(Elements element) {
		this.element = element;
	}
	public Boolean getIsDefeat() {
		return isDefeat;
	}
	public void setIsDefeat(Boolean isDefeat) {
		this.isDefeat = isDefeat;
	}
	public Boolean getIsNPC() {
		return isNPC;
	}

	public Integer getMaxHealth() {
		return maxHealth;
	}
	public void setMaxHealth(Integer maxHealth) {
		this.maxHealth = maxHealth;
	}
	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public Elements getWeakness() {
		switch (element) {
		case FIRE:
			weakness = Elements.WATER;
			break;
		case WATER:
			weakness = Elements.GRASS;
			break;
		case GRASS:
			weakness = Elements.FIRE;
			break;
		case NONE:
			break;
		}
		return weakness;
	}

	public Elements getAdvantage() {
		switch (element) {
		case FIRE:
			advantage = Elements.GRASS;
			break;
		case WATER:
			advantage = Elements.FIRE;
			break;
		case GRASS:
			advantage = Elements.WATER;
			break;
		case NONE:
			break;
		}
		return advantage;
	}
	
}
