/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamining;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author FEN
 */
public class DataMining {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String[][] data = new String[10][10];
        String[] variable = new String[10];
        String[] unique = new String[10];
        
        data[0][0] = "Medium";
        data[0][1] = "High";
        data[0][2] = "High";
        data[0][3] = "Good";
        data[1][0] = "Low";
        data[1][1] = "Low";
        data[1][2] = "Medium";
        data[1][3] = "Bad";
        data[2][0] = "High";
        data[2][1] = "Medium";
        data[2][2] = "Low";
        data[2][3] = "Bad";
        data[3][0] = "Medium";
        data[3][1] = "Medium";
        data[3][2] = "Medium";
        data[3][3] = "Good";
        data[4][0] = "Low";
        data[4][1] = "Medium";
        data[4][2] = "High";
        data[4][3] = "Good";
        data[5][0] = "High";
        data[5][1] = "High";
        data[5][2] = "Low";
        data[5][3] = "Good";
        data[6][0] = "Low";
        data[6][1] = "Low";
        data[6][2] = "Low";
        data[6][3] = "Bad";
        data[7][0] = "Medium";
        data[7][1] = "Medium";
        data[7][2] = "Medium";
        data[7][3] = "Good";
        
        // Print data
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++){
                System.out.print(data[i][j] + "\t");
            }
                System.out.print("\n");
        }
        
        // Class data if class = col 3
        for (int i=0; i<8; i++) {
            variable[i] = data[i][3];
        }
        
        // Get Unique values
        Set<String> set = new LinkedHashSet<String>(Arrays.asList(variable));
        unique = asStrings(set.toArray());
        System.out.print("Unique values: " + unique.length + "\n");
        int uniqueValue = unique.length-1;
        
        // Print unique values
        for (int j = 0; j < uniqueValue; j++){
            try {
                if (unique[j] != null)
                    System.out.print(unique[j] + "\n");
            }
            catch (NullPointerException | java.lang.ArrayIndexOutOfBoundsException e) {
                return;
            }
        }
        
        // Iterasi Probability Class
        String[] dataTemp = new String[10];
        for (int j=0; j<8; j++) {
                dataTemp[j] = data[j][3];
            }
        System.out.print("Probability Class \n");
        for (int i = 0; i< uniqueValue; i++) {
            // Class data if class = col 3
            int value = countValue(dataTemp, unique[i], uniqueValue);
            double prob = (value*1.0)/8;
            System.out.print("Probability " + unique[i] +" : " + value +
                    "/8 = "+ prob + "\n");
        }
        
    }
    
    
    
    public static int countValue(String[] data, String value, int uniqueValue) {
        int count = 0;
            for (int j=0; j<8; j++) {
                if (data[j] == value){
                    count++;
//                    System.out.print("TRUE \n");
                }
                else {
//                    System.out.print("FALSE \n");
                }
            }
            return count;
    }
 
    public static String[] asStrings(Object... objArray) {
        String[] strArray = new String[objArray.length];
        for (int i = 0; i < objArray.length; i++)
            strArray[i] = String.valueOf(objArray[i]);
        return strArray;
    }
}
