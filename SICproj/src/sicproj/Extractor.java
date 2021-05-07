package sicproj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Arrays;
 
public class Extractor
{   
    String [][] ArrayExtractor(String filePath ) throws FileNotFoundException
    {
        File codeFile = new File(filePath);
        
         
       
         
       
             Scanner sc = new Scanner(codeFile);
         
             String line = "";
             String[] temp = new String[3];
             int rowCounter = 0;
             StringTokenizer sk;
             while(sc.hasNextLine() ){
                     
                     sk=new StringTokenizer(sc.nextLine());
                     if(sk.countTokens()==0){break;}
                     rowCounter++;
             }
             Scanner sc2 = new Scanner(codeFile);
             String templine2="",templine3="";
             StringTokenizer tokenizer ,tokenizer1;
             Scanner sc3 = new Scanner(codeFile);
             sc3.nextLine();
            while( sc2.hasNextLine() ) 
            {  
               templine2=sc2.nextLine(); 
               tokenizer = new StringTokenizer(templine2); 
                if(sc2.hasNext() == false && tokenizer.countTokens()==2){
                    line+= " ; "+templine2.toUpperCase();
                    break;
                }
                if(tokenizer.countTokens()==2 ){
                    line+=" ; " +templine2.toUpperCase()+"\n";
                }else if(tokenizer.countTokens()==1){
                      line += " ; " +templine2.toUpperCase()+" ;"+"\n";
                }else{
                line+= templine2.toUpperCase()+"\n";
                }
               
                
                
            }
             String [] str = line.split("\n");
              int rowsCount=str.length;
             StringTokenizer columnfinder = new StringTokenizer(str[0]);
             int columnsCount =columnfinder.countTokens();
             StringTokenizer sh1 = new StringTokenizer(line);
             StringTokenizer sh2 = new StringTokenizer(line); 
             String [][] modified_Array = new String[rowsCount][columnsCount];
           
               for(int i=0;i<rowsCount;i++){
                  for(int j=0;j<columnsCount;j++){
                        if(sh2.hasMoreTokens()){
                            
                            modified_Array[i][j]=sh2.nextToken();
                          
                        }
                    }
                }
             
             
            return modified_Array;
            

        }
        
    void display(String[][] array){
          System.out.println("");
          for(int i=0;i<array.length;i++){
              for(int j=0;j<array[0].length;j++){
                  if(array[i][j]==null){break;}
                  System.out.printf(array[i][j]+"    ");
                  
              }
              System.out.println("");
          }
         
      }
     void display(String[] array ,String [][] array2 , String[] array3   ){
        
          for(int i=0;i<array2.length;i++){
              for(int j=0;j<3;j++){
                  if(j==0){
                      System.out.printf("   "+array2[i][j]+"    ");
                      
                  }else if(j>0){
                       System.out.printf("   "+array2[i][j]+"    ");
                      continue;
                  }
                  System.out.println("");
                  System.out.print(array[i]+  "       "  + array3[i]);
              }
              }
            for(int i=0;i<array.length;i++){
              {
                 
                  
                  
              }
              System.out.println("");
          }
              
          }
         
      }
