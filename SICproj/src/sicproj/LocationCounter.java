package sicproj;


public class LocationCounter {
       String[] ExtractLC(String[][] table){
          
           String [] locationCount = new String[table.length-1];
           
          
             
             
           locationCount[0] =  table[0][2];
          
           int j=0;
           
           for(int i = 1; i<table.length-1;i++){
             
               
            if(table[i][1].toUpperCase().equals("RESW")){
            int temp=Integer.parseInt(table[i][2])*3;
            locationCount[j+1] = Integer.toHexString(Integer.parseInt(locationCount[j],16)+temp).toUpperCase();
            }else if(table[i][1].toUpperCase().equals("RESB")){
              int temp=Integer.parseInt(table[i][2],16);
            locationCount[j+1] = Integer.toHexString(Integer.parseInt(locationCount[j],16)+temp).toUpperCase();
            }else if(table[i][1].toUpperCase().equals("BYTE")){
                char[] temp= table[i][2].toCharArray();
               if(table[i][2].toUpperCase().startsWith("X") ){                 
                  int count= (temp.length -3)/2;
                  locationCount[j+1] = Integer.toHexString(Integer.parseInt(locationCount[j],16)+count).toUpperCase() ;
               }else{
                  int count= temp.length-3 ;
                  locationCount[j+1] = Integer.toHexString(Integer.parseInt(locationCount[j],16)+count).toUpperCase() ;
               }
            }else{
                  
                  locationCount[j+1] = Integer.toHexString(Integer.parseInt(locationCount[j],16)+3).toUpperCase();
                  
            }
            j++;
           }
           
         
         
           
           
                      
                         
           return locationCount ;
           
           
          
         
       }
       String [][] ExtractST (String [][] table , String[] locationCount ){
            int m = 0 ;
            String progName= table[table.length-1][2] ;
            String[][] symbolTable = new String[stRowCal(table)][2];
            for(int i = 1;i<table.length;i++){
              if(table[i][0].equals(";") == false && table[i][2] != progName){ 
               
                   symbolTable[m][0]=table[i][0];
                   symbolTable[m][1]=locationCount[i-1];
                   m++;
              }
          
          }
               return symbolTable;
       }
      int stRowCal(String[][] table){
          int count =0 ;
          for(int i = 1 ;i <table.length ; i++){
              if(table[i][0].trim().equals(";") == false ){ 
                   count++;
           
              }
          }

          
          return count;
      }
      String searchST(String objective , String[][] symbolTable ){
        
                int i=0;
                String returnval="";
              while(i<symbolTable.length){
                     
                 if(objective.toUpperCase().trim().equals(symbolTable[i][0])){
                 
                  returnval= symbolTable[i][1];
                  break;
              
              }else{ i++;}
                  
              }
              
            return returnval;
         
   
      }
     
}	