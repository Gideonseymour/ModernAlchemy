package com.dyonovan.modernalchemy.common.tileentity.arcfurnace.dummies;

import com.dyonovan.modernalchemy.handlers.BlockHandler;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

public class TileDummyAirValve extends TileDummy implements IFluidHandler {

    @Override
    public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
        if(getCore() != null)
            return resource.getFluid() == BlockHandler.fluidCompressedAir ? getCore().fill(ForgeDirection.NORTH, resource, doFill) : 0;
        else
            return 0;
    }

    @Override
    public boolean canFill(ForgeDirection from, Fluid fluid) {
        if(getCore() != null)
            return getCore().canFill(from, fluid);
        else
            return false;
    }

    @Override
    public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
        return null;
    }

    @Override
    public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
        return null;
    }

    @Override
    public boolean canDrain(ForgeDirection from, Fluid fluid) {
        return false;
    }

    @Override
    public FluidTankInfo[] getTankInfo(ForgeDirection from) {
        return getCore() != null ? new FluidTankInfo[] { getCore().airTank.getInfo() } : new FluidTankInfo[0];
    }

    @Override
    public void updateEntity() {
        super.updateEntity();
        if(getCore() != null) {
            getCore().airTank.fillFromSides(50, worldObj, getPosition());
        }
    }
}
