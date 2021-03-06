package acube.pack;

final class CoderOrdered extends Coder {
  @Override
  public int size(final int n, final int k) { // n! / (n - k)!
    int x = 1;
    for (int i = n, j = k; j > 0; i--, j--)
      x *= i;
    return x;
  }

  @Override
  public int encode(final int[] values) {
    return Coder.unordered.encode(values) * CoderTools.usedPermutationSize(values) +
        CoderTools.encodeUsedPermutation(values);
  }

  @Override
  public void decode(final int[] arr, final int k, final int x) {
    Coder.unordered.decode(arr, k, x / CoderTools.permutationSize(k));
    CoderTools.decodePermutationToUsed(arr, x % CoderTools.permutationSize(k));
  }

  @Override
  public String toString(final int[] values) {
    if (values.length == 0)
      return "";
    final StringBuilder s = new StringBuilder();
    for (final int value : values)
      s.append(' ').append(value >= 0 ? "" + value : value == -1 ? "." : "?");
    return s.substring(1);
  }
}
