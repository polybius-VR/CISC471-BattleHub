package com.mygdx.game.Entities;

import com.badlogic.gdx.graphics.Texture;

public class Enemy {
	private String name; //Enemy's Name
	
	private Texture sprite; //Image to represent this enemy
	private Integer x_pos; //Enemy's X position relative to the screen
	private Integer y_pos; //Enemy's Y position relative to the screen
	
	private Integer health; //Enemy's base HP
	private Integer attack; //Enemy's base ATK
	private Integer defense; //Enemy's base DEF
	private Integer magic; //Enemey's base magic
	private Integer resistance; //Enemy's base magic defense
	private Integer level; //Enemy's level (used to multiply it's base stats)
	private Integer experience; //Experience points to be awarded when defeated
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
