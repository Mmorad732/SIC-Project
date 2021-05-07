package sicproj;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Instruction_Format {
       public String[] Extract(String [][] table , String [][] symbolTable){
           String opCode ;
           String[] inst_Format=new String[table.length-2];
           LocationCounter lc = new LocationCounter();
           int counter=0;
           for(int i=1;i<table.length-1;i++){
               if(table[i][1].toUpperCase().trim().equals(table[0][0].toUpperCase().trim())){
                  
                   break;
               }
               opCode="";
               String address ;
            
               converter con = new converter();
               String temp="";
               opCode = converter.initialize(table[i][1]);
              
               if(table[i][2].toUpperCase().endsWith("X")){
                    Check_Validity.check_inst(table[i][1].replace(",X", "").trim(),i+1);
                   address= lc.searchST(table[i][2].replace(",X", ""), symbolTable);
                   String  highestbit = con.intToBinary(address.charAt(0));
                  
                  temp =Integer.toHexString(Integer.parseInt("1000",2) + Integer.parseInt(highestbit,2));
                  temp+=address.substring(1, address.length());
                      
                      
                    inst_Format[counter]=opCode+temp;
                   
                   
               }else if(table[i][1].toUpperCase().trim().equals("RESW")||table[i][1].toUpperCase().trim().equals("RESB")){
                 
                   inst_Format[counter]= "No object code";
               }else if(table[i][1].toUpperCase().trim().equals("WORD")){
                   String temp1 = Integer.toHexString(Integer.parseInt(table[i][2]));
                  
                   temp1=con.LengthCheck(temp1,6);
                               
                   inst_Format[counter] = temp1 ;
                   
               }else if(table[i][1].toUpperCase().trim().equals("BYTE")){
                   
                       String temp2 ="";
                       char[] char1 = table[i][2].toCharArray();
                       
                       for(int k = 2; k<char1.length;k++){
                           
                           if(char1[k]==char1[char1.length-1]  ) {
                               
                               break;
                           } else {
                               temp2+=char1[k]+"";
                           }
                           
                       }
                       
                       if(table[i][2].toUpperCase().trim().startsWith("C")){
                           char1=temp2.toCharArray();
                           temp2 = "";
                           int ascii ;
                           for(int k =0;k<char1.length;k++){
                               ascii = char1[k];
                               temp2+=ascii;
                           }
                           
                           
                           
                       }
                       temp2=con.LengthCheck(temp2,6);
                     
                       inst_Format[counter] =temp2;
                   
                   
                   
       
               }else{
                    Check_Validity.check_inst(table[i][1].trim(),i+1);
                   if(table[i][1].toUpperCase().trim().equals("RSUB")){
                     address= ""+"0000";
                   
                   }else {address= lc.searchST(table[i][2], symbolTable);}
                   
                     opCode += address;
                  
               inst_Format[counter] = opCode;
               }
           
               counter++;
           }
                 
                return inst_Format;
    
                  

       }
           
}