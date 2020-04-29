package com.mygdx.game.Entities;

public class Wall extends GameEntity{
		
	public Wall() {
		this.isGoal = Boolean.FALSE;
		this.isFoe = Boolean.FALSE;
		this.isSolid = Boolean.TRUE;
		this.isHeal = Boolean.FALSE;
	}
}
