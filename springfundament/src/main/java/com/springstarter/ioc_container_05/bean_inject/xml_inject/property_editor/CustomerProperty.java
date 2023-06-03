package com.springstarter.ioc_container_05.bean_inject.xml_inject.property_editor;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CustomerProperty extends PropertyEditorSupport {

    private String format = "yyy-MM-dd";
    public String getFormat(){
        return format;
    }
    public void setFormat(String format){
        this.format = format;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            this.setValue(sdf.parse(text));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
