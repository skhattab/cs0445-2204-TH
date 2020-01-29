/** ReorderInterface interface for CS 0445 Assignment 1
 * @author Sherif Khattab (Adapted  from Dr. John Ramirez's Spring 2017 CS 0445 Assignment 1 code)
 * Carefully read the specifications for the methods below and
 * implement them in your ArrayDS<T> class.  As with the Sequence<T>
 * interface, don't worry as much about efficiency here as you do
 * about correctness.
 */
public interface ReorderInterface
{
	/** Logically reverse the data in the ReorderInterface object so that the item
	 * that was logically first will now be logically last and vice
	 * versa.  The physical implementation of this can be done in
	 * many different ways, depending upon how you actually implemented
	 * your physical ArrayDS<T> class
	 */
	public void reverse();

	/** Remove the logically last item and put it at the
	 * front.  As with reverse(), this can be done physically in
	 * different ways depending on the underlying implementation.
	 */
	public void rotateRight();

	/** Remove the logically first item and put it at the
	 * end.  As above, this can be done in different ways.
	 */
	public void rotateLeft();
}
