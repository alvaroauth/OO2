> **Se cuenta con las siguientes implementaciones de iteradores circulares, las cuales presentan implementaciones similares.**

>**CharRing.java**
```java
public class CharRing {
    private char[] source;
    private int idx;

    public CharRing(String src) {
        source = src.toCharArray();
        idx = 0;
    }

    public char next() {
        if (idx >= source.length)
            idx = 0;
        return source[idx++];
    }
}
```

>**IntRing.java**
```java
public class IntRing {
    private int[] source;
    private int idx;

    public IntRing(int[] src) {
        source = src;
        idx = 0;
    }

    public int next() {
        if (idx >= source.length)
            idx = 0;
        return source[idx++];
    }
}
```

>**Diseñe e implemente Test de Unidad para las clases CharRing e IntRing. Asegúrese de que los test pasen.**

>**IntRingTest.java**
```java
// src/test/java/IntRingTest.java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IntRingTest {

    private IntRing ring;

    @BeforeEach
    void setUp() {
        ring = new IntRing(new int[]{1, 2, 3});
    }

    @Test
    void testNextReturnsPrimeroElemento() {
        assertEquals(1, ring.next());
    }

    @Test
    void testNextRecorreElementosEnOrden() {
        assertEquals(1, ring.next());
        assertEquals(2, ring.next());
        assertEquals(3, ring.next());
    }

    @Test
    void testNextVuelveAlInicioAlLlegarAlFinal() {
        ring.next(); // 1
        ring.next(); // 2
        ring.next(); // 3
        assertEquals(1, ring.next());
    }

    @Test
    void testNextCiclaVariasVeces() {
        for (int i = 0; i < 6; i++) ring.next();
        assertEquals(1, ring.next());
    }

    @Test
    void testConUnSoloElementoSiempreRetornaElMismo() {
        IntRing single = new IntRing(new int[]{42});
        assertEquals(42, single.next());
        assertEquals(42, single.next());
        assertEquals(42, single.next());
    }

    @Test
    void testConDosElementosAlterna() {
        IntRing pair = new IntRing(new int[]{10, 20});
        assertEquals(10, pair.next());
        assertEquals(20, pair.next());
        assertEquals(10, pair.next());
        assertEquals(20, pair.next());
    }
}
```

>**CharRingTest.java**
```java
// src/test/java/CharRingTest.java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CharRingTest {

    private CharRing ring;

    @BeforeEach
    void setUp() {
        ring = new CharRing("ABC");
    }

    @Test
    void testNextReturnsPrimerCaracter() {
        assertEquals('A', ring.next());
    }

    @Test
    void testNextRecorreCaracteresEnOrden() {
        assertEquals('A', ring.next());
        assertEquals('B', ring.next());
        assertEquals('C', ring.next());
    }

    @Test
    void testNextVuelveAlInicioAlLlegarAlFinal() {
        ring.next(); // A
        ring.next(); // B
        ring.next(); // C
        assertEquals('A', ring.next()); // vuelve al inicio
    }

    @Test
    void testNextCiclaVariasVeces() {
        for (int i = 0; i < 6; i++) ring.next();
        assertEquals('A', ring.next()); // 7ma llamada → índice 0
    }

    @Test
    void testConUnSoloCaracterSiempreRetornaElMismo() {
        CharRing single = new CharRing("Z");
        assertEquals('Z', single.next());
        assertEquals('Z', single.next());
        assertEquals('Z', single.next());
    }

    @Test
    void testConDosCaracteresAlterna() {
        CharRing pair = new CharRing("XY");
        assertEquals('X', pair.next());
        assertEquals('Y', pair.next());
        assertEquals('X', pair.next());
        assertEquals('Y', pair.next());
    }

    @Test
    void testConStringConEspacios() {
        CharRing spaced = new CharRing("A B");
        assertEquals('A', spaced.next());
        assertEquals(' ', spaced.next());
        assertEquals('B', spaced.next());
        assertEquals('A', spaced.next());
    }
}
```

