package com.libraries;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Utility 
{
	String path = "C:\\Users\\Shashank\\git\\Sprint2\\Asian_Paints_Sprint2\\src\\test\\resources\\Properties\\Config.properties";
	File configFile = new File(path);
	FileReader reader;
	Properties prop;
	
	public void configfileinitialization() throws IOException
	{
		reader = new FileReader(configFile);
		prop = new Properties();
		prop.load(reader);
	}
	
	public String getWebDriver() throws IOException
	{
		configfileinitialization();
		return prop.getProperty("driverType");
	}
	
	public String getBaseUrl() throws IOException
	{
		configfileinitialization();
		return prop.getProperty("baseUrl");
	}
	
	public String getExecutor() throws IOException
	{
		configfileinitialization();
		return prop.getProperty("driverPath");
	}
    
	
	
	public String getExcelSheetPath1() throws IOException
	{
		configfileinitialization();
		return prop.getProperty("filePath1");
	}
	
	public String getExcelSheetPath2() throws IOException
	{
		configfileinitialization();
		return prop.getProperty("filePath2");
	}
	
	public String getExcelSheetName1() throws IOException
	{
		configfileinitialization();
		return prop.getProperty("sheetName1");
	}
	
	public String getExcelSheetName2() throws IOException
	{
		configfileinitialization();
		return prop.getProperty("sheetName2");
	}
	
	public String getActualMessage()
	{
		//return prop.getProperty("actualMessage");
		String actualError="Sorry, there seem to be no results matching your search.\n"
				+ "Would you want to try some of our popular search terms from below?";
		return actualError;
	}
}
