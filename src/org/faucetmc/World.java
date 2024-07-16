package org.faucetmc;

public interface World {
	
	Chunk getChunkAt(int x, int z);
	Block getBlockAt(int x, int y, int z);
	Block getBlockAt(Location location);
	Location getWorldSpawn();
	void setWorldSpawn(Location loc);
	
	
}
