package org.faucetmc.impl;

import org.faucetmc.Block;
import org.faucetmc.Chunk;
import org.faucetmc.Location;
import org.faucetmc.World;

public class FaucetChunk implements Chunk {

	private final Block[][][] blocks;
	private final int x;
	private final int z;
	private final World world;
	
	public FaucetChunk(World world, int x, int z) {
		this.x = x;
		this.z = z;
		this.world = world;
		blocks = new Block[16][320][16];
	}
	
	@Override
	public World getWorld() {
		// TODO Auto-generated method stub
		return world;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return z;
	}

	@Override
	public Block getBlockAt(int x, int y, int z) {
		// TODO Auto-generated method stub
		return getBlockAt(new Location(getWorld(), x, y, z));
	}

	@Override
	public Block getBlockAt(Location p) {
		int x = (int)p.getX();
		int y = (int)p.getY();
		int z = (int)p.getZ();
		if (x > 15) {
			p.setX(Math.floor(x / 16));
		}
		if (z > 15) {
			p.setZ(Math.floor(z / 16));
		}
		return blocks[(int)p.getX()][y][(int)p.getZ()];
	}

}
