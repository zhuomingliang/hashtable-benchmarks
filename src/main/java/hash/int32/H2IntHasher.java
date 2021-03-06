package hash.int32;

/**
 * Implements hash function from <a href="https://github.com/h2database/h2database">https://github.com/h2database/h2database</a>.
 *
 * @author tdbaker
 */
public class H2IntHasher implements IntHasher {
    public static final String NAME = "hash.int32.H2IntHasher";
    @Override
    public int hash(int x) {
        if (x == 0) {
            throw new IllegalArgumentException("Hashing 0 is a no-op");
        }
        x ^= x >>> 16;
        x *= 0x45d9f3b;
        x ^= x >>> 16;
        x *= 0x45d9f3b;
        x ^= x >>> 16;
        return x;
    }

    @Override
    public int unhash(int x) {
        if (x == 0) {
            throw new IllegalArgumentException("Hashing 0 is a no-op");
        }
        x ^= x >>> 16;
        x *= 0x119de1f3;
        x ^= x >>> 16;
        x *= 0x119de1f3;
        x ^= x >>> 16;
        return x;
    }

    @Override
    public IntHasher cloneHasher() {
        // stateless
        return new H2IntHasher();
    }
}
