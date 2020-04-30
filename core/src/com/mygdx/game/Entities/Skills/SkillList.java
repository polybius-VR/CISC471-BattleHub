package com.mygdx.game.Entities.Skills;

import java.util.ArrayList;
import java.util.List;

import com.mygdx.game.Entities.Skills.Element.Elements;

public class SkillList {
	public static List<Skill> NEUTRAL_SKILLS = new ArrayList<Skill>();
	public static List<Skill> FIRE_SKILLS = new ArrayList<Skill>();
	public static List<Skill> WATER_SKILLS = new ArrayList<Skill>();
	public static List<Skill> GRASS_SKILLS = new ArrayList<Skill>();
	
	static {
		//Neutral Skills
		NEUTRAL_SKILLS.add(new Skill("Tackle", Elements.NONE, 15, Boolean.FALSE, 1));
		NEUTRAL_SKILLS.add(new Skill("Scratch", Elements.NONE, 25, Boolean.FALSE, 3));
		NEUTRAL_SKILLS.add(new Skill("Bind", Elements.NONE, 15, Boolean.TRUE, 5));
		NEUTRAL_SKILLS.add(new Skill("Take Down", Elements.NONE, 50, Boolean.FALSE, 7));
		NEUTRAL_SKILLS.add(new Skill("Take Down", Elements.NONE, 50, Boolean.FALSE, 9));
		
		//Fire Skills
		FIRE_SKILLS.add(new Skill("Flame toss", Elements.FIRE, 25, Boolean.FALSE, 2));
		FIRE_SKILLS.add(new Skill("Heat Wave", Elements.FIRE, 15, Boolean.TRUE, 4));
		FIRE_SKILLS.add(new Skill("Fire Ball", Elements.FIRE, 15, Boolean.FALSE, 6));
		FIRE_SKILLS.add(new Skill("Inferno", Elements.FIRE, 15, Boolean.FALSE, 8));
		FIRE_SKILLS.add(new Skill("Flamethrower", Elements.FIRE, 15, Boolean.FALSE, 10));
		
		//Water Skills
		WATER_SKILLS.add(new Skill("Water gun", Elements.WATER, 20, Boolean.FALSE, 2));
		WATER_SKILLS.add(new Skill("Hydro Pump", Elements.WATER, 35, Boolean.FALSE, 4));
		WATER_SKILLS.add(new Skill("Surf", Elements.WATER, 35, Boolean.FALSE, 6));
		WATER_SKILLS.add(new Skill("Hydro Cannon", Elements.WATER, 35, Boolean.FALSE, 8));
		WATER_SKILLS.add(new Skill("Healing Water", Elements.WATER, 35, Boolean.TRUE, 10));
		
		//Grass Skills
		GRASS_SKILLS.add(new Skill("Nature's power", Elements.GRASS, 10, Boolean.TRUE, 2));
		GRASS_SKILLS.add(new Skill("Bullet Seed", Elements.GRASS, 30, Boolean.FALSE, 4));
		GRASS_SKILLS.add(new Skill("Razor Leaf", Elements.GRASS, 30, Boolean.FALSE, 6));
		GRASS_SKILLS.add(new Skill("Leaf Blade", Elements.GRASS, 30, Boolean.FALSE, 8));
		GRASS_SKILLS.add(new Skill("Vine Whip", Elements.GRASS, 30, Boolean.FALSE, 10));
	}
}
