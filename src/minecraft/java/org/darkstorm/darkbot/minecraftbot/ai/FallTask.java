package org.darkstorm.darkbot.minecraftbot.ai;

import org.darkstorm.darkbot.minecraftbot.MinecraftBot;
import org.darkstorm.darkbot.minecraftbot.world.World;
import org.darkstorm.darkbot.minecraftbot.world.block.*;
import org.darkstorm.darkbot.minecraftbot.world.entity.MainPlayerEntity;

public class FallTask implements Task
{
	private final MinecraftBot bot;

	public FallTask(MinecraftBot bot)
	{
		this.bot = bot;
	}

	@Override
	public synchronized boolean isPreconditionMet()
	{
		MainPlayerEntity player = bot.getPlayer();
		if (player == null)
			return false;
		return !player.isOnGround();
	}

	@Override
	public synchronized boolean start(String... options)
	{
		return isPreconditionMet();
	}

	@Override
	public synchronized void stop()
	{
	}

	@Override
	public synchronized void run()
	{
		MainPlayerEntity player = bot.getPlayer();
		World world = bot.getWorld();
		if (player == null || world == null)
			return;
		double speed = WalkActivity.getDefaultSpeed();
		BlockLocation location = new BlockLocation(player.getLocation());
		if (player.isInLiquid())
			speed *= WalkActivity.getDefaultLiquidFactor();
		else if (!bot.getWorld().getPathFinder().getHeuristic()
				.isClimbableBlock(location))
			speed *= WalkActivity.getDefaultFallFactor();
		int lowestY = location.getY();
		while (true)
		{
			int id = world.getBlockIdAt(location.getX(), (lowestY - 1),
					location.getZ());
			BlockType type = BlockType.getById(id);
			if (type.isSolid() || lowestY <= 0)
				break;
			lowestY--;
		}
		player.setY(player.getY() + Math.max(-speed, lowestY - player.getY()));
	}

	@Override
	public synchronized boolean isActive()
	{
		MainPlayerEntity player = bot.getPlayer();
		if (player == null)
			return false;
		return !player.isOnGround();
	}

	@Override
	public TaskPriority getPriority()
	{
		return TaskPriority.NORMAL;
	}

	@Override
	public boolean isExclusive()
	{
		return false;
	}

	@Override
	public boolean ignoresExclusive()
	{
		if (bot.hasActivity() && bot.getActivity() instanceof WalkActivity)
			return false;
		return true;
	}

	@Override
	public String getName()
	{
		return "Fall";
	}

	@Override
	public String getOptionDescription()
	{
		return "";
	}
}
