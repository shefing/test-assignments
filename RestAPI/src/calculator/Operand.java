package calculator;

public class Operand {
	String operator;
	int left;
	int right;
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public int getLeft() {
		return left;
	}
	public void setLeft(int left) {
		this.left = left;
	}
	public int getRight() {
		return right;
	}
	public void setRight(int right) {
		this.right = right;
	}
	@Override
	public String toString() {
		return "Operand [operator=" + operator + ", left=" + left + ", right=" + right + "]";
	}
	
	
}
