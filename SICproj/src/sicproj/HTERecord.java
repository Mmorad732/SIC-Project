package sicproj;


public class HTERecord {
    String[] Extract(String[][] table , String[] instFormat , String[] locCounter){
         String progName= table[table.length-1][2], Hrec ,Erec ; 
         String[] lengthCounter = TRecCounter(instFormat);
         String[] Trec = new String[lengthCounter.length];
         converter con = new converter();
         String[] HTE = new String[lengthCounter.length+2];
         int count = 0;
         int locCount = 0;
         for(int i =0;i<Trec.length;i++){
             Trec[i]= "T"+(i+1)+"^"+con.LengthCheck(locCounter[locCount],6)+"^"+Integer.toHexString(Integer.parseInt(lengthCounter[i])*3).toUpperCase()+"^";
          
             for(int j = 0 ; j < Integer.parseInt(lengthCounter[i]);j++){
                 
               if(instFormat[j+locCount].toUpperCase().equals("NO OBJECT CODE")){
                   
             while(instFormat[j+locCount].toUpperCase().equals("NO OBJECT CODE")){
               locCount++; 
               
               }
            Trec[i]= "T"+(i+1)+"^"+con.LengthCheck(locCounter[locCount],6)+"^"+Integer.toHexString(Integer.parseInt(lengthCounter[i])*3).toUpperCase()+"^";
            
                }
            
             if(instFormat[j+locCount].toUpperCase().equals("NO OBJECT CODE")==false ){
                     
                     Trec[i]+=instFormat[j+locCount];
                    
                    
            } 
            
            
         }
         
         locCount += Integer.parseInt(lengthCounter[i]);
         
       } 
         int start = Integer.parseInt(locCounter[0],16) , end =Integer.parseInt(locCounter[locCounter.length-1],16);         
          Hrec = "H ^"+ progName +"^"+locCounter[0]+"^"+Integer.toHexString(end-start).toUpperCase();
          Erec = "E ^" +locCounter[0];
         HTE[0]=Hrec;
         HTE[HTE.length-1]=Erec;
         for(int k =1;k<HTE.length-1;k++){
             HTE[k] = Trec[k-1];
         }
         
         
         
         return HTE;
        
   
    
    
    }
    public String[] TRecCounter(String[] instFormat){
        String[] length = null;
        String counter = "";
        int count = 0 , lengthCount=0;
        for(int i =0;i<instFormat.length;i++){
            
            if(instFormat[i].toUpperCase().equals("NO OBJECT CODE")==false && count <10){
                    count++;  
            }
            if(instFormat[i].toUpperCase().equals("NO OBJECT CODE")){
                 
                 if(count!=0){
                 counter+= count+"\n";
                 count=0;
                 
               }
                continue;
            }
            if(count == 10 || i==instFormat.length-1){
                counter += count+"\n" ;
              
                count=0;
               
            }
            
      
           
           
        }
        
        length = counter.split("\n");
  
        return  length;
    }
}