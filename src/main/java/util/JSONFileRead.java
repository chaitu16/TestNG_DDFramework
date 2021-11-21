package util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONFileRead {

	public static void main(String[] args) throws IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		Reader reader = new FileReader(System.getProperty("user.dir")+"\\data\\portfolio_suite.json");
		JSONObject jsonObject = (JSONObject) parser.parse(reader);
		System.out.println(jsonObject);
		
		JSONArray arr1 = 	(JSONArray) jsonObject.get("testdata");
//		System.out.println(arr1);
		
		for(int i=0; i< arr1.size();i++) {
			JSONObject obj1 = (JSONObject) arr1.get(i);
//			System.out.println(obj1);
	
			JSONArray arr2 = (JSONArray) obj1.get("parameters");
			for(int j=0;j<arr2.size();j++) {
				JSONObject obj2 = (JSONObject) arr2.get(j);
//				System.out.println(obj2);
				
				String paramVal = (String) obj2.get("parametervalue");
				String paramName = (String) obj2.get("parametername");
				
				for(int k = 0;k<arr2.size();k++) {					
			}
			
			System.out.println(paramName+"------"+paramVal);
				
	/*			Set keys = obj2.keySet();
				
				Iterator it = keys.iterator();
				while(it.hasNext()) {
					String key = (String) it.next();
					String value = (String) obj2.get(key);
					System.out.println(key+"-----"+value);
				}
		*/		
			}
		
	
		
		}

		
	}
}
