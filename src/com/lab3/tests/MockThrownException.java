/**
 * Created by francistoupin on 15-03-16.
 */
public class MockThrownException extends RuntimeException {
    private Exception exception;

    public MockThrownException(Exception exception){
        this.exception = exception;
    }

    public Exception getInnerException() {
        return exception;
    }
}
