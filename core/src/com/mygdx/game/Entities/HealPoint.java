package com.mygdx.game.Entities;

public class HealPoint extends GameEntity{
	public HealPoint() {
		this.isFoe = Boolean.FALSE;
		this.isGoal = Boolean.FALSE;
		this.isSolid = Boolean.FALSE;
		this.isHeal = Boolean.TRUE;
	}
}
