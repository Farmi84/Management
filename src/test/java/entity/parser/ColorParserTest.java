package entity.parser;

import enums.Color;
import org.junit.Assert;
import org.junit.Test;

public class ColorParserTest {

    @Test
    public void testColorYellow() {
        String color = "YELLOW";
        Color parsedColor = ColorParser.parseColor(color);
        Assert.assertEquals(Color.YELLOW, parsedColor);
    }

    @Test
    public void testColorSmallYellow() {
        String color = "Yellow";
        Color parsedColor = ColorParser.parseColor(color);
        Assert.assertEquals(Color.BLACK, parsedColor);
    }

    @Test
    public void testColorBlue() {
        String color = "BLUE";
        Color parsedColor = ColorParser.parseColor(color);
        Assert.assertEquals(Color.BLUE, parsedColor);
    }

    @Test
    public void testColorOther() {
        String color = "PURPLE";
        Color parsedColor = ColorParser.parseColor(color);
        Assert.assertEquals(Color.BLACK, parsedColor);
    }
}
