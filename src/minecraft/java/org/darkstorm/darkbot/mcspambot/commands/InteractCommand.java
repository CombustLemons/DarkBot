package org.darkstorm.darkbot.mcspambot.commands;

import org.darkstorm.darkbot.mcspambot.MinecraftBotWrapper;
import org.darkstorm.darkbot.minecraftbot.ai.*;
import org.darkstorm.darkbot.minecraftbot.events.EventManager;
import org.darkstorm.darkbot.minecraftbot.events.protocol.client.*;
import org.darkstorm.darkbot.minecraftbot.world.block.BlockLocation;
import org.darkstorm.darkbot.minecraftbot.world.entity.MainPlayerEntity;

public class InteractCommand extends AbstractCommand
{

	public InteractCommand(MinecraftBotWrapper bot)
	{
		super(bot, "interact", "Interact with a block",
				"<hit|break|use> <x> <y> <z>",
				"(?i)(hit|break|use) [-]?[0-9]+ [-]?[0-9]+ [-]?[0-9]+");
	}

	@Override
	public void execute(String[] args)
	{
		int x = Integer.parseInt(args[1]);
		int y = Integer.parseInt(args[2]);
		int z = Integer.parseInt(args[3]);
		MainPlayerEntity player = bot.getPlayer();
		EventManager eventManager = bot.getEventManager();

		if (args[0].equalsIgnoreCase("hit"))
		{
			player.face(x, y, z);
			eventManager.sendEvent(new PlayerRotateEvent(player));
			eventManager.sendEvent(new ArmSwingEvent());
			eventManager.sendEvent(new BlockBreakStartEvent(x, y, z, 0));
		} else if (args[0].equalsIgnoreCase("break")) // Non-blocking
			new BlockBreakActivity(bot, new BlockLocation(x, y, z));
		else if (args[0].equalsIgnoreCase("use"))
			new BlockPlaceActivity(bot, new BlockLocation(x, y, z));
	}
}
