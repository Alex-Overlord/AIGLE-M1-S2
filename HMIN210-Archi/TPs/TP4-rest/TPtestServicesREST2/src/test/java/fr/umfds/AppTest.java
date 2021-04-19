package fr.umfds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    private Brainstorm b1, b2, b3;
    private BrainstormDB brainstormDB;
    @Mock private BrainstormDB brainstormDBMock;
    private BrainstormResource brainstormResource;

    @BeforeEach
    public void init() {
        System.out.println("init");
        this.b1 = new Brainstorm(1, "AAA", new ArrayList<>());
        this.b2 = new Brainstorm(2, "BBB", new ArrayList<>());
        this.b3 = new Brainstorm(3, "CCC", new ArrayList<>());

        this.brainstormDB = new BrainstormDB();
        this.brainstormResource = new BrainstormResource(this.brainstormDB);

        brainstormDBMock = Mockito.mock(BrainstormDB.class);
    }

    @Test
    public void TestBrainstormNotEmpty() {
        System.out.println("TestBrainstormNotEmpty");
        // Given
        int expected = 3;

        // When

        // Then
        assertAll(
                () -> assertEquals(expected, this.brainstormResource.getBrainstorms().size()),
                () -> assertTrue(this.brainstormResource.getBrainstorms().size() > 0)
        );

    }

    @Test
    public void TestBrainstormIsSorted() {
        System.out.println("TestBrainstormIsSorted");
        // Given
        ArrayList<Brainstorm> expectedSorted = new ArrayList<>(Arrays.asList(this.b1, this.b2, this.b3));
        ArrayList<Brainstorm> unsorted = new ArrayList<>(Arrays.asList(this.b3, this.b1, this.b2));
        MockedStatic<BrainstormDB> db = Mockito.mockStatic(BrainstormDB.class);

        // When
        db.when(BrainstormDB::getBrainstorms).thenReturn(unsorted);
        ArrayList<Brainstorm> actual = this.brainstormResource.getBrainstorms();

        // Then
        assertAll(
                () -> assertEquals(expectedSorted.size(), actual.size()),
                () -> assertArrayEquals(expectedSorted.toArray(), actual.toArray())
        );
    }

    @Test
    public void TestBrainstormIsSorted2() {
        System.out.println("TestBrainstormIsSorted2");
        // Given
        ArrayList<Brainstorm> expectedSorted = new ArrayList<>(Arrays.asList(this.b1, this.b2, this.b3));
        ArrayList<Brainstorm> unsorted = new ArrayList<>(Arrays.asList(this.b2, this.b1, this.b3));
        this.brainstormResource.setBrainstormDB(this.brainstormDBMock);

        // When
        Mockito.when(this.brainstormDBMock.getBrainstorms2()).thenReturn(unsorted);
        ArrayList<Brainstorm> actual = this.brainstormResource.getBrainstorms();

        // Then
        assertAll(
                () -> assertEquals(expectedSorted.size(), actual.size())
        );
    }

    public static boolean isSorted(ArrayList<Brainstorm> br, Comparator<Brainstorm> brComparator) {
        if (br.isEmpty() || br.size() == 1) {
            return true;
        }
        Iterator<Brainstorm> iter = br.iterator();
        Brainstorm current, previous = iter.next();
        while (iter.hasNext()) {
            current = iter.next();
            if (brComparator.compare(previous, current) > 0) {
                return false;
            }
            previous = current;
        }
        return true;
    }
}
