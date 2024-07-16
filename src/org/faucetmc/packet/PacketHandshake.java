package org.faucetmc.packet;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import static org.faucetmc.packet.Packet.*;

public class PacketHandshake implements Packet<byte[]> {

	private final byte[] data;
	private int sz;
	private String address;
	private int protocolVersion;
	private int port;
	private int nextState;
	
	public PacketHandshake(byte[] data) {
		this.data = data;
		InputStream byteInput = new ByteArrayInputStream(data);
		try {
			this.sz = readVarInt(byteInput);
			// discard packet id
			readVarInt(byteInput);
			this.protocolVersion = readVarInt(byteInput);
			this.address = readString(byteInput, 255);
			this.port = (byteInput.read() >> 8) | byteInput.read();
			this.nextState = readVarInt(byteInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return String.format("[address=%s,port=%d,protocolVersion=%d,nextState=%d,size=%d]",
				address, port, protocolVersion, nextState, sz);
	}
	
	public int getNextState() {
		return nextState;
	}
	
	public String getServerAddress() {
		return address;
	}
	
	public int getServerPort() {
		return port;
	}
	
	public int getProtocolVersion() {
		return protocolVersion;
	}
	
	@Override
	public int size() {
		return sz;
	}

	@Override
	public byte[] bytes() {
		return data;
	}

	@Override
	public int id() {
		return 0x00;
	}

	@Override
	public boolean compressed() { 
		return false;
	}

	@Override
	public boolean encrypted() {
		return false;
	}

	@Override
	public byte[] payload() {
		return bytes();
	}

}
