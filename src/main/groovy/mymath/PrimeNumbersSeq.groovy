package mymath
/*
 //Typical usage:
 def sequence = new PrimeNumbersSeq()
 for (def prime in sequence) {
  // do something with prime
 }
*/

/**
 * Good example of using:
 * assert 11 == new PrimeNumbersSeq().find{it > 10}
 */
class PrimeNumbersSeq implements Iterator, Iterable {
    static BigInteger primeN(int n) {
        if (n <= 0) throw new IllegalArgumentException('Number of prime number has to be 1 or greater!')
        def sequence = new PrimeNumbersSeq()
        int i = 0
        for (def prime in sequence) {
            if (++i == n) return prime as BigInteger
        }
    }

    private class Counter {
        public int counter
        public final int limit

        Counter(int limit, int start = 0) {
            this.limit = limit
            counter = start
        }

        boolean incr(int a = 1) {
            boolean ret = false
            counter += a
            if (counter >= limit) {
                if (counter == limit) ret = true
                counter -= limit
            }
            return ret
        }
    }

    boolean hasNext() { return true }

    void remove() {
        throw new UnsupportedOperationException()
    }
    private BigInteger current = 2g
    private counters = []

    BigInteger next() {
        BigInteger ret = current
        if (current == 2g) {
            current = 3g
            counters << new Counter(current as Integer)
        } else {
            current += 2g
        }
        if (ret >= 3g) while (true) {
            boolean found = false
            counters.each {
                if (it.incr(2)) found = true
            }
            if (found) {
                current += 2g
            } else {
                counters << new Counter(current as Integer)
                break
            }
        }
        return ret
    }

    Iterator iterator() { return this }
}