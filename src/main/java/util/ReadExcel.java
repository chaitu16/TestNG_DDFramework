package util;

import java.util.HashMap;
import java.util.Map;

public class ReadExcel {
	
	public static void main(String[] args) {
		
		String path = System.getProperty("user.dir")+"\\data\\Test Data.xlsx";
		
		Excel_Reader read = new Excel_Reader(path);
		
		String testCase = "CreatePortfolio Test";
		
		int rowStartNum = 1;
		
		while(!read.getCellData("Portfolio Suite", 0, rowStartNum).equals(testCase)){
			rowStartNum++;
		}
		
		System.out.println(rowStartNum);
		
		int testColStartNum = rowStartNum+1;
		int testDataStartNum = testColStartNum+1;
		
		int rows = 0;
		while(!read.getCellData("Portfolio Suite", 0, testDataStartNum+rows).equals("")) {
			rows++;
		}
		System.out.println(rows);
		
		int cols =0;
		while(!read.getCellData("Portfolio Suite", cols, testColStartNum).equals("")) {
			cols++;
		}
		System.out.println(cols);
		
/*		Object[][] data = new Object[rows][cols];
		
		
		for(int rNum =testDataStartNum;rNum<testDataStartNum+rows;rNum++ ) {
			for(int cNum=0;cNum<cols;cNum++) {
				System.out.println(read.getCellData("Portfolio Suite", cNum, rNum));
				
			}
			
		}
		*/
		Object[][] data = new Object[rows][1];
		int index =0;
		Map<String,String> map=null;

		
		for(int rNum =testDataStartNum;rNum<testDataStartNum+rows;rNum++ ) {
			map = new HashMap<String, String>();
			for(int cNum=0;cNum<cols;cNum++) {
				String key = read.getCellData("Portfolio Suite", cNum, testColStartNum);
				String value = read.getCellData("Portfolio Suite", cNum, rNum);
				System.out.println(key+"---"+value);
				map.put(key, value);
				
			}
			System.out.println(map);
			data[index][0]=map;
			index++;
			
		}
		
	}
	

}
