
package com.gzz.user;

import lombok.Builder;
import lombok.Data;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
@Data
@Builder
public class User {
	private Integer id;
	private String name;
	private String passWord;
}
