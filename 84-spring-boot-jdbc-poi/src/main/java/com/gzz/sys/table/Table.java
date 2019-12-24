package com.gzz.sys.table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Table {
	private String table_name;
	private String table_comment;
}