package analysis.in.java.chapter3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StackApplication {

	private static boolean pair(byte lift, byte right) {
		return lift == '[' && right == ']' || lift == '(' && right == ')';
	}

	/**
	 * 判断大括号，小括号的匹配问题
	 * 
	 * @param input
	 * @return
	 */
	public static boolean parseExpression(String input) {
		MyLinkedStack<Byte> stack = new MyLinkedStack<Byte>();
		for (byte b : input.getBytes()) {
			boolean isLift = b == '[' || b == '(';
			boolean isRight = b == ']' || b == ')';
			if (isLift) {
				stack.push(b);
			}
			if (isRight && (stack.isEmpty() || !pair(stack.pop(), b))) {
				return false;
			}
		}
		if (stack.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * 返回后缀表达式express的值
	 * 
	 * @param express
	 *            输入是后缀表达式，用空格隔开
	 * @return
	 */
	public static double calculatePostfixExpression(String express) {
		MyLinkedStack<Double> numbers = new MyLinkedStack<Double>();
		String[] inputs = express.split(" ");
		for (String temp : inputs) {
			boolean isOperator = isOperator2(temp);
			if (!isOperator) {
				numbers.push(Double.valueOf(temp));
			} else {
				double first = numbers.pop();
				double second = numbers.pop();
				numbers.push(calculate(first, second, temp));
			}
		}
		return numbers.pop();
	}

	/**
	 *将中缀表达式转化为后缀表达式
	 * 
	 * @param input
	 *            中缀表达式
	 * @return
	 */
	public static String infixToPostfixExpression(String input) {
		StringBuilder postfix = new StringBuilder(input.length()+1);
		MyLinkedStack<String> operators = new MyLinkedStack<String>();
		String[] inputs = input.split(" ");
		for (String temp : inputs) {
			boolean isOperator = isOperator2(temp);
			// 数字直接输出
			if (!isOperator) {
				postfix.append(temp).append(" ");
			} else if (!temp.equals(")")) {
				/**
				 * 比较操作符栈顶的元素与现在的操作符的优先级 
				 * 如果栈顶的操作符的优先级更高则这个操作符出栈，并放到输入当中
				 */
				while (!operators.isEmpty() && comparePrivilege(operators.top(), temp)) {
					postfix.append(operators.pop()).append(" ");
				}
				operators.push(temp);
			} else {
				// 处理右括号
				while(!operators.top().equals("(")){
					postfix.append(operators.pop()).append(" ");
				}
				operators.pop();
				
			}

		}
		while(!operators.isEmpty()){
			postfix.append(operators.pop()).append(" ");
		}

		return postfix.toString();
	}

	/**
	 * 根据操作符的不同，返回first，second经过计算后的值
	 * @param first 第一个数字
	 * @param second 第二个数字
	 * @param operator 操作符
	 * @return
	 */
	public static double calculate(double first, double second, String operator) {
		if (operator.endsWith("-")) {
			return first - second;
		}
		if (operator.endsWith("+")) {
			return first + second;
		}
		if (operator.endsWith("*")) {
			return first * second;
		}
		if (operator.endsWith("/")) {
			return first * second;
		}
		throw new RuntimeException();
	}

	/**
	 * 慢一点 比isOperator2
	 * 判断输入是不是操作符，
	 * 操作包括+,-,*,/,(,)
	 * @param input
	 * @return
	 */
	public static boolean isOperator(String input) {
		Pattern pattern = Pattern.compile("[+|\\-|*|/|(|)]");
		Matcher matcher = pattern.matcher((CharSequence) input);
		boolean result = matcher.matches();
		return result;
	}

	/**
	 * 判断输入是不是操作符，
	 * 操作包括+,-,*,/,(,)
	 * @param input
	 * @return
	 */
	public static boolean isOperator2(String input) {
		return input.equals("+") || input.equals("-") || input.equals("*")
				|| input.equals("/") || input.equals("(") || input.equals(")");
	}

	/**
	 * 比较两个操作符的优先级
	 * +,-权重值为0
	 * *,/权重值为1
	 * 第一个操作符为(时,(的权重值为-1
	 * 第二个操作符为(时,(的权重值为2
	 * @param first
	 * @param second
	 * @return 当第一个操作符的权重值不小于第二个操作符的权重值时返回true
	 */
	private static boolean comparePrivilege(String first, String second) {
		int firstWeight = 0, secondWeight = 0;
		if (first.equals("*") || first.equals("/")) {
			firstWeight = 1;
		}
		if (first.equals("(")) {
			firstWeight = -1;
		}
		if (second.equals("*") || second.equals("/")) {
			secondWeight = 1;
		}
		if (second.equals("(")) {
			secondWeight = 2;
		}
		return firstWeight >= secondWeight;
	}
}
