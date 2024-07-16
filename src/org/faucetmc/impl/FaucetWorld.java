package org.faucetmc.impl;

import org.faucetmc.Block;
import org.faucetmc.Chunk;
import org.faucetmc.Location;
import org.faucetmc.World;

public class FaucetWorld implements World {

	private final Chunk[][] chunks;
	private Location worldSpawn;
	
	@Override
	public Chunk getChunkAt(int x, int z) {
		if (x >= chunks.length || z >= chunks[x].length) {
			return null;
		}
		return chunks[x][z];
	}

	@Override
	public Block getBlockAt(int x, int y, int z) {
		// TODO Auto-generated method stub
		return getBlockAt(new Location(this, x, y, z));
	}

	@Override
	public Block getBlockAt(Location location) {
		int chunkX = Math.floorDiv((int) location.getX(), 16);
		int chunkZ = Math.floorDiv((int) location.getZ(), 16);
		Chunk chunk = getChunkAt(chunkX, chunkZ);
		if (chunk != null) {
			return chunk.getBlockAt(location);
		}
		return null;
	}
	
	public FaucetWorld() {
		chunks = new Chunk[5][5];
		worldSpawn = new Location(this, 100, 50, 100);
	}

	@Override
	public Location getWorldSpawn() {
		// TODO Auto-generated method stub
		return worldSpawn;
	}

	@Override
	public void setWorldSpawn(Location loc) {
		this.worldSpawn = loc;
	}

}
