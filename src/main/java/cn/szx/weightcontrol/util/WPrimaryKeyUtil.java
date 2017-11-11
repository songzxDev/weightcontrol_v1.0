package cn.szx.weightcontrol.util;

import java.util.UUID;

public class WPrimaryKeyUtil {
	public static String producePrimayKeyByUUID() {
		return "J_"+UUID.randomUUID();
	}
}
