package com.kn.collection;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * GroupMethod类 用于匹配并抓去 Html上我们想要的内容
 * @author kevin
 *
 * Created At 2014-8-14 下午4:30:33
 */
public class GroupMethod {
	// 传入2个字符串参数 一个是pattern(我们使用的正则) 另一个matcher是html源代码
	public String regularGroup(String pattern, String matcher) {
		Pattern p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(matcher);
		if (m.find()) { // 如果读到
			return m.group();// 返回捕获的数据
		} else {
			return ""; // 否则返回一个空值
		}
	}
}
