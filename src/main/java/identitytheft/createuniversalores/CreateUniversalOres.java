package identitytheft.createuniversalores;

import com.simibubi.create.foundation.data.CreateRegistrate;
import identitytheft.createuniversalores.block.ModBlocks;
import net.fabricmc.api.ModInitializer;

import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateUniversalOres implements ModInitializer {
	public static final String MOD_ID = "create_universal_ores";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID).defaultCreativeTab((RegistryKey<ItemGroup>) null);

	@Override
	public void onInitialize() {
		LOGGER.info("Starting Create: Universal Ores");

		ModBlocks.register();
		// Items

		REGISTRATE.register();
	}
}