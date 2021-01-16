package entity.parser;

import enums.Material;

public class MaterialParser {

    public static Material parseMaterial(String materialString){
        if(materialString.equals("LEATHER")){
            return Material.LEATHER;
        } else if(materialString.equals("FUR")){
            return Material.FUR;
        } else if(materialString.equals("COTTON")){
            return Material.COTTON;
        } else if(materialString.equals("WOOL")){
            return Material.WOOL;
        } else if(materialString.equals("POLYESTERS")){
            return Material.POLYESTERS;
        }
        return Material.COTTON;
    }
}
