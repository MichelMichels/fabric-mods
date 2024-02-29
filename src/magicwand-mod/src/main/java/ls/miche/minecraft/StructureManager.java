package ls.miche.minecraft;

import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;
import java.util.List;

public class StructureManager {
    private static final List<List<BlockPos>> structures = new ArrayList<>();

    public void addStructure(List<BlockPos> structure)
    {
        structures.add(structure);
    }
    public List<BlockPos> getStructure(BlockPos position) {
        for(List<BlockPos> structure : structures) {
            for(BlockPos pos : structure) {
                if(pos.equals(position)) {
                    return structure;
                }
            }
        }

        return new ArrayList<>();
    }
}
