package com.mygdx.game.Entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Entities.Skills.Element.Elements;
import com.mygdx.game.Entities.Skills.Skill;
import com.mygdx.game.Entities.Skills.SkillList;

public class Enemy extends BattleEntity{
	private Texture spriteDetail;
	
	public Enemy(String spritePath, String spriteDetailPath, String name, Integer baseATK, Integer baseDEF, Integer baseSPD, Integer maxHP, Integer experience, Elements element, Integer level) {
		this.isNPC = Boolean.TRUE;
		this.isFoe = Boolean.TRUE;		
		this.sprite = new Texture(Gdx.files.internal(spritePath));
		this.name = name;
		this.attack = baseATK;
		this.defense = baseDEF;
		this.speed = baseSPD;
		this.maxHealth = maxHP;
		this.health = maxHP;
		this.experience = experience;
		this.element = element;
		this.level = level;
		spriteDetail = new Texture(Gdx.files.internal(spriteDetailPath));
		
		List<Skill> invalidSkills = new ArrayList<Skill>();
		Iterator<Skill> i;
		
		this.skills = new ArrayList<Skill>();
		
		this.skills.addAll(SkillList.NEUTRAL_SKILLS);
		i = SkillList.NEUTRAL_SKILLS.iterator();		
		while (i.hasNext()) {
			Skill s = i.next();
			if (s.getLearnAtLevel() > this.level)
				invalidSkills.add(s);
		}
		
		switch (element) {
		case FIRE:
			this.skills.addAll(SkillList.FIRE_SKILLS);
			i = SkillList.FIRE_SKILLS.iterator();		
			while (i.hasNext()) {
				Skill s = i.next();
				if (s.getLearnAtLevel() > this.level)
					invalidSkills.add(s);
			}
			break;
		case WATER:
			this.skills.addAll(SkillList.WATER_SKILLS);
			i = SkillList.WATER_SKILLS.iterator();		
			while (i.hasNext()) {
				Skill s = i.next();
				if (s.getLearnAtLevel() > this.level)
					invalidSkills.add(s);
			}
			break;
		case GRASS:
			this.skills.addAll(SkillList.GRASS_SKILLS);
			i = SkillList.GRASS_SKILLS.iterator();		
			while (i.hasNext()) {
				Skill s = i.next();
				if (s.getLearnAtLevel() > this.level)
					invalidSkills.add(s);
			}
			break;
		default:
			break;
		}
		
		this.skills.removeAll(invalidSkills);
	}

	public Texture getSpriteDetail() {
		return spriteDetail;
	}

	public void setSpriteDetail(Texture spriteDetail) {
		this.spriteDetail = spriteDetail;
	}
	
}
