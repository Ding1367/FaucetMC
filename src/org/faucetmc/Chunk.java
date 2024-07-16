package org.faucetmc;

public interface Chunk {

	World getWorld();
	int getX();
	int getZ();
	Block getBlockAt(int x, int y,  int z);
	Block getBlockAt(Location location);
	
}
