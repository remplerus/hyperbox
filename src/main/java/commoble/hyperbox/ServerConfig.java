package commoble.hyperbox;

import commoble.hyperbox.ConfigHelper.ConfigValueListener;
import net.minecraftforge.common.ForgeConfigSpec;

public class ServerConfig
{
	public final ConfigValueListener<Boolean> autoForceHyperboxChunks;
	
	public ServerConfig(ForgeConfigSpec.Builder builder, ConfigHelper.Subscriber subscriber)
	{
		builder.push("world_management");
		this.autoForceHyperboxChunks = subscriber.subscribe(builder
			.comment(
				"Enable automatic forceloading of hyperbox chunks.",
				"While this is enabled, the primary chunks of hyperbox worlds will be kept loaded while the",
				"parent hyperbox's chunk is loaded, and will be kept unloaded while the parent hyperbox's chunk",
				"is not loaded.",
				"If this is disabled, no automatic enabling or disabling of forceloading will be done. In this case,",
				"hyperbox's interiors will only tick while occupied by a player, or while forceloaded through",
				"other means.",
				"Be aware that if this option is changed from true to false while any hyperbox chunks are currently",
				"forceloaded, they will continue to be forceloaded until those chunks are manually un-forceloaded.")
			.define("auto_force_hyperbox_chunks", true)
			);
		builder.pop();
	}
}
