package com.example.demo.config;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(
        //忽略资源
       initParams = {@WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")},
        filterName = "druidWebStatFilter",urlPatterns = "/*"
)
public class DruidSataFilter extends WebStatFilter {
}
