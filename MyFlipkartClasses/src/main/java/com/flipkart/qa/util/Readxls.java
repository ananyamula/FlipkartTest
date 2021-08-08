package com.flipkart.qa.util;

import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Workbook;

public class Readxls {

              static Xls_Reader reader;
              static Workbook book;
              static org.apache.poi.ss.usermodel.Sheet sheet;              
              public static ArrayList<Object[]> getData(String testdata, String sheetname) 
              {                          

                             ArrayList<Object[]> mydata = new ArrayList<Object[]>();                          
                             try{
                            	 reader = new Xls_Reader(testdata);

                             }catch(Exception e){
                            	 e.printStackTrace();

                             }

                             for(int rownum = 2; rownum<= reader.getRowCount(sheetname); rownum++)
                             {
                                           String mob = reader.getCellData(sheetname, "Mobile Company", rownum);
                                           String price = reader.getCellData(sheetname, "Minimum Price", rownum);
                                           String ram = reader.getCellData(sheetname, "RAM", rownum);  
                                           String processor = reader.getCellData(sheetname, "Processor", rownum);                          
                                           Object ob[] = {mob, price, ram,processor};
                                           mydata.add(ob);

                             }
                         return mydata;

              }        

}
