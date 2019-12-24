package com.gzz.sys.function;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @类说明 [功能]实体类
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 **/
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Function {
	// 数据库中的字段
	private Long id; // 主键
	private String url; // 路径
	private String name; // 名称
	private Byte available; // 是否可用
	// 此处可添加查询显示辅助字段
}