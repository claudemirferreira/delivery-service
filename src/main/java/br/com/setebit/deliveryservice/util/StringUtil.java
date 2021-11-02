package br.com.setebit.deliveryservice.util;

import java.util.List;

public class StringUtil {
	
	public static String generateHql(String select, List<String> stmt) {
		StringBuilder hql = new StringBuilder(select);
		boolean addedWhere = false;
		String where = " where ", and = " and ";
		for (String s : stmt) {
			if (addedWhere) {
				hql.append(and + s);
			} else {
				hql.append(where + s);
				addedWhere = true;
			}
		}
		return hql.toString();
	}
	
	public static boolean notEmpty(Object obj) {
		if (obj instanceof String)
			return notEmpty((String) obj);
		return obj != null;
	}

}