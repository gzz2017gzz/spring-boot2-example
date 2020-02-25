package com.gzz.demo.sys.role;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * @类说明 [角色]实体类
 * @author 高振中
 * @date 2020-02-25 23:40:14
 **/
@Setter
@Getter
@Builder
@TableName(value = "sys_role")
@AllArgsConstructor
@NoArgsConstructor
public class Role extends Model<Role> {
	private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
   	@TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 客户主键
     */
	@TableField(value = "customerId", exist = true)
    private Integer customerId;
    /**
     * 角色名称
     */
	@TableField(value = "name", exist = true)
    private String name;
    /**
     * 备注
     */
	@TableField(value = "remark", exist = true)
    private String remark;
}