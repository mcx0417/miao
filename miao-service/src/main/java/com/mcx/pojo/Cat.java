package com.mcx.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("miao")
public class Cat {
    private Integer id;
    private String category;
    private String image;
    private Integer loved;
}
