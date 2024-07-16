package org.faucetmc.impl;

import org.faucetmc.Block;
import org.faucetmc.Location;
import org.faucetmc.Material;

public class FaucetBlock implements Block {

	private final Location location;
	private Material type;
	
	public FaucetBlock(Location location) {
		this(location, Material.AIR);
	}
	
	public FaucetBlock(Location location, Material mat) {
		this.location = location;
		this.type = mat;
	}
	
	@Override
	public Material getType() {
		// TODO Auto-generated method stub
		return type;
	}
	
	@Override
	public void setType(Material type) {
		this.type = type;
	}

	@Override
	public Location getLocation() {
		return location;
	}

}
