package org.faucetmc;

import java.util.Collection;

public interface Server {

	World getMainWorld();
	String getMOTD();
	int getPlayerCount();
	int getMaxPlayers();
	int getDifficulty();
	Collection<Player> getPlayers();
	
}
