package automationFramework;

import java.io.File;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class DataProviderFromTextFile extends testBase {
	
	@DataProvider(name = "getDataFromTextFile")
	public static Object[][] getDataFromTextFile (Method testName) {
		
		Object[][] returnData=null;
		
		try
		{

			
			Object[] Lines = Files.readAllLines(Paths.get(".\\datafiles\\"+testName.getName()+".txt")).toArray();
			  String[] parameterNames=null;
			  
				
			  
			  List<HashMap<String, String>> arrayMapList = new ArrayList<HashMap<String, String>>();
			    HashMap<String, String> hashMapItems = new HashMap<String, String>();
			 
			for (int i=0; i<Lines.length; i++)
			{
				
			
				if (i == 0)
				{
					
				  parameterNames = ((String) Lines[i]).split(",");
				  
				  
				}
				else
				{
					String[] values = ((String) Lines[i]).split(",");
					
				
					
					
					for (int j=0; j<values.length; j++)
					{
						
						
						hashMapItems.put(parameterNames[j], values[j]);
					}
					
					arrayMapList.add(hashMapItems);
				}
				
				
			
			}
			
			
		    
		    returnData = new Object [arrayMapList.size()][1];

			for(int i=0; i<arrayMapList.size() ; i++) {
				
				returnData[i][0] = arrayMapList.get(i);
			}
					
		}
			catch (Exception e) {
				
				Reporter.log("<span>Dataprovider Error: Please use the right data file format.</span>"
						+ "<span>File format must be .txt and File name must be same as the test method name  </span>"
						+ "<span>Parameters ad Values must be seperated by comma(,) and number of parameters and values must be equal. </span>",true);
			
			Reporter.log("Dataprovider Exception: " + e.getMessage(),true);
			

		}
		return returnData;
	}
	
}
