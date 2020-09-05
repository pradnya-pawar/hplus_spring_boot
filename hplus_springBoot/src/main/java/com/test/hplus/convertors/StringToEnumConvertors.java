package com.test.hplus.convertors;
import org.springframework.core.convert.converter.Converter;

import com.test.hplus.beans.Gender;

public class StringToEnumConvertors implements Converter<String,Gender> {

	@Override
	public Gender convert(String s) {
		// TODO Auto-generated method stub
		
		if(s.equals("Male"))
			return Gender.MALE;
		else if (s.equals("Female"))
			return Gender.FEMALE;
		else
			return Gender.OTHER;
		
	}

}
