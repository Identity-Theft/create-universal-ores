package identitytheft.createuniversalores.mixin;

import identitytheft.createuniversalores.util.OreUtil;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.List;

@Mixin(OreFeatureConfig.class)
public class OreFeatureMixin {
	@ModifyVariable(method = "<init>(Ljava/util/List;IF)V", at = @At("HEAD"), ordinal = 0, argsOnly = true)
	private static List<OreFeatureConfig.Target> modifyTargets(List<OreFeatureConfig.Target> targets) {
		var newTargets = OreUtil.getNewTargets(targets);
		if (newTargets != null) {
			return newTargets;
		}
		return targets;
	}
}
