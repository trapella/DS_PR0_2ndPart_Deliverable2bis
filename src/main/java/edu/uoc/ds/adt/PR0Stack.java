package edu.uoc.ds.adt;


import edu.uoc.ds.adt.sequential.Stack;
import edu.uoc.ds.adt.sequential.StackArrayImpl;

// Import 2 additional required libraries:
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PR0Stack {
    public final int CAPACITY = 10;

    //private Stack<Character> stack;
    private Stack<LocalDate> stack; // Using LocalDate instead of Character

    public PR0Stack() {
        newStack();
    }

    //public void newStack() {stack = new StackArrayImpl<Character>(CAPACITY);}

    /* Here, ABOVE, it was explicitly specified that the implementation of StackArrayImpl should
      of using Character as a generic type.

      Here UNDER, the generic type is not explicitly specified when the new instance is created
      of StackArrayImpl, but Java uses the "type inference" <> (Diamond operator <>)
      to determine the generic type to use based on the type of the stack attribute:
     */
    public void newStack() {stack = new StackArrayImpl<>(CAPACITY);}

    public String clearAllStack() {
        StringBuilder sb = new StringBuilder();
        /// Set the date in the date format that is requested to be entered in the statement:
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        /*
        while (!stack.isEmpty())
            sb.append(stack.pop()).append(" ");
        return sb.toString();
         */

        // We ensure the correct formatting of the date, extracting them from the stack,
        // format them, and add them to sb:
        while (!stack.isEmpty())
            sb.append(stack.pop().format(formatter)).append(" ");
        // Return the string, and use trim() to avoid extra spaces at the end:
        return sb.toString().trim();

    }

    //public Stack<Character> getStack()
    public Stack<LocalDate> getStack(){
        return this.stack;
    }

    /*
    public void push(Character c) {
        this.stack.push(c);
    }
     */

    public void push(LocalDate date) {
        // We add (push) a new date to the stack:
        this.stack.push(date);
    }
}
