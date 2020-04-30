package com.mygdx.game.Entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mygdx.game.Entities.Skills.Skill;
import com.mygdx.game.Entities.Skills.SkillList;

public class Player extends BattleEntity{
	public static enum PlayerClass {KNIGHT, SPELLCASTER}
	private Integer[] gridPosition = new Integer[2];	
	private PlayerClass playerClass;
	private Integer deathCount = 0;
	private Boolean levelUpFlag = Boolean.FALSE;
	
	public Player() {
		this.isNPC = Boolean.FALSE;
		this.isDefeat = Boolean.FALSE;
		this.setExperience(0);
		this.skills = new ArrayList<Skill>();
		this.skills.add(SkillList.NEUTRAL_SKILLS.get(0));
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
		switch (this.level) {
		case 1:
			if (this.experience >= 100)
				levelUp();
			break;
		case 2:
			if (this.experience >= 200)
				levelUp();
			break;
		case 3:
			if (this.experience >= 400)
				levelUp();
			break;
		case 4:
			if (this.experience >= 800)
				levelUp();
			break;
		case 5:
			if (this.experience >= 1600)
				levelUp();
			break;
		case 6:
			if (this.experience >= 3200)
				levelUp();
			break;
		case 7:
			if (this.experience >= 6400)
				levelUp();
			break;
		case 8:
			if (this.experience >= 12800)
				levelUp();
			break;
		case 9:
			if (this.experience >= 25600)
				levelUp();
			break;
		default:
			if (this.experience >= 50000 * (level-10))
				levelUp();
			break;
		}
		
	}

	public void increseDeathCount() {
		this.deathCount += 1;
	}
	
	public Integer getDeathCount() {
		return deathCount;
	}

	public Boolean getLevelUpFlag() {
		return levelUpFlag;
	}

	public void setLevelUpFlag(Boolean levelUpFlag) {
		this.levelUpFlag = levelUpFlag;
	}

	public void setDeathCount(Integer deathCount) {
		this.deathCount = deathCount;
	}
	
	public void levelUp() {
		this.level += 1;
		
		if (this.playerClass.equals(Player.PlayerClass.KNIGHT)) {
			this.attack += 3;
			this.defense += 5;
			this.speed += 3;
			this.maxHealth += 20;			
			
		} else {
			this.attack += 6;
			this.defense += 3;
			this.speed += 5;
			this.maxHealth += 10;
		}
		
		this.levelUpFlag = Boolean.TRUE;
	}
	
	public void learnSkill(Skill newSkill) {
		this.skills.add(newSkill);
	}
	
	public void learnSkill(Skill newSkill, Skill skillToRemove) {
		this.skills.set( skills.indexOf(skillToRemove) , newSkill);		
	}
	
	public Skill getLearnableSkill() {
		List<Skill> availableSkills = new ArrayList<Skill>();
		Iterator<Skill> i;
		
		i = SkillList.NEUTRAL_SKILLS.iterator();
		while (i.hasNext()) {
			Skill s = i.next();
			if (s.getLearnAtLevel() == this.level)
				availableSkills.add(s);
		}
		
		switch (this.element) {
		case FIRE:
			i = SkillList.FIRE_SKILLS.iterator();
			while (i.hasNext()) {
				Skill s = i.next();
				if (s.getLearnAtLevel() == this.level)
					availableSkills.add(s);
			}
			break;
		case WATER:
			i = SkillList.WATER_SKILLS.iterator();
			while (i.hasNext()) {
				Skill s = i.next();
				if (s.getLearnAtLevel() == this.level)
					availableSkills.add(s);
			}
			break;
		case GRASS:
			i = SkillList.GRASS_SKILLS.iterator();
			while (i.hasNext()) {
				Skill s = i.next();
				if (s.getLearnAtLevel() == this.level)
					availableSkills.add(s);
			}
			break;
		default:
			break;
		}
		
		return availableSkills.get(0);
	}
}