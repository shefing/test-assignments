package calculator;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class CalculatorController {
	@Autowired
    private CalculatorService  myService;
	
	@PostMapping(
			  value = "/calculator")
			public String calculate(@RequestBody Operand op) {		
				return  myService.calculate(op);				
			}
}
