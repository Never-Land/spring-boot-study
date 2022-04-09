package com.spring.mvc.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 演示SpringMVC常用注解实体
 */
@NoArgsConstructor
@Setter
@Getter
@ToString
public class DemoDomain{
    /**
     * 自增ID
     */
    private Long id;
    /**
     * 名称
     */
    private String name;

    /**
     * id、name构造函数
     */
    public DemoDomain(Long id, String name){
        super();
        this.id = id;
        this.name = name;
    }
}
