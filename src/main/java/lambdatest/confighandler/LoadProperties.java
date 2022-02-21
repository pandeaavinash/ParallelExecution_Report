package lambdatest.confighandler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class LoadProperties 
{
	public static Properties prop = null;
	//Register page
	public static final String REGISTER_FIRSTNAMETXT = getProperty("register_firstnametxt"); 
	public static final String REGISTER_SURNAMETXT = getProperty("register_surnametxt");
	public static final String REGISTER_MOBILENOTXT = getProperty("register_mobilenotxt");
	public static final String REGISTER_NEWPASSWORDTXT = getProperty("register_newpasswordtxt");
	
	public static final String REGISTER_FIRSTNAMETXTVALUE = getProperty("register_firstnametxTvalue");
	
	
	
	//Login Page
	public static final String LOGIN_USERNAMETXT = getProperty("login_usernametxt");
	public static final String LOGIN_PASSWORDTXT = getProperty("login_passwordtxt");		
	
	//Forgtten Password
	public static final String FORGOTTEN_MOBILENOTXT = getProperty("forgotten_mobilenumbertxt");
	
	//Reporting
	public static final String REPORTFILENAME = getProperty("reportfilename");
	public static final String REPORTHEADLINE = getProperty("headline");
	public static final String REPORTNAME = getProperty("reportname");
	public static final String REPORTDOCUMENTITLE = getProperty("documenttitle");
	public static String OUTPUTFOLDER = null;
	
	//Email
	public static final String EMAIL_EMAILTOSEND = getProperty("emailtosend");
	public static final String EMAIL_EMAILFROM = getProperty("emailfrom");
	public static final String EMAIL_EMAILCC = getProperty("emailcc");
	
	
	
	
	/***
	 * Get the specified propery value form listed config files
	 * @param propertyName Property Name as a key
	 * @return Returns property value from config file
	 */
	public static String getProperty(String propertyName)
	{
		String value = null;
		try
		{
			if(prop == null)
			{
				prop = new Properties();
				prop.load(LoadProperties.class.getClassLoader().getResourceAsStream("./config/EnvConfig.properties"));
				prop.load(LoadProperties.class.getClassLoader().getResourceAsStream("./config/ReportConfig.properties"));
				prop.load(LoadProperties.class.getClassLoader().getResourceAsStream("./config/LocatorConfig.properties"));
			}
				if(prop.getProperty(propertyName) != null) 
				{
					//value =  prop.getProperty(propertyName);
					if(value != null)
						value= null;
					value= System.getProperty(propertyName);
					if(value==null)
						value =  prop.getProperty(propertyName);
					System.out.println("Property:"+propertyName+"    propertyValue:"+value);
				}
				else
					System.out.println("Property: "+propertyName+"     "+"Value is null !!");
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception occurred while reading properties files !!!");
		}
		return value;
	}
	
	
	
}
