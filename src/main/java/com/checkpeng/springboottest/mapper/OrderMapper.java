package com.checkpeng.springboottest.mapper;

import com.checkpeng.springboottest.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

public interface OrderMapper {

    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    @Insert(" insert into `order`(user_id,pid) values(#{userId},#{pid}) ")
    int insert(Order order);
}
