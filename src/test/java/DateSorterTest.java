import org.example.DateSorter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DateSorterTest {

    private List<LocalDate> unsortedDates;

    private DateSorter dateSorter;

    @BeforeEach
    public void setUp() {
        dateSorter = new DateSorter();
        unsortedDates = new ArrayList<>();
        unsortedDates.add(LocalDate.of(2004, 7, 1));
        unsortedDates.add(LocalDate.of(2005, 1, 2));
        unsortedDates.add(LocalDate.of(2007, 1, 1));
        unsortedDates.add(LocalDate.of(2032, 5, 3));
    }

    @Test
    public void testSortDatesWithLetterR() {
        Collection<LocalDate> datesWithLetterRInMonth = dateSorter.sortAndGetMonthWithLetterR(unsortedDates);
        assertEquals(datesWithLetterRInMonth, List.of(LocalDate.of(2005, 1, 2)
                , LocalDate.of(2007, 1, 1)));
    }

    @Test
    public void testSortDatesWithoutLetterR() {
        Collection<LocalDate> datesWithoutLetterRInMonth = dateSorter.sortAndGetMonthWithoutLetterR(unsortedDates);
        assertEquals(datesWithoutLetterRInMonth, List.of(LocalDate.of(2032, 5, 3),
                LocalDate.of(2004, 7, 1)));
    }

    @Test
    public void testSortDates() {
        Collection<LocalDate> sortedDates = dateSorter.sortDates(unsortedDates);
        assertEquals(sortedDates, List.of(LocalDate.of(2005, 1, 2),
                LocalDate.of(2007, 1, 1),
                LocalDate.of(2032, 5, 3),
                LocalDate.of(2004, 7, 1)));
    }
}
