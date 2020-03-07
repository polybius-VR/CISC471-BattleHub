package com.mygdx.game.Entities;

import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Entities.Skills.Element;
import com.mygdx.game.Entities.Skills.Skill;

public class Player {
	private String name; //Player's name
	
	private Texture sprite; //Image to represent the player
	private Integer x_pos = 20; //player's X position relative to the screen
	private Integer y_pos = 0; //player's Y position relative to the screen
	
	private Integer health; //player's HP
	private Integer attack; //player's base ATK
	private Integer defense; //player's base DEF
	private Integer magic; //player's base magic
	private Integer resistance; //player's base defense against magic
	private Integer level; //player's current level
	private Integer experience; //player's experience points. Level up and reset the value to 0 every 100 points.
	
	private Element element; //player's magic element
	private List<Skill> skills; //player's list of skills
	
	public Player() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Texture getSprite() {
		return sprite;
	}

	public void setSprite(Texture sprite) {
		this.sprite = sprite;
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

	public Integer getMagic() {
		return magic;
	}

	public void setMagic(Integer magic) {
		this.magic = magic;
	}

	public Integer getResistance() {
		return resistance;
	}

	public void setResistance(Integer resistance) {
		this.resistance = resistance;
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
}
