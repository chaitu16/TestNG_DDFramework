package util;

import java.util.HashMap;
import java.util.Map;

public class TestDataUtil {
	
	public Object[][]  getTestData(Excel_Reader read,String sheetName,String testName) {
		
		String path = System.getProperty("user.dir")+"\\data\\Test Data.xlsx";
		
		 read = new Excel_Reader(path);
		
		String testCase = testName;
		
		int rowStartNum = 1;
		
		while(!read.getCellData(sheetName, 0, rowStartNum).equals(testCase)){
			rowStartNum++;
		}
		
		System.out.println(rowStartNum);
		
		int testColStartNum = rowStartNum+1;
		int testDataStartNum = testColStartNum+1;
		
		int rows = 0;
		while(!read.getCellData(sheetName, 0, testDataStartNum+rows).equals("")) {
			rows++;
		}
		System.out.println(rows);
		
		int cols =0;
		while(!read.getCellData(sheetName, cols, testColStartNum).equals("")) {
			cols++;
		}
		System.out.println(cols);

		Object[][] data = new Object[rows][1];
		int index =0;
		Map<String,String> map=null;

		
		for(int rNum =testDataStartNum;rNum<testDataStartNum+rows;rNum++ ) {
			map = new HashMap<String, String>();
			for(int cNum=0;cNum<cols;cNum++) {
				String key = read.getCellData(sheetName, cNum, testColStartNum);
				String value = read.getCellData(sheetName, cNum, rNum);
				System.out.println(key+"---"+value);
				map.put(key, value);
				
			}
			System.out.println(map);
			data[index][0]=map;
			index++;
			
		}
		
		return data;
		
	}

}
