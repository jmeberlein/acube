package acube.transform;

import static acube.Turn.B1;
import static acube.Turn.B2;
import static acube.Turn.B3;
import static acube.Turn.D1;
import static acube.Turn.D2;
import static acube.Turn.D3;
import static acube.Turn.E1;
import static acube.Turn.E2;
import static acube.Turn.E3;
import static acube.Turn.F1;
import static acube.Turn.F2;
import static acube.Turn.F3;
import static acube.Turn.L1;
import static acube.Turn.L2;
import static acube.Turn.L3;
import static acube.Turn.M1;
import static acube.Turn.M2;
import static acube.Turn.M3;
import static acube.Turn.R1;
import static acube.Turn.R2;
import static acube.Turn.R3;
import static acube.Turn.S1;
import static acube.Turn.S2;
import static acube.Turn.S3;
import static acube.Turn.U1;
import static acube.Turn.U2;
import static acube.Turn.U3;
import static acube.Turn.b1;
import static acube.Turn.b2;
import static acube.Turn.b3;
import static acube.Turn.d1;
import static acube.Turn.d2;
import static acube.Turn.d3;
import static acube.Turn.e1;
import static acube.Turn.e2;
import static acube.Turn.e3;
import static acube.Turn.f1;
import static acube.Turn.f2;
import static acube.Turn.f3;
import static acube.Turn.l1;
import static acube.Turn.l2;
import static acube.Turn.l3;
import static acube.Turn.m1;
import static acube.Turn.m2;
import static acube.Turn.m3;
import static acube.Turn.r1;
import static acube.Turn.r2;
import static acube.Turn.r3;
import static acube.Turn.s1;
import static acube.Turn.s2;
import static acube.Turn.s3;
import static acube.Turn.u1;
import static acube.Turn.u2;
import static acube.Turn.u3;
import java.util.Arrays;
import acube.Edge;
import acube.Turn;

public final class MoveKit {
  private static final Turn[][] TurnBase = {//
      { U1, U1 }, { D1, D1 }, { F1, F1 }, { B1, B1 }, { L1, L1 }, { R1, R1 },/**/
      { U2, U1, U1 }, { D2, D1, D1 }, { F2, F1, F1 }, { B2, B1, B1 }, { L2, L1, L1 }, { R2, R1, R1 },/**/
      { U3, U1, U1, U1 }, { D3, D1, D1, D1 }, { F3, F1, F1, F1 },/**/
      { B3, B1, B1, B1 }, { L3, L1, L1, L1 }, { R3, R1, R1, R1 },/**/
      { E1, U1, D1, D1, D1 }, { E2, U1, U1, D1, D1 }, { E3, U1, U1, U1, D1 },/**/
      { S1, B1, F1, F1, F1 }, { S2, B1, B1, F1, F1 }, { S3, B1, B1, B1, F1 },/**/
      { M1, R1, L1, L1, L1 }, { M2, R1, R1, L1, L1 }, { M3, R1, R1, R1, L1 },/**/
      { e1 } };
  private static final Turn[][] TurnBaseB = {//
      { U1, U1 }, { D1, D1 }, { U2, U1, U1 }, { D2, D1, D1 }, { U3, U1, U1, U1 }, { D3, D1, D1, D1 },/**/
      { F2, F2 }, { B2, B2 }, { L2, L2 }, { R2, R2 },/**/
      { E1, U1, D1, D1, D1 }, { E2, U1, U1, D1, D1 }, { E3, U1, U1, U1, D1 }, /**/
      { S2, B2, F2 }, { M2, R2, L2 }, { e1 } };
  private static final Turn[][] Identities = {//
      { U1, d1 }, { U2, d2 }, { U3, d3 }, { D1, u1 }, { D2, u2 }, { D3, u3 },/**/
      { F1, b1 }, { F2, b2 }, { F3, b3 }, { B1, f1 }, { B2, f2 }, { B3, f3 },/**/
      { L1, r1 }, { L2, r2 }, { L3, r3 }, { R1, l1 }, { R2, l2 }, { R3, l3 },/**/
      { e1, e2, e3, s1, s2, s3, m1, m2, m3 } };

  public static TurnTable twist(final Twist twist) {
    return MoveTable.instance(twist, TurnBase, Identities);
  }

