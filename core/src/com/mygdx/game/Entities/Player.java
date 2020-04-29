package com.mygdx.game.Entities;

import java.util.ArrayList;
import com.mygdx.game.Entities.Skills.Element;
import com.mygdx.game.Entities.Skills.Skill;
import com.mygdx.game.Entities.Skills.Element.Elements;

public class Player extends BattleEntity{
	public static enum PlayerClass {KNIGHT, SPELLCASTER}
	private Integer[] gridPosition = new Integer[2];	
	private PlayerClass playerClass;
	private Integer deathCount = 0;
	
	public Player() {
		this.isNPC = Boolean.FALSE;
		this.isDefeat = Boolean.FALSE;
		this.setExperience(0);
		this.skills = new ArrayList<Skill>();
		this.skills.add(new Skill("Tackle", new Element(Elements.NONE), 25, Boolean.FALSE));
		this.skills.add(new Skill("Flamethrower", new Element(Elements.FIRE), 25, Boolean.FALSE));
		this.skills.add(new Skill("Water Gun", new Element(Elements.WATER), 25, Boolean.FALSE));
		this.skills.add(new Skill("Nature's Power", new Element(Elements.GRASS), 25, Boolean.TRUE));
	}
	
	public Integer[] getGridPosition() {
		return gridPosition;
	}

	public void setGridPosition(Integer gridPositionX, Integer gridPositionY) {
		this.gridPosition = new Integer[] {gridPositionX, gridPositionY};
	}

	public void moveX_pos(Integer x_pos) {
		super.setX_pos(super.getX_pos() + x_pos);
	}

	public void moveY_pos(Integer y_pos) {
		super.setY_pos(super.getY_pos() + y_pos);
	}

	public PlayerClass getPlayerClass() {
		return playerClass;
	}

	public void setPlayerClass(PlayerClass playerClass) {
		this.playerClass = playerClass;
	}
	
	public void increaseExperience(Integer experience) {
		this.experience += experience;
	}

	public void increseDeathCount() {
		this.deathCount += 1;
	}
	
	public Integer getDeathCount() {
		return deathCount;
	}

	public void setDeathCount(Integer deathCount) {
		this.deathCount = deathCount;
	}
	
	public void levelUp() {
		
	}
}
