package ParallelExecution;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import com.mysql.cj.util.StringUtils;

public class PropertiesClass {
	
	static Properties pobj=new Properties();
	
	public static String getPropertyvalue(String key) throws Exception
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/Data.properties");
		pobj.load(fis);
		
		String value = pobj.getProperty(key);
		if(StringUtils.isNullOrEmpty(value))
		{
			throw new Exception("Value is not specified foe key : "+key+" in properties file ");
		}
		return value;
	}

}
