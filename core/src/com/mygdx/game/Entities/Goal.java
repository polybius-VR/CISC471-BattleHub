package com.mygdx.game.Entities;

public class Goal extends GameEntity{
	public Goal() {
		this.isGoal = Boolean.TRUE;
		this.isFoe = Boolean.FALSE;
		this.isSolid = Boolean.FALSE;
		this.isHeal = Boolean.FALSE;
	}
}
