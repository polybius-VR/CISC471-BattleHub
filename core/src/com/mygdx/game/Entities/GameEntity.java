package com.mygdx.game.Entities;

import com.badlogic.gdx.graphics.Texture;

public class GameEntity {
	protected Texture sprite;
	protected Boolean isSolid;
	protected Boolean isFoe;
	protected Boolean isGoal;
	protected Boolean isHeal;
	
	public Boolean getIsFoe() {
		return isFoe;
	}
	public void setIsFoe(Boolean isFoe) {
		this.isFoe = isFoe;
	}
	public Texture getSprite() {
		return sprite;
	}
	public void setSprite(Texture sprite) {
		this.sprite = sprite;
	}
	public Boolean getIsSolid() {
		return isSolid;
	}
	public void setIsSolid(Boolean isSolid) {
		this.isSolid = isSolid;
	}
	public Boolean getIsGoal() {
		return isGoal;
	}
	public void setIsGoal(Boolean isGoal) {
		this.isGoal = isGoal;
	}
	public Boolean getIsHeal() {
		return isHeal;
	}
	public void setIsHeal(Boolean isHeal) {
		this.isHeal = isHeal;
	}
	
}
