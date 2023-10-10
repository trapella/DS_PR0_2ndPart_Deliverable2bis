package edu.uoc.ds.adt;


import edu.uoc.ds.adt.sequential.Queue;
import edu.uoc.ds.adt.sequential.QueueArrayImpl;

// Import 2 additional required libraries:
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PR0Queue {

    public final int CAPACITY = 10;

    //private Queue<Character> queue;
    private Queue<LocalDate> queue;     // Change the type from Character to LocalDate.


    public PR0Queue() {
        newQueue();
    }
    public void newQueue() {
        // Create a new queue with a specified capacity:
        queue = new QueueArrayImpl<>(CAPACITY);
    }


    public String clearFullQueue() {
        StringBuilder sb = new StringBuilder();
        //char r;

        // Set the date in the date format that is requested to be entered in the statement:
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Here, as long as the queue is not empty, we extract (poll) and format each date (format), appending it (append) to the StringBuilder sb:
        while (!queue.isEmpty()) {
            //sb.append(queue.poll()).append(" ");
            // We use "formatter" to convert the date to String with the desired format given earlier with "ofPattern":
            sb.append(queue.poll().format(formatter)).append(" ");
        }
        //return sb.toString();
        // Return the resulting string (toString) with the extracted and formatted dates, removing extra spaces at the end of the string (trim):
        return sb.toString().trim();

    }

    //public Queue<Character> getQueue()
    public Queue<LocalDate> getQueue(){
        return this.queue;
    }

    //public void add(Character c){
    // this.queue.add(c);
    // }
    public void add(LocalDate date){
        // Add a new date to the queue:
        this.queue.add(date);
    }
}
