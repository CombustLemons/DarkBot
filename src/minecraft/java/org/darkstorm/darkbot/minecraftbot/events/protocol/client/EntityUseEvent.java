package org.darkstorm.darkbot.minecraftbot.events.protocol.client;

import org.darkstorm.darkbot.minecraftbot.world.entity.Entity;

public class EntityUseEvent extends EntityInteractEvent
{
	public EntityUseEvent(Entity entity)
	{
		super(entity);
	}
}
