package org.darkstorm.darkbot.minecraftbot.events.protocol.client;

import org.darkstorm.darkbot.minecraftbot.world.entity.Entity;

public abstract class EntityInteractEvent extends EntityEvent
{
	public EntityInteractEvent(Entity entity)
	{
		super(entity);
	}
}
