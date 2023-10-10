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

public class PR0QueueTest {

    PR0Queue pr0q;


    private void fillQueue() {
        /*for (char c = '0'; c < '9'; c++) {
            pr0q.add(Character.valueOf(c));

        }*/

        // We create the initial date and add 10 dates, each with an interval of 2 days from the previous one:
        LocalDate startDate = LocalDate.of(2023, 9, 28);
        for (int i = 0; i < pr0q.CAPACITY; i++) {
            pr0q.add(startDate.plusDays(i * 2));
        }
    }
    @Before
    public void setUp() {
        this.pr0q = new PR0Queue();

        // Here we verify that the queue was created correctly:
        assertNotNull(this.pr0q.getQueue());
        fillQueue();
    }

    @After
    public void release() {
        // Release the reference to the object:
        this.pr0q = null;
    }


    @org.junit.Test
    public void queueTest() {
        //assertEquals(this.pr0q.CAPACITY-1, this.pr0q.getQueue().size());
        // Check that the queue has been filled correctly:
        assertEquals(this.pr0q.CAPACITY, this.pr0q.getQueue().size());

        //assertEquals(this.pr0q.clearFullQueue(), new String("0 1 2 3 4 5 6 7 8 "));

        // Check that the dates are extracted and formatted correctly when removed from the queue with clearFullQueue():
        assertEquals(this.pr0q.clearFullQueue(),"2023-09-28 2023-09-30 2023-10-02 2023-10-04 2023-10-06 2023-10-08 2023-10-10 2023-10-12 2023-10-14 2023-10-16");

        /// Check that the queue is empty:
        assertEquals(0, this.pr0q.getQueue().size());
    }

}
