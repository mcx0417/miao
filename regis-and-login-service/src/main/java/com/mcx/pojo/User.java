package com.mcx.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("login")
public class User {
    @TableId(value = "id",type = IdType.INPUT)
    private Integer id;

    private String username;
    private String password;
    private Integer salary;
}
