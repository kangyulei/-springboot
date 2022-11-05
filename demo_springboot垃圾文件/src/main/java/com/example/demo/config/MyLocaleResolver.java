package com.example.demo.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 2.区域信息解析器：1是html的请求。
 * @Description:请求中携带区域信息，根据信息实现国际化
 * 在链接上携带区域信息==比如在href上带上一个信息l，
 * @Author: Zoutao
 * @Date: 2018/12/4
 */
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l"); //有携带就有携带的信息
        Locale locale = Locale.getDefault();//没有就使用浏览器自带的
         System.out.println(l);
        if(!StringUtils.isEmpty(l)){
            String[] split = l.split("_");
            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    /**
     * 必须带有，将请求的区域信息放入区域信息对象locale中
     * @param request
     * @param response
     * @param locale
     */
    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
    }
}


