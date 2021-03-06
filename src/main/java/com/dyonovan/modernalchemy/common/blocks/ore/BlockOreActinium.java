package com.dyonovan.modernalchemy.common.blocks.ore;

import com.dyonovan.modernalchemy.common.blocks.BlockModernAlchemy;
import com.dyonovan.modernalchemy.handlers.ItemHandler;
import com.dyonovan.modernalchemy.lib.Constants;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import openmods.infobook.BookDocumentation;

import java.util.Random;
@BookDocumentation
public class BlockOreActinium extends BlockModernAlchemy {

    public BlockOreActinium() {
        super(Material.rock);
        this.setHardness(2.0F);
        this.setHarvestLevel("pickaxe", 3);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {
        this.blockIcon = register.registerIcon(Constants.MODID + ":actinium");
    }

    @Override
    public int quantityDropped(Random random)
    {
        return 0;
    }

    @Override
    public Item getItemDropped(int meta, Random random, int fortune) {
        return ItemHandler.itemActiniumDust;
    }

    @Override
    public int damageDropped(int metadata) {
        return 0;
    }

    @Override
    public int quantityDropped(int meta, int fortune, Random random) {
        return 1;
    }
}
