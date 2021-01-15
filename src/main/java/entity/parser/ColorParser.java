package entity.parser;

import constant.Color;

public class ColorParser {

    public static Color parseColor(String colorString){
        if(colorString.equals("BLACK")){
            return Color.BLACK;
        }else if(colorString.equals("WHITE")){
            return Color.WHITE;
        }else if(colorString.equals("RED")){
            return Color.RED;
        }else if(colorString.equals("GREEN")){
            return Color.GREEN;
        }else if(colorString.equals("BLUE")){
            return Color.BLUE;
        }else if(colorString.equals("YELLOW")){
            return Color.YELLOW;
        }
        return null;
    }
}
