package org.darkstorm.darkbot.minecraftbot.events.world;

import org.darkstorm.darkbot.minecraftbot.events.Event;
import org.darkstorm.darkbot.minecraftbot.world.*;
import org.darkstorm.darkbot.minecraftbot.world.block.*;

public class BlockChangeEvent extends Event
{
	private final World world;
	private final BlockLocation location;
	private final Block oldBlock, newBlock;

	public BlockChangeEvent(World world, BlockLocation location,
			Block oldBlock, Block newBlock)
	{
		this.world = world;
		this.location = location;
		this.oldBlock = oldBlock;
		this.newBlock = newBlock;
	}

	public World getWorld()
	{
		return world;
	}

	public BlockLocation getLocation()
	{
		return location;
	}

	public Block getOldBlock()
	{
		return oldBlock;
	}

	public Block getNewBlock()
	{
		return newBlock;
	}
}
