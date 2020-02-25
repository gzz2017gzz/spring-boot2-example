package com.gzz.demo.base.user;

import java.util.Date;
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
 * @类说明 [用户]实体类
 * @author 高振中
 * @date 2020-02-25 23:45:20
 **/
@Setter
@Getter
@Builder
@TableName(value = "sys_user")
@AllArgsConstructor
@NoArgsConstructor
public class User extends Model<User> {
	private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
   	@TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 姓名
     */
	@TableField(value = "name", exist = true)
    private String name;
    /**
     * 生日
     */
	@TableField(value = "birthday", exist = true)
    private Date birthday;
    /**
     * 性别
     */
	@TableField(value = "gender", exist = true)
    private Byte gender;
}