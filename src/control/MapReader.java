package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MapReader {
    
    public static char[][] getMapFromFile(String filePath, int totalRow, int totalColumn){
        char[][] myArray = new char[totalRow][totalColumn];
        
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    
        System.out.println("DEBUG-INFO: Loading Map");
        
        for (int row = 0; scanner.hasNextLine() && row < totalRow; row++) {
            char[] chars = scanner.nextLine().toCharArray();
            for (int i = 0; i < totalColumn && i < chars.length; i++) {
                myArray[row][i] = chars[i];
            }
        }
        
        return myArray;
    }
}
