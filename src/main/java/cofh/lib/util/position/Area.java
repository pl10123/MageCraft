package cofh.lib.util.position;

import net.minecraft.util.AxisAlignedBB;

import java.util.ArrayList;
import java.util.List;

public class Area {

	public int xMin;
	public int xMax;
	public int yMin;
	public int yMax;
	public int zMin;
	public int zMax;

	private BlockPosition origin;

	public Area(int xMin, int xMax, int yMin, int yMax, int zMin, int zMax) {

		this.xMin = xMin;
		this.xMax = xMax;
		this.yMin = yMin;
		this.yMax = yMax;
		this.zMin = zMin;
		this.zMax = zMax;
	}

	public Area(BlockPosition center, int radius, int yNegOffset, int yPosOffset) {

		xMin = center.x - radius;
		xMax = center.x + radius;
		yMin = center.y - yNegOffset;
		yMax = center.y + yPosOffset;
		zMin = center.z - radius;
		zMax = center.z + radius;

		origin = center;
	}

	public BlockPosition getMin() {

		return new BlockPosition(xMin, yMin, zMin);
	}

	public BlockPosition getMax() {

		return new BlockPosition(xMax, yMax, zMax);
	}

	public boolean contains(BlockPosition pos) {

		return pos.x >= xMin & pos.x <= xMax & pos.y >= yMin & pos.y <= yMax & pos.z >= zMin & pos.z <= zMax;
	}

	public List<BlockPosition> getPositionsTopFirst() {

		ArrayList<BlockPosition> positions = new ArrayList<BlockPosition>();
		for (int y = yMax; y >= yMin; y--) {
			for (int x = xMin; x <= xMax; x++) {
				for (int z = zMin; z <= zMax; z++) {
					positions.add(new BlockPosition(x, y, z));
				}
			}
		}
		return positions;
	}

	public List<BlockPosition> getPositionsBottomFirst() {

		ArrayList<BlockPosition> positions = new ArrayList<BlockPosition>();
		for (int y = yMin; y <= yMax; y++) {
			for (int x = xMin; x <= xMax; x++) {
				for (int z = zMin; z <= zMax; z++) {
					positions.add(new BlockPosition(x, y, z));
				}
			}
		}
		return positions;
	}

	public BlockPosition getOrigin() {

		return origin.copy();
	}

	public AxisAlignedBB toAxisAlignedBB() {

		return AxisAlignedBB.getBoundingBox(xMin, yMin, zMin, xMax + 1, yMax + 1, zMax + 1);
	}

}
