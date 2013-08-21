package org.darkstorm.darkbot.minecraftbot.world.entity;

import org.darkstorm.darkbot.minecraftbot.MinecraftBot;
import org.darkstorm.darkbot.minecraftbot.events.protocol.client.EntityHitEvent;
import org.darkstorm.darkbot.minecraftbot.world.World;
import org.darkstorm.darkbot.minecraftbot.world.block.ArtType;

public class PaintingEntity extends Entity
{
	private final ArtType artType;
	private int direction;

	public PaintingEntity(World world, int id, ArtType artType)
	{
		super(world, id);
		this.artType = artType;
	}

	public ArtType getArtType()
	{
		return artType;
	}

	public int getBlockX()
	{
		return (int) getX();
	}

	public int getBlockY()
	{
		return (int) getY();
	}

	public int getBlockZ()
	{
		return (int) getZ();
	}

	public int getDirection()
	{
		return direction;
	}

	@Override
	public void setX(double x)
	{
		super.setX((int) x);
	}

	@Override
	public void setY(double y)
	{
		super.setY((int) y);
	}

	@Override
	public void setZ(double z)
	{
		super.setZ((int) z);
	}

	public void setDirection(int direction)
	{
		this.direction = direction;
	}

	public void breakPainting()
	{
		MinecraftBot bot = world.getBot();
		bot.getEventManager().sendEvent(new EntityHitEvent(this));
	}
}
