package com.example.springex_web.mapper;

import org.apache.ibatis.annotations.Select;
public interface TimeMapper {
    @Select("select now()")
    String getTime();
}
