package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

class CalculatorTests {

	static String calculatorUrl = "http://localhost:8080/calculator";
	RestTemplate restTemplate = new RestTemplate();
	HttpHeaders headers = new HttpHeaders();

	@BeforeEach
	void setUp() throws Exception {
		headers.setContentType(MediaType.APPLICATION_JSON);
	}

	@Test
	void testAdd() {
		String inputJSON = "{\"operator\":\"plus\", \"left\": 5, \"right\": 3}";
		HttpEntity<String> request = new HttpEntity<String>(inputJSON, headers);

		String result = restTemplate.postForObject(calculatorUrl, request, String.class);
		assertEquals(result, "5+3=8");
	}
	@Test
	void testMinus() {
		String inputJSON = "{\"operator\":\"minus\", \"left\": 5, \"right\": 3}";
		HttpEntity<String> request = new HttpEntity<String>(inputJSON, headers);

		String result = restTemplate.postForObject(calculatorUrl, request, String.class);
		assertEquals(result, "5-3=2");
	}
	@Test
	void testMultiply() {
		String inputJSON = "{\"operator\":\"multiply\", \"left\": 5, \"right\": 3}";
		HttpEntity<String> request = new HttpEntity<String>(inputJSON, headers);

		String result = restTemplate.postForObject(calculatorUrl, request, String.class);
		assertEquals(result, "5*3=15");
	}
	@Test
	void testDivide() {
		String inputJSON = "{\"operator\":\"divide\", \"left\": 10, \"right\": 2}";
		HttpEntity<String> request = new HttpEntity<String>(inputJSON, headers);

		String result = restTemplate.postForObject(calculatorUrl, request, String.class);
		assertEquals(result, "10/2=5");
	}
	@Test
	void testIllegalOperation() {
		String inputJSON = "{\"operator\":\"stam\", \"left\": 10, \"right\": 2}";
		HttpEntity<String> request = new HttpEntity<String>(inputJSON, headers);

		String result = restTemplate.postForObject(calculatorUrl, request, String.class);
		assertEquals(result, "Invalid operator");
	}
}
