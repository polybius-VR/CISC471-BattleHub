package com.mygdx.game.Entities;

import com.badlogic.gdx.graphics.Texture;

public class GameEntity {
	private Texture sprite;
	private Boolean isSolid;
	private Boolean isFoe;
	
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
	
	
}
