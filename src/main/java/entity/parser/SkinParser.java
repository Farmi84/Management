package entity.parser;

import constant.SkinType;

public class SkinParser {

    public static SkinType parseSkinType(String skinTypeString){
        if(skinTypeString.equals("NATURAL")){
            return SkinType.NATURAL;
        } else if(skinTypeString.equals("ARTIFICIAL")){
            return SkinType.ARTIFICIAL;
        }
        return null;
    }
}
