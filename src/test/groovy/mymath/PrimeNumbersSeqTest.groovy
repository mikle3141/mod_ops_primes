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
        for (def prime in sequence) {
            if (prime % 13 == 1) {
                assert 'Не получается, что первое простое число вида 13*n+1 = 53', 53 == prime
                break
            }
        }
    }

    @Test
    void primeNTest() {
        assert 2 == PrimeNumbersSeq.primeN(1)
        assert 7 == PrimeNumbersSeq.primeN(4)
    }
}
