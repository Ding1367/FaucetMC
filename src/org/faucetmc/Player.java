package org.faucetmc;

import java.net.Socket;

import org.faucetmc.packet.Packet;

public interface Player {

	Location getLocation();
	Socket getConnection();
	void send(Packet<?> packet);
	ClientState getState();
	void setState(ClientState state);
	Server getServer();
	String getName();
	
}
