package com.springstarter.c03_spring_ioc.ioc_container.bean_inject_02.xml_inject.property_editor;

import lombok.Data;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/** 自定义属性编辑器 */
@Data
public class CustomerProperty extends PropertyEditorSupport {

    private String format = "yyyy-MM-dd";

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            this.setValue(sdf.parse(text));//转换对象，通过setValue方法重新赋值
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
