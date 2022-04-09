package com.spring.mvc.converter;

import com.spring.mvc.domain.DemoDomain;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 自定义HttpMessageConverter
 */
public class MyMessageConverter extends AbstractHttpMessageConverter<DemoDomain>{
    public MyMessageConverter(){
        super(new MediaType("application", "x-wisely", StandardCharsets.UTF_8));
    }

    /**
     * 处理请求数据
     */
    @Override
    protected DemoDomain readInternal(Class<? extends DemoDomain> clazz, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        String inContent = StreamUtils.copyToString(httpInputMessage.getBody(), StandardCharsets.UTF_8);
        String[] inContentArr = inContent.split("-");
        return new DemoDomain(new Long(inContentArr[0]), inContentArr[1]);
    }

    /**
     * 支持的类型
     */
    @Override
    protected boolean supports(Class<?> clazz){
        return DemoDomain.class.isAssignableFrom(clazz);
    }

    /**
     * 处理输出数据
     */
    @Override
    protected void writeInternal(DemoDomain demoDomain, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException{
        String outContent = "Hello:" + demoDomain.getId() + "-" + demoDomain.getName();
        httpOutputMessage.getBody().write(outContent.getBytes());
    }
}
