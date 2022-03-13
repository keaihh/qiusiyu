package com.fc.util;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;

import javax.activation.DataSource;

public class DruidDataSourceFactory extends PooledDataSourceFactory {
    //替换数据源为Druid
    public DruidDataSourceFactory() {
        this.dataSource = new DruidDataSource();
    }
}
