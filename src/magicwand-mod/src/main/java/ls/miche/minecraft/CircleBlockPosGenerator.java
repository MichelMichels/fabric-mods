package ls.miche.minecraft;

import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;
import java.util.List;

public class CircleBlockPosGenerator {
    public List<BlockPos> generateBlockPositions(int centerX, int centerY, int centerZ, final int radius) {
        ArrayList<BlockPos> positions = new ArrayList<>();

        int d = (5 - radius * 4)/4;
        int x = 0;
        int z = radius;

        do {
            positions.add(new BlockPos(centerX + x, centerY, centerZ + z));
            positions.add(new BlockPos(centerX + x, centerY, centerZ - z));
            positions.add(new BlockPos(centerX - x, centerY, centerZ + z));
            positions.add(new BlockPos(centerX - x, centerY, centerZ - z));
            positions.add(new BlockPos(centerX + z, centerY, centerZ + x));
            positions.add(new BlockPos(centerX + z, centerY, centerZ - x));
            positions.add(new BlockPos(centerX - z, centerY, centerZ + x));
            positions.add(new BlockPos(centerX - z, centerY, centerZ - x));

            if (d < 0) {
                d += 2 * x + 1;
            } else {
                d += 2 * (x - z) + 1;
                z--;
            }
            x++;
        } while (x <= z);

        return positions;
    }
}
