package org.faucetmc;

public interface Block {

	Material getType();
	void setType(Material type);
	Location getLocation();
	default World getWorld() {
		return getLocation().getWorld();
	}
	
}
