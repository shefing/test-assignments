package calculator;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
	
	@CustomCacheable(cacheName = "dataCache")
	public  String calculate(Operand op) {
		String operator = op.getOperator();
		int left = op.getLeft();
		int right = op.getRight();
		switch (operator) {
		case "plus":
			return String.format("%d+%d=%d", left, right, left+right);
		case "minus":
			return String.format("%d-%d=%d", left, right, left-right);
		case "multiply":
			return String.format("%d*%d=%d", left, right, left*right);
		case "divide":
			return String.format("%d/%d=%d", left, right, left/right);
		default:
			return "Invalid operator";
		}
	}
}
