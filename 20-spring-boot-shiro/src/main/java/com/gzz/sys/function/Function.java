package com.gzz.sys.function;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @类说明 [功能]实体类
 * @author 高振中
 * @date 2018-12-24 21:36:34
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