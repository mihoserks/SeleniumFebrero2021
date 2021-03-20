package comun;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LeerProperties {                                        
	private String systemPropFileName = System.getProperty("user.dir")+"\\src\\main\\resources\\datafiles\\data.properties";
	private static Properties systemProp = null;
	private Properties m_properties = new Properties();
	
	//Un comentario
	/**
	 * @author Sergio
	 * @date  06/03/2021
	 * @param String
	 * 
	 ***/
	public void setSystemPropFileName(String fileName) {
		this.systemPropFileName=fileName;
	}
	
	/**
	 * @author Sergio
	 * @date  06/03/2021
	 * @param String
	 * 
	 ***/
	public Properties getSystemProperties() {
		String fileName = systemPropFileName;
		
			systemProp = getPropertiesFromFileName(fileName);
			loadSystemProp(fileName, systemProp);
		
		
		return systemProp;
	}
	
	/**
	 * @author Sergio
	 * @date  06/03/2021
	 * @param String, Properties
	 * 
	 ***/
	private void loadSystemProp(String fileName, Properties prop) {
		if(System.getProperties().isEmpty()) {
			System.load(fileName);
		}else {
			System.getProperties().putAll(prop);
		}
	}
	
	/**
	 * @author Sergio
	 * @date  06/03/2021
	 * @param String
	 * 
	 ***/
	private Properties getPropertiesFromFileName(String fileName) {
		Properties prop = null;
		
		try {
				propertiesFile(fileName);
				prop = getProperties();
		}catch(Exception e) {
			System.out.println("No es posible leer tu archivo de propiedades");
			System.exit(1);
		}
		
		
		
		return prop;
	}
	
	/**
	 * @author Sergio
	 * @date  06/03/2021
	 * @param String
	 * 
	 ***/
	private void propertiesFile(String fileName) throws IOException{
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File(fileName));
			m_properties.load(fis);
		}finally {
			if(fis!=null) {
				fis.close();
			}
		}//finally
			
	}
	
	
	/**
	 * @author Sergio
	 * @date  06/03/2021
	 * @param String
	 * 
	 ***/
	private Properties getProperties() {
		return m_properties;
	}
	
	
	
	
}//end class
