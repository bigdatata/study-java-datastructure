package analysis.in.java.chapter3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StackApplication {

	private static boolean pair(byte lift, byte right) {
		return lift == '[' && right == ']' || lift == '(' && right == ')';
	}

	/**
	 * �жϴ����ţ�С���ŵ�ƥ������
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
	 * ���غ�׺���ʽexpress��ֵ
	 * 
	 * @param express
	 *            �����Ǻ�׺���ʽ���ÿո����
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
	 *����׺���ʽת��Ϊ��׺���ʽ
	 * 
	 * @param input
	 *            ��׺���ʽ
	 * @return
	 */
	public static String infixToPostfixExpression(String input) {
		StringBuilder postfix = new StringBuilder(input.length()+1);
		MyLinkedStack<String> operators = new MyLinkedStack<String>();
		String[] inputs = input.split(" ");
		for (String temp : inputs) {
			boolean isOperator = isOperator2(temp);
			// ����ֱ�����
			if (!isOperator) {
				postfix.append(temp).append(" ");
			} else if (!temp.equals(")")) {
				/**
				 * �Ƚϲ�����ջ����Ԫ�������ڵĲ����������ȼ� 
				 * ���ջ���Ĳ����������ȼ������������������ջ�����ŵ����뵱��
				 */
				while (!operators.isEmpty() && comparePrivilege(operators.top(), temp)) {
					postfix.append(operators.pop()).append(" ");
				}
				operators.push(temp);
			} else {
				// ����������
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
	 * ���ݲ������Ĳ�ͬ������first��second����������ֵ
	 * @param first ��һ������
	 * @param second �ڶ�������
	 * @param operator ������
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
	 * ��һ�� ��isOperator2
	 * �ж������ǲ��ǲ�������
	 * ��������+,-,*,/,(,)
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
	 * �ж������ǲ��ǲ�������
	 * ��������+,-,*,/,(,)
	 * @param input
	 * @return
	 */
	public static boolean isOperator2(String input) {
		return input.equals("+") || input.equals("-") || input.equals("*")
				|| input.equals("/") || input.equals("(") || input.equals(")");
	}

	/**
	 * �Ƚ����������������ȼ�
	 * +,-Ȩ��ֵΪ0
	 * *,/Ȩ��ֵΪ1
	 * ��һ��������Ϊ(ʱ,(��Ȩ��ֵΪ-1
	 * �ڶ���������Ϊ(ʱ,(��Ȩ��ֵΪ2
	 * @param first
	 * @param second
	 * @return ����һ����������Ȩ��ֵ��С�ڵڶ�����������Ȩ��ֵʱ����true
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
