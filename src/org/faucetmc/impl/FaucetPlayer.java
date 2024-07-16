package org.faucetmc.impl;

import java.io.IOException;
import java.net.Socket;

import org.faucetmc.ClientState;
import org.faucetmc.Location;
import org.faucetmc.Player;
import org.faucetmc.Server;
import org.faucetmc.packet.Packet;

public class FaucetPlayer implements Player {

	private Location location;
	private final Server server;
	private final Socket socket;
	private ClientState clientState;
	private final String name;
	
	public FaucetPlayer(Server server, Socket socket) {
		this.server = server;
		location = server.getMainWorld().getWorldSpawn();
		this.socket = socket;
		clientState = ClientState.HANDSHAKE;
		name = null;
	}
	
	@Override
	public Server getServer() {
		return server;
	}
	
	@Override
	public Location getLocation() {
		// TODO Auto-generated method stub
		return location;
	}

	@Override
	public Socket getConnection() {
		// TODO Auto-generated method stub
		return socket;
	}

	@Override
	public void send(Packet<?> packet) {
		try {
			socket.getOutputStream().write(packet.bytes());
			socket.getOutputStream().flush();
		} catch (IOException e) {
			e.fillInStackTrace();
		}
	}

	@Override
	public ClientState getState() {
		// TODO Auto-generated method stub
		return clientState;
	}

	@Override
	public void setState(ClientState state) {
		this.clientState = state;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

}
