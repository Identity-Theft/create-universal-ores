package identitytheft.createuniversalores.block;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllCreativeModeTabs;
import com.simibubi.create.AllItems;
import com.tterrag.registrate.providers.loot.RegistrateBlockLootTables;
import com.tterrag.registrate.util.entry.BlockEntry;
import io.github.fabricators_of_create.porting_lib.tags.Tags;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.registry.tag.BlockTags;

import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;
import static com.simibubi.create.foundation.data.TagGen.tagBlockAndItem;
import static identitytheft.createuniversalores.CreateUniversalOres.*;

public class ModBlocks {
	public static final BlockEntry<Block> GRANITE_ZINC_ORE = registerZincOre("granite", AbstractBlock.Settings.copy(Blocks.GRANITE).strength(3.0f, 3.0f));
	public static final BlockEntry<Block> DIORITE_ZINC_ORE = registerZincOre("diorite", AbstractBlock.Settings.copy(Blocks.DIORITE).strength(3.0f, 3.0f));
	public static final BlockEntry<Block> ANDESITE_ZINC_ORE = registerZincOre("andesite", AbstractBlock.Settings.copy(Blocks.ANDESITE).strength(3.0f, 3.0f));
	public static final BlockEntry<Block> TUFF_ZINC_ORE = registerZincOre("tuff", AbstractBlock.Settings.copy(Blocks.TUFF).strength(3.0f, 3.0f));
	public static final BlockEntry<Block> CALCITE_ZINC_ORE = registerZincOre("calcite", AbstractBlock.Settings.copy(Blocks.CALCITE).strength(0.5f, 0.5f));

	private static BlockEntry<Block> registerZincOre(String prefix, AbstractBlock.Settings settings) {
		return REGISTRATE.block(prefix + "_zinc_ore", Block::new)
				.initialProperties(() -> Blocks.GOLD_ORE)
				.properties(p -> settings)
				.transform(pickaxeOnly())
				.loot((lt, b) -> lt.addDrop(b,
						RegistrateBlockLootTables.dropsWithSilkTouch(b,
								lt.applyExplosionDecay(b, ItemEntry.builder(AllItems.RAW_ZINC.get())
										.apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))))))
				.tag(BlockTags.NEEDS_IRON_TOOL)
				.tag(Tags.Blocks.ORES)
				.transform(tagBlockAndItem("zinc_ores", "ores_in_ground/stone"))
				.tag(Tags.Items.ORES)
				.build()
				.register();
	}

	public static void register() {
		ItemGroupEvents.modifyEntriesEvent(AllCreativeModeTabs.PALETTES_CREATIVE_TAB.key()).register((entries) -> entries.addAfter(AllBlocks.DEEPSLATE_ZINC_ORE, new BlockEntry[]{GRANITE_ZINC_ORE, DIORITE_ZINC_ORE, ANDESITE_ZINC_ORE, TUFF_ZINC_ORE, CALCITE_ZINC_ORE}));
	}
}
