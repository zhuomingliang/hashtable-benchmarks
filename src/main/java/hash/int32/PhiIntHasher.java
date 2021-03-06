package hash.int32;

/**
 * Multiply by the golden ratio and mix high bits into low bits.
 * Based on <a href="https://raw.githubusercontent.com/vigna/fastutil/master/src/it/unimi/dsi/fastutil/HashCommon.java">https://raw.githubusercontent.com/vigna/fastutil/master/src/it/unimi/dsi/fastutil/HashCommon.java</a>.
 *
 * @author tdbaker
 */
public class PhiIntHasher implements IntHasher {
    public static final String NAME = "hash.int32.PhiIntHasher";
    
    private static final int INT_PHI = 0x9e3779b9;
    private static final int INV_INT_PHI = 0x144cbc89;

    @Override
    public int hash(int x) {
        if (x == 0) {
            throw new IllegalArgumentException("Hashing 0 is a no-op");
        }
        x *= INT_PHI;
        x ^= x >>> 16;
        return x;
    }

    @Override
    public int unhash(int x) {
        if (x == 0) {
            throw new IllegalArgumentException("Hashing 0 is a no-op");
        }
        x ^= x >>> 16;
        x *= INV_INT_PHI;
        return x;
    }

    @Override
    public IntHasher cloneHasher() {
        // stateless
        return new PhiIntHasher();
    }
}
