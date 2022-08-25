package mymath

import org.junit.jupiter.api.Test

class PrimeNumbersSeqTest extends GroovyTestCase {
    @Test
    void primeNumberSeqTest() {
        assert 11 == new PrimeNumbersSeq().find { it > 10 }
        assert 97 == new PrimeNumbersSeq().find { it > 89 }
        assert 97 == new PrimeNumbersSeq().find { it >= 97 } // demo checking if 97 is prime
        assert 4 < new PrimeNumbersSeq().find { it >= 4 } // demo checking if 2 is not prime
        def sequence = new PrimeNumbersSeq()
        def acc = accFactory([])
        for (def prime in sequence) {
            def primes = acc(prime)
            if (prime % 13 == 1) {
                assert 'Не получается, что первое простое число вида 13*n+1 = 53', 53 == prime
                assert primes == [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53]
                break
            }
        }
    }

    @Test
    void primeNTest() {
        assert 2 == PrimeNumbersSeq.primeN(1)
        assert 7 == PrimeNumbersSeq.primeN(4)
    }

    @Test
    void isPrimeTest() {
        assert PrimeNumbersSeq.isPrime(2)
        assert !PrimeNumbersSeq.isPrime(0)
        assert !PrimeNumbersSeq.isPrime(1)
        assert !PrimeNumbersSeq.isPrime(-1)
        assert !PrimeNumbersSeq.isPrime(-2)
        assert PrimeNumbersSeq.isPrime(11)
        assert !PrimeNumbersSeq.isPrime(10)
    }

    private accFactory(a) {
        return {a << it}
    }
}
