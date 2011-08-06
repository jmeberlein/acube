package acube.transform;

import acube.Edge;
import acube.Turn;
import acube.pack.PackKit;

final class MEdgePosition extends MoveToB {
  public MEdgePosition(final Edge[] mask, final Turn[] turns) {
    super(PackKit.mEdgePosition(mask), turns);
  }

  @Override
  public void turn(final Turn turn) {
    cycleEdges(turn);
  }

  @Override
  public boolean isInB() {
    return areUsedIn(PackKit.mEdgeMaskInB);
  }
}
