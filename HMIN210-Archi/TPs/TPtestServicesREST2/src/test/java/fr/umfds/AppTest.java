package fr.umfds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class AppTest {
    BrainstormDB db;

    @BeforeEach
    public void init() {
        System.out.println("init");
        db = Mockito.mock(BrainstormDB.class);
    }

    @Test
    public void TestBrainstormNotEmpty() {
        System.out.println("TestBrainstormNotEmpty");
        BrainstormResource br = new BrainstormResource();
        ArrayList<Brainstorm> expected = new ArrayList<>(Arrays.asList(
                new Brainstorm(1, "bs1", new ArrayList<>()),
                new Brainstorm(2, "bs2", new ArrayList<>()),
                new Brainstorm(3, "bs3", new ArrayList<>())
        ));
        Assertions.assertEquals(expected.size(), br.getBrainstorms().size());
        Assertions.assertTrue(br.getBrainstorms().size() > 0);
    }

    @Test
    public void TestBrainstormIsSorted() {
        System.out.println("TestBrainstormIsSorted");
        // Given
        BrainstormResource br = new BrainstormResource();
        MockedStatic<BrainstormDB> bdbMock = Mockito.mockStatic(BrainstormDB.class);
        ArrayList<Brainstorm> expected = new ArrayList<>(Arrays.asList(
                new Brainstorm(1, "bs1", new ArrayList<>()),
                new Brainstorm(2, "bs2", new ArrayList<>()),
                new Brainstorm(3, "bs3", new ArrayList<>())
        ));
        // When
        bdbMock.when(BrainstormDB::getBrainstorms).thenReturn(expected);
        // Then
        ArrayList<Brainstorm> actual = br.getBrainstorms();
        Assertions.assertTrue(isSorted(actual, Brainstorm::compareTo));
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
