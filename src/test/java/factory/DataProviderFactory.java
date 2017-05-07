package factory;

import dataProvider.ConfigDataProvider;
import dataProvider.ExcelDataProvider;

public class DataProviderFactory 
{
	public static ConfigDataProvider getconfig()
	{
		ConfigDataProvider config=new ConfigDataProvider();
		return config;
		
	}
	public static ExcelDataProvider getExcel()
	{
		ExcelDataProvider Excel=new ExcelDataProvider();
		return Excel;
		
	}

}
