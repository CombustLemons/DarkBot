package org.darkstorm.darkbot.minecraftbot.protocol.v74.packets;

import java.io.*;

import org.darkstorm.darkbot.minecraftbot.protocol.*;
import org.darkstorm.darkbot.minecraftbot.util.IntHashMap;
import org.darkstorm.darkbot.minecraftbot.world.entity.*;

public class Packet40EntityMetadata extends AbstractPacket implements
		ReadablePacket
{
	public int entityId;
	public IntHashMap<WatchableObject> metadata;

	public Packet40EntityMetadata()
	{
	}

	@Override
	public void readData(DataInputStream in) throws IOException
	{
		entityId = in.readInt();
		metadata = DataWatcher.readWatchableObjects(in);
	}

	@Override
	public int getId()
	{
		return 40;
	}
}
