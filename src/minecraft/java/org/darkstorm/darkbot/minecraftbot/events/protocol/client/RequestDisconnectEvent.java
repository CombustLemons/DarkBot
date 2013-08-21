package org.darkstorm.darkbot.minecraftbot.events.protocol.client;

import org.darkstorm.darkbot.minecraftbot.events.protocol.ProtocolEvent;

public class RequestDisconnectEvent extends ProtocolEvent
{
	private final String reason;

	public RequestDisconnectEvent(String reason)
	{
		this.reason = reason;
	}

	public String getReason()
	{
		return reason;
	}
}
