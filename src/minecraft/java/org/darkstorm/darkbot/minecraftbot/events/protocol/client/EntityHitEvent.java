package org.darkstorm.darkbot.minecraftbot.events.protocol.client;

import org.darkstorm.darkbot.minecraftbot.world.entity.Entity;

public class EntityHitEvent extends EntityInteractEvent
{
	public EntityHitEvent(Entity entity)
	{
		super(entity);
	}
}
