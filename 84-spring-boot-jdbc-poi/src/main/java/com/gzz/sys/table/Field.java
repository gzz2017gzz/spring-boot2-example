package com.gzz.sys.table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Field {
	private String column_name;
	private String column_comment;
	private String column_type;
	private String is_nullable;
	private String pri;
}