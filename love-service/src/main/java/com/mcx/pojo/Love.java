package com.mcx.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("loved")
public class Love {
    @TableId(value = "userid",type = IdType.INPUT)
    private int userid;
    @TableId(value = "miaoid",type = IdType.INPUT)
    private int miaoid;
}
