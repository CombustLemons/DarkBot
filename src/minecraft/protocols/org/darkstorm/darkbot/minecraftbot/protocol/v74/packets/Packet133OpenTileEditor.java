package org.darkstorm.darkbot.minecraftbot.protocol.v74.packets;

import java.io.*;

import org.darkstorm.darkbot.minecraftbot.protocol.*;

public class Packet133OpenTileEditor extends AbstractPacket implements
		ReadablePacket
{
	public byte type;
	public int x, y, z;

	public Packet133OpenTileEditor()
	{
	}

	@Override
	public void readData(DataInputStream in) throws IOException
	{
		type = in.readByte();
		x = in.readInt();
		y = in.readInt();
		z = in.readInt();
	}

	@Override
	public int getId()
	{
		return 133;
	}
}
