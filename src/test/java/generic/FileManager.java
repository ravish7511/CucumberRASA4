package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileManager {
	Properties pro;

	public FileManager() {
		try {
			FileInputStream fis = new FileInputStream("E:\\RASA4(Ecommerce)\\Testq\\env.properties");
			pro = new Properties();
			pro.load(fis);//load the property file
		} catch (Exception e) {
			System.out.println(" property file not found");
		}
	}

	public String getQATUrl() {
		String url = pro.getProperty("qat");
		if(url!=null)
		{
		return url;
		}
		else
		{
			throw new RuntimeException("qat url not found");
		}
	}

	public String getPreProductionUrl() {
		String url = pro.getProperty("preprod");
		return url;
	}

	public String getProductionUrl() {
		String url = pro.getProperty("production");
		return url;
	}
	
	public Long getImplicitlyWait() {
		String key = pro.getProperty("impilictlyWait");
		long val = Long.parseLong(key);
		return val;
	}

}
