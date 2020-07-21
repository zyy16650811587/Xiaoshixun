package com.example.zhouce.Bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;

@Entity
public class Bean {
    @Id    //表示是表中的主键
    private Long id; //一定是Long型
    private String dateTime;
    @Unique
    private String name;
    private String data;
    private String tab;



}
