package identitytheft.createuniversalores.util;

import com.google.common.collect.ImmutableList;
import com.simibubi.create.AllBlocks;
import identitytheft.createuniversalores.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import javax.annotation.Nullable;
import java.util.List;

public class OreUtil {
	public static final RuleTest ANDESITE_RULE = new BlockMatchRuleTest(Blocks.ANDESITE);
	public static final RuleTest DIORITE_RULE = new BlockMatchRuleTest(Blocks.DIORITE);
	public static final RuleTest GRANITE_RULE = new BlockMatchRuleTest(Blocks.GRANITE);
	public static final RuleTest TUFF_RULE = new BlockMatchRuleTest(Blocks.TUFF);
	public static final RuleTest CALCITE_RULE = new BlockMatchRuleTest(Blocks.CALCITE);

	private static final List<OreFeatureConfig.Target> ZINC_TARGETS = List.of(
			OreFeatureConfig.createTarget(ANDESITE_RULE, ModBlocks.ANDESITE_ZINC_ORE.getDefaultState()),
			OreFeatureConfig.createTarget(DIORITE_RULE, ModBlocks.DIORITE_ZINC_ORE.getDefaultState()),
			OreFeatureConfig.createTarget(GRANITE_RULE, ModBlocks.GRANITE_ZINC_ORE.getDefaultState()),
			OreFeatureConfig.createTarget(TUFF_RULE, ModBlocks.TUFF_ZINC_ORE.getDefaultState()),
			OreFeatureConfig.createTarget(CALCITE_RULE, ModBlocks.CALCITE_ZINC_ORE.getDefaultState())
	);

	@Nullable
	public static ImmutableList<OreFeatureConfig.Target> getNewTargets(List<OreFeatureConfig.Target> targets) {
		List<OreFeatureConfig.Target> newTargets = null;

		for (var target: targets) {
			if (target.state.getBlock() == AllBlocks.ZINC_ORE.get()) {
				newTargets = ZINC_TARGETS;
				break;
			}
		}

		if (newTargets == null) return null;

		var list = ImmutableList.<OreFeatureConfig.Target>builder().addAll(newTargets).addAll(targets);
		return list.build();
	}
}
