package org.faucetmc;

public class Location {

	private double x, y, z, yaw, pitch;
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getZ() {
		return z;
	}
	
	public double getYaw() {
		return yaw;
	}
	
	public double getPitch() {
		return pitch;
	}
	
	public void setPitch(double pitch) {
		this.pitch = pitch;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public void setYaw(double yaw) {
		this.yaw = yaw;
	}
	
	public void setZ(double z) {
		this.z = z;
	}
	
	private World world;
	
	public World getWorld() {
		return world;
	}
	
	public void setWorld(World world) {
		this.world = world;
	}
	
	public Location(World world, double x, double y, double z) {
		this(world, x, y, z, 0, 0);
	}
	
	public Location(World world, double x, double y, double z, double yaw, double pitch) {
		setWorld(world);
		setX(x);
		setY(y);
		setZ(z);
		setYaw(yaw);
		setPitch(pitch);
	}

	public Location(World mainWorld) {
		this(mainWorld, 0, 0, 0);
	}
	
}
