package org.darkstorm.darkbot.minecraftbot.protocol;

import org.darkstorm.darkbot.minecraftbot.events.EventHandler;
import org.darkstorm.darkbot.minecraftbot.events.EventListener;
import org.darkstorm.darkbot.minecraftbot.events.io.PacketReceivedEvent;
import org.darkstorm.darkbot.minecraftbot.events.io.PacketSentEvent;

public class PacketDebug implements EventListener{

	@EventHandler
	public void onReceive(PacketReceivedEvent e){
		System.out.println("<-- " + e.getPacket().getClass().getName());
	}
	
	@EventHandler
	public void onSend(PacketSentEvent e){
		System.out.println("--> " + e.getPacket().getClass().getName());
	}
}
