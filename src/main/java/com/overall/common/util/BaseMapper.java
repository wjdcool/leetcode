package com.overall.common.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 
 * @author GXS
 * @date 2018年4月9日
 * @Description:mapper基类
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
