
package com.gzz.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
	private Integer id;
	private String name;
	private String passWord;
}
