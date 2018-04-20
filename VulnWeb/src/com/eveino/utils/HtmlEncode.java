package com.eveino.utils;

public class HtmlEncode {
	public static String htmlFilter(String value) {
		if (value == null)
			return null;
		char[] content = new char[value.length()];
		value.getChars(0, value.length(), content, 0);
		StringBuilder result = new StringBuilder(content.length + 50);
		for (int i = 0; i < content.length; i++) {
			switch (content[i]) {
			case '<':
				result.append("&lt;");
				break;
			case '>':
				result.append("&gt;");
				break;
			case '&':
				result.append("&amp;");
				break;
			case '"':
				result.append("&quot;");
				break;
			case '/':
				result.append("&#x2f;");
				break;
			default:
				result.append(content[i]);
			}
		}
		return result.toString();
	}
}
