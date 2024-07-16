package org.faucetmc.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.faucetmc.Location;
import org.faucetmc.Material;
import org.faucetmc.Player;
import org.faucetmc.Server;
import org.faucetmc.World;

public class FaucetServer implements Server {
	
	private final World mainWorld;
	private final List<Player> players = new ArrayList<>();
	
	public FaucetServer() {
		mainWorld = new FaucetWorld();
		
		mainWorld.getBlockAt(new Location(mainWorld)).setType(Material.TNT);
	}
	
	@Override
	public Collection<Player> getPlayers() {
		// TODO Auto-generated method stub
		return players;
	}
	
	@Override
	public World getMainWorld() {
		// TODO Auto-generated method stub
		return mainWorld;
	}

	@Override
	public String getMOTD() {
		// TODO Auto-generated method stub
		return "The message of the day is: continue existing";
	}

	@Override
	public int getPlayerCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxPlayers() {
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	public int getDifficulty() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
