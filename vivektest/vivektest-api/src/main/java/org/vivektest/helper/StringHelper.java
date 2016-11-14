/**
 * 
 */
package org.vivektest.helper;

/**
 * 
 * This is a helper class.
 * 
 * @version 1.0
 * @since 1.0
 *
 */
public class StringHelper {
	public static boolean isEmpty(String toTest) {
		boolean result = false;
		if (toTest == null) {
			return true;
		}
		if (toTest != null && toTest.length() > 0) {
			char ch = toTest.trim().charAt(0);
			if (Character.isWhitespace(ch)) {
				result = true;
			}
		}
		return result;
	}
}
