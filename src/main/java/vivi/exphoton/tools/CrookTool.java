package vivi.exphoton.tools;

import net.minecraft.block.BlockState;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import vivi.exphoton.registry.ExPhotonRegistry;

public class CrookTool extends MiningToolItem {
    public CrookTool(ToolMaterial material, Settings settings) {
        super(0, -2f, material, null, settings);
    }

    public ToolMaterial material;

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        if(isEffectiveOn(state)) return 3.0f;
        else return 1f;
    }

    public static boolean isCrook(String tk) {
        switch(tk) {
            case "item.photon.crook":
            case "item.photon.bone_crook":
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean isEffectiveOn(BlockState state) {
        return ExPhotonRegistry.CROOK.isRegistered(state.getBlock().asItem());
    }

    @Override
    public boolean damage(DamageSource source) {
        return true;
    }

    @Override
    public boolean isDamageable() {
        return true;
    }
}
