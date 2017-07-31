package com.bsoft.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class DateConverter  implements Converter {

	 @Override
	 public boolean canConvert(Class arg0) {
		 return Date.class == arg0;
	 }
	 @Override
	 public void marshal(Object arg0, HierarchicalStreamWriter arg1,
	   MarshallingContext arg2) {
		 
	 }
	 @Override
	 public Object unmarshal(HierarchicalStreamReader reader,
	   UnmarshallingContext arg1) {
		 
		if(reader.getValue() == null  || "".equals(reader.getValue())){
     		return null;
     	}
        GregorianCalendar calendar = new GregorianCalendar(); 
        SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd"); //格式化当前系统日期
        try {
            calendar.setTime(dateFm.parse(reader.getValue()));
        } catch (ParseException e) {
                throw new ConversionException(e.getMessage(), e);
        } 
        return calendar.getTime();
	
	 }

 }