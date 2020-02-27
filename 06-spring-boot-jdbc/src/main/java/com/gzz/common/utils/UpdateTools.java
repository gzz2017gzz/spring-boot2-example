package com.gzz.common.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.gzz.sys.user.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UpdateTools {
	private static final List<Object> params = new ArrayList<>();// 参数值
	private static final StringBuffer sql = new StringBuffer();// 条件语句

	public <T> UpdateTools(T t, Object... obj) {
		try {
			Class<?> clazz = t.getClass();
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				Object object = field.get(t);
				if (object != null && !Arrays.asList(obj).contains(object)) {
					sql.append(" SET " + field.getName() + "=?,");
					params.add(object);
				}
			}
		} catch (IllegalArgumentException e) {
			log.error("反射拼加 UPDATE 语句时出现IllegalArgumentException异常", e);
		} catch (IllegalAccessException e) {
			log.error("反射拼加 UPDATE 语句时出现IllegalAccessException异常", e);
		}
		for (Object object : obj) {
			params.add(object);
		}
	}

	public String getFields() {
		return sql.toString();
	}

	public Object[] getParams() {// 把where

		return params.toArray();
	}

	public static void main(String[] args) {
		User user = User.builder().gender(new Byte("2")).id(1L).name("张三").build();
		UpdateTools tools = new UpdateTools(user, user.getId(), user.getName());
		String sql = "UPDATE sys_user" + tools.getFields() + " WHRERE id=? AND name=?";
		Object[] obj = tools.getParams();
		// jdbcTemplate.update(sql, obj);

		log.info("sql : {}", sql);
		for (Object string : obj) {
			log.info("params : {}", string);
		}
	}
}
