package com.aonerchina.battleland.Util;

import java.util.ArrayList;
import java.util.List;

public class ChatColorUtil {
	public static List<String> translate(List<String> l, char t) {
		List<String> l2 = new ArrayList<String>(l);
		for (String s : l2) {
			s = s.replace(t, '¡ì');
		}
		return l2;
	}
}
