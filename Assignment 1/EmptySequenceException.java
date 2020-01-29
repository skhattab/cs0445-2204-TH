
/** A runtime exception that signals the Sequence<T> object is empty
 * @author Sherif Khattab
 *
 */
public class EmptySequenceException extends RuntimeException {

	private static final long serialVersionUID = 575262834263843711L;

	public EmptySequenceException(String reason) {
		super(reason);
	}
}
