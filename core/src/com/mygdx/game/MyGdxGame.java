package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.Screens.TitleScreen;

public class MyGdxGame extends Game {
	static public Skin skin;
	@Override
	public void create() {
		skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
		this.setScreen(new TitleScreen(this));
	}
	
	public void Render() {
		super.render();
	}
	
	public void dispose() {
		
	}
	
}
