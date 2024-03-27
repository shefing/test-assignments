package calculator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CalculatorExceptionHandler {
	@ExceptionHandler(ServletRequestBindingException.class)
    public ResponseEntity<String> handleHeaderException(Exception ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An error occurred: " + ex.getLocalizedMessage());
    }
	@ExceptionHandler(Exception.class)
	  public final ResponseEntity<String> handleAllExceptions(Exception ex, WebRequest request) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + ex.getLocalizedMessage());
	  }
}
