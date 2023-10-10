package edu.uoc.ds.adt;

import org.junit.After;
import org.junit.Before;

// Compare an expected result with the obtained result. If they are equal, the test passes.
// If they are different, the test fails:
import static org.junit.Assert.assertEquals;
// Ensures that the current value is non-null:
import static org.junit.Assert.assertNotNull;

// Import 1 additional required library:
import java.time.LocalDate;


public class PR0StackTest {

    PR0Stack pr0q;

    /*
    private void fillStack() {
        for (char c = '0'; c < '9'; c++) {
            pr0q.push(Character.valueOf(c));
        }
    }
     */

    private void fillStack() {
        // Set the start date:
        LocalDate startDate = LocalDate.of(2023, 9, 28);
        // Add 10 dates with an interval of 2 days.
        // (They are 10 because this is how it was defined in the PR0Stack.java file):
        for (int i = 0; i < pr0q.CAPACITY; i++) {
            pr0q.push(startDate.plusDays(i * 2));
        }
    }

    @Before
    public void setUp() {
        // Initialize the object:
        this.pr0q = new PR0Stack();

        assertNotNull(this.pr0q.getStack());
        this.fillStack();

    }

    @After
    public void release() {
        this.pr0q = null;
    }


    @org.junit.Test
    public void stackTest() {

        //assertEquals(this.pr0q.CAPACITY-1, this.pr0q.getStack().size());
        assertEquals(this.pr0q.CAPACITY, this.pr0q.getStack().size());

        // Make sure the extracted dates are in the correct format and order:
        assertEquals(this.pr0q.clearAllStack(), "2023-10-16 2023-10-14 2023-10-12 2023-10-10 2023-10-08 2023-10-06 2023-10-04 2023-10-02 2023-09-30 2023-09-28");

        assertEquals(0, this.pr0q.getStack().size());
    }
}
