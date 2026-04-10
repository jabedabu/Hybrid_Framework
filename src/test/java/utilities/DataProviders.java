package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    // Data provider 1

    @DataProvider(name="LoginData")
    public String [][] getData() throws IOException {

        String path=".\\testData\\opencart_Login.xlsx";
        ExelUtility xlutil=new ExelUtility(path);

        int totalRows=xlutil.getRowCount("Data");
        int totalCols=xlutil.getCellCount("Data",1);

        String logindata[][]=new String[totalRows][totalCols];
     for(int i=1;i<=totalRows;i++){

         for (int j=0;j<totalCols;j++){
             logindata[i-1][j]= xlutil.getCellData("Data",i,j);
         }
     }
return logindata;
    }



}
