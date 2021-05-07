package sicproj;

import java.io.FileNotFoundException;


public class Solution {
    Solution(String path) throws FileNotFoundException{
         Extractor read = new Extractor();        
         String[][] array2d = read.ArrayExtractor(path);
         
         LocationCounter lc = new LocationCounter();
         String [] locationCounter = lc.ExtractLC(array2d);
         String[][] symbolTable = lc.ExtractST(array2d,locationCounter);
         Instruction_Format inst = new Instruction_Format() ;
         String[] instructionFormat =inst.Extract(array2d, symbolTable) ;
         HTERecord h = new HTERecord();
         String [] HTErec = h.Extract(array2d , instructionFormat , locationCounter);
         read.display(instructionFormat,array2d , locationCounter);
         //read.display(HTErec);
    }
    
}