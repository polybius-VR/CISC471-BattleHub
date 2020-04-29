package com.mygdx.game.Entities;

import java.util.ArrayList;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Entities.Skills.Element;
import com.mygdx.game.Entities.Skills.Element.Elements;
import com.mygdx.game.Entities.Skills.Skill;

public class Enemy extends BattleEntity{
	private Texture spriteDetail;
	
	public Enemy(String spritePath, String spriteDetailPath, String name, Integer baseATK, Integer baseDEF, Integer baseSPD, Integer maxHP, Integer experience, Element element) {
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
		spriteDetail = new Texture(Gdx.files.internal(spriteDetailPath));
		
		skills = new ArrayList<Skill>();
		skills.add(new Skill("Tackle", new Element(Elements.NONE), 15, Boolean.FALSE));
		skills.add(new Skill("Flamethrower", new Element(Elements.FIRE), 15, Boolean.FALSE));
		skills.add(new Skill("Water Gun", new Element(Elements.WATER), 15, Boolean.FALSE));
		skills.add(new Skill("Nature's Power", new Element(Elements.GRASS), 15, Boolean.TRUE));
		
	}

	public Texture getSpriteDetail() {
		return spriteDetail;
	}

	public void setSpriteDetail(Texture spriteDetail) {
		this.spriteDetail = spriteDetail;
	}
	
}