  public static TurnTable flip(final Flip flip) {
    return MoveTable.instance(flip, TurnBase, Identities);
  }

  public static TurnTable cornerPos(final CornerPos cornerPos) {
    return MoveTable.instance(cornerPos, TurnBase, Identities);
  }

  public static TurnTable mEdgePos(final MEdgePos mEdgePos) {
    return MoveTable.instance(mEdgePos, TurnBase, Identities);
  }

  public static TurnTable uEdgePos(final UEdgePos uEdgePos) {
    return MoveTable.instance(uEdgePos, TurnBase, Identities);
  }

  public static TurnTable dEdgePos(final DEdgePos dEdgePos) {
    return MoveTable.instance(dEdgePos, TurnBase, Identities);
  }

  public static TurnTable mEdgePosSet(final MEdgePosSet mEdgePosSet) {
    return MoveTable.instance(mEdgePosSet, TurnBase, Identities);
  }

  public static TurnTable mEdgePosB(final MEdgePosB mEdgePosB) {
    return MoveTable.instance(mEdgePosB, TurnBaseB, Identities);
  }

  public static TurnTable udEdgePosB(final UDEdgePosB udEdgePosB) {
    return MoveTable.instance(udEdgePosB, TurnBaseB, Identities);
  }

  public static boolean[] get_mEdgePos_inB(final MEdgePos mEdgePos) {
    return get_edgePos_inB(mEdgePos);
  }

  public static boolean[] get_uEdgePos_inB(final UEdgePos uEdgePos) {
    return get_edgePos_inB(uEdgePos);
  }

  public static boolean[] get_dEdgePos_inB(final DEdgePos dEdgePos) {
    return get_edgePos_inB(dEdgePos);
  }

  private static boolean[] get_edgePos_inB(final MoveToB<Edge> edgePos) {
    final boolean[] t = new boolean[edgePos.stateSize()];
    for (int i = 0; i < t.length; i++) {
      edgePos.unpack(i);
      t[i] = edgePos.isInB();
    }
    return t;
  }

  public static int[] get_mEdgePos_to_mEdgePosB(final MEdgePos mEdgePos, final MEdgePosB mEdgePosB) {
    return get_edgePos_to_edgePosB(mEdgePos, mEdgePosB);
  }

  public static int[] get_uEdgePos_to_uEdgePosB(final UEdgePos uEdgePos, final UEdgePosB uEdgePosB) {
    return get_edgePos_to_edgePosB(uEdgePos, uEdgePosB);
  }

  public static int[] get_dEdgePos_to_dEdgePosB(final DEdgePos dEdgePos, final DEdgePosB dEdgePosB) {
    return get_edgePos_to_edgePosB(dEdgePos, dEdgePosB);
  }

  private static int[] get_edgePos_to_edgePosB(final MoveToB<Edge> edgePos, final Move<Edge> edgePosB) {
    final int[] t = new int[edgePos.stateSize()];
    Arrays.fill(t, -1);
    for (int i = 0; i < t.length; i++) {
      edgePos.unpack(i);
      if (edgePos.isInB())
        t[i] = edgePosB.convertFrom(edgePos);
    }
    return t;
  }

  public static int[][] get_uEdgePosB_dEdgePosB_to_udEdgePosB(final UEdgePosB uEdgePosB, final DEdgePosB dEdgePosB,
      final UDEdgePosB udEdgePosB) {
    final int[][] t = new int[uEdgePosB.stateSize()][dEdgePosB.stateSize()];
    for (int i = 0; i < t.length; i++) {
      Arrays.fill(t[i], (short)-1);
      uEdgePosB.unpack(i);
      for (int j = 0; j < t[i].length; j++) {
        dEdgePosB.unpack(j);
        t[i][j] = udEdgePosB.convertFrom(uEdgePosB, dEdgePosB);
      }
    }
    return t;
  }

  public static int[] get_mEdgePos_to_mEdgePosSet(final MEdgePos mEdgePos, final MEdgePosSet mEdgePosSet) {
    final int[] t = new int[mEdgePos.stateSize()];
    for (int i = 0; i < t.length; i++) {
      mEdgePos.unpack(i);
      t[i] = mEdgePosSet.convertFrom(mEdgePos);
    }
    return t;
  }
}
