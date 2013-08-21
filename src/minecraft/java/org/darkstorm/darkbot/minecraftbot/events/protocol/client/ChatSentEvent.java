package org.darkstorm.darkbot.minecraftbot.events.protocol.client;

import org.darkstorm.darkbot.minecraftbot.events.protocol.ProtocolEvent;

public class ChatSentEvent extends ProtocolEvent
{
	private final String message;

	public ChatSentEvent(String message)
	{
		this.message = message;
	}

	public String getMessage()
	{
		return message;
	}
}
