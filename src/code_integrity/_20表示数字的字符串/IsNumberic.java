package code_integrity._20表示数字的字符串;

/**
 * Created by ehang at 18-8-3
 */

/**
 * 题目：
 *  请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 *  例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 *  但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 * 思路：
 *  数字的格式可以用A[.[B]][e|EC]
 *  其中，A为数字中的整数部分，可能有正负号
 *  B为小数部分， 不能有正负号
 *  C为指数部分，必须在e或E的后面
 */
public class IsNumberic {

	private int index = 0;

	public boolean isNumeric(char[] str) {
		if (str == null) return false;

		boolean numberic = scanInteger(str);

		// 如果出现'.'，则接下来是小数部分
		if (index < str.length && str[index] == '.') {
			index++;

			// 用||的原因：
			// 1.小数可以没有整数部分， 如.123等于0.123
			// 2.小数点后面可以没有数字， 如223.等于223.0
			// 3.小数点前面和后面都可以有数字， 如12.34
			numberic = scanUnsignedInteger(str) || numberic;
		}

		if (index < str.length && (str[index] == 'e' || str[index] == 'E')) {
			index++;

			// 用&&的原因
			// 1. 当e或E的前面没有数字时，整个字符串不能表示数字，如.e1, e1;
			// 2. 当e或E后面没有整数时，不能表示数字， 如12e、12e+5.4
			numberic = numberic && scanInteger(str);
		}

		return numberic && index == str.length;
	}

	private boolean scanInteger(char[] str) {
		if (index < str.length && (str[index] == '+' || str[index] == '-')) {
			index++;
		}
		return scanUnsignedInteger(str);
	}

	private boolean scanUnsignedInteger(char[] str) {
		int curIndex = index;
		while (index < str.length && str[index] >= '0' && str[index] <= '9') {
			index++;
		}
		return index > curIndex ? true : false;
	}

}
