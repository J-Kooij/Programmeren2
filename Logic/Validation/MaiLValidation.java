package Programmeren2.Logic.Validation;


public class MaiLValidation {
    public static boolean validateMailAddress(String mailAddress) {

        if(!mailAddress.contains("@")){
            return false;
        }

        if(!mailAddress.contains(".")){
            return false;
        }

        if(mailAddress.split("@")[1].split("\\.").length > 2){
            return false;
        }

        if(mailAddress.split("@")[1].split("\\.")[0].length() < 1){
            return false;
        }

        if(mailAddress.split("@")[1].split("\\.", -1)[1].length() < 1){
            return false;
        }

        return true;
    }
}

