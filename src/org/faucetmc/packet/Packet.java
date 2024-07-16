package org.faucetmc.packet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface Packet<T> {

	int size();
	byte[] bytes();
	int id();
	boolean compressed();
	boolean encrypted();
	T payload();
	
	public static final int CONTINUE_BIT = 0x80;
	public static final int SEGMENT_BITS = 0x7F;
	
	public static int readVarInt(InputStream input) throws IOException {
		int value = 0, position = 0;
		byte currentByte;
		while (true) {
			currentByte = (byte)input.read();
			value |= (currentByte & SEGMENT_BITS) << position;
			
			if ((currentByte & CONTINUE_BIT) == 0) break;
			
			position += 7;
			
			if (position >= 32) throw new RuntimeException("VarInt is too big");
		}
		input.close();
		return value;
	}
	
	public static long readVarLong(InputStream input) throws IOException {
		long value = 0;
		int position = 0;
		byte currentByte;
		while (true) {
			currentByte = (byte)input.read();
			value |= (currentByte & SEGMENT_BITS) << position;
			
			if ((currentByte & CONTINUE_BIT) == 0) break;
			
			position += 7;
			
			if (position >= 64) throw new RuntimeException("VarInt is too big");
		}
		input.close();
		return value;
	}
	
	public static void writeVarInt(OutputStream out, int value) throws IOException {
		while (true) {
			if ((value & ~SEGMENT_BITS) == 0) {
				out.write(value);
				return;
			}
			out.write((value & SEGMENT_BITS) | CONTINUE_BIT);
			value >>>= 7;
		}
	}
	
	public static void writeVarLong(OutputStream out, long value) throws IOException {
		while (true) {
			if (((value & ~SEGMENT_BITS) == 0)) {
				out.write((int)value);
				return;
			}
			out.write((int)(value & SEGMENT_BITS) | CONTINUE_BIT);
			value >>>= 7;
		}
	}
	
	public static String readString(InputStream input) throws IOException {
		return readString(input, 32767);
	}
	
	public static String readString(InputStream input, int max) throws IOException {
		int length = readVarInt(input);
		if (length > max)
			return null;
		byte[] str = new byte[length];
		input.read(str);
		return new String(str);
	}
	
	public static boolean writeString(OutputStream output, String str) throws IOException {
		int length = str.length();
		if (length > 32767)
			return false;
		writeVarInt(output, length);
		output.write(str.getBytes());
		return true;
	}
}
