package org.darkstorm.darkbot.minecraftbot.events.protocol.server;

public class EntityMountEvent extends EntityEvent
{
	private final int mountedEntityId;

	public EntityMountEvent(int entityId, int mountedEntityId)
	{
		super(entityId);

		this.mountedEntityId = mountedEntityId;
	}

	public int getMountedEntityId()
	{
		return mountedEntityId;
	}
}
