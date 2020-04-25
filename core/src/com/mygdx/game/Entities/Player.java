package com.mygdx.game.Entities;

import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Entities.Skills.Element;
import com.mygdx.game.Entities.Skills.Skill;

public class Player extends GameEntity{
	public static enum PlayerClass {KNIGHT, SPELLCASTER}
	private String name; //Player's name
	
	private Integer x_pos = 20; //player's X position relative to the screen
	private Integer y_pos = 0; //player's Y position relative to the screen
	private Integer[] gridPosition = new Integer[2];
	
	private Integer MaxHealth; //player's max HP
	private Integer health; //player's current HP
	private Integer attack; //player's base ATK
	private Integer defense; //player's base DEF
	private Integer speed; //player's base SPD
	private Integer level; //player's current level
	private Integer experience; //player's experience points. Level up and reset the value to 0 every 100 points.
	
	private PlayerClass playerClass; 
	private Element element; //player's magic element
	private List<Skill> skills; //player's list of skills
	
	public Integer[] getGridPosition() {
		return gridPosition;
	}

	public void setGridPosition(Integer gridPositionX, Integer gridPositionY) {
		this.gridPosition = new Integer[] {gridPositionX, gridPositionY};
	}

	public Player() {
		
	}

	public Integer getMaxHealth() {
		return MaxHealth;
	}

	public void setMaxHealth(Integer maxHealth) {
		MaxHealth = maxHealth;
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
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
		this.x_pos = this.x_pos + x_pos;
	}

	public Integer getY_pos() {
		return y_pos;
	}

	public void setY_pos(Integer y_pos) {
		this.y_pos = this.y_pos + y_pos;
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

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public Integer getHealth() {
		return health;
	}

	public void setHealth(Integer health) {
		this.health = health;
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

	public PlayerClass getPlayerClass() {
		return playerClass;
	}

	public void setPlayerClass(PlayerClass playerClass) {
		this.playerClass = playerClass;
	}
}
