package sicproj;


public class Check_Validity {
    public static void check_inst(String inst,int i){
        if(converter.initialize(inst) == "" && inst.trim().equals("END")==false){
        System.out.println("ERROR : INVALID INSTRUCTION : " + inst + "   LINE :" + i);
        System.exit(1);
        }
        
    }
    
}