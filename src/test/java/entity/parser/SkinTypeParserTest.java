package entity.parser;

import enums.SkinType;
import org.junit.Assert;
import org.junit.Test;

public class SkinTypeParserTest {

    @Test
    public void testNaturalSkin(){
        String skinType = "NATURAL";
        SkinType naturalSkin = SkinParser.parseSkinType(skinType);
        Assert.assertEquals(SkinType.NATURAL, naturalSkin);
    }

    @Test
    public void testArtificialSkin(){
        String skinType = "ARTIFICIAL";
        SkinType artificialSkin = SkinParser.parseSkinType(skinType);
        Assert.assertEquals(SkinType.ARTIFICIAL, artificialSkin);
    }


    @Test
    public void testOtherSkin(){
        String skinType = "HUMAN";
        SkinType humanSkin = SkinParser.parseSkinType(skinType);
        Assert.assertEquals(SkinType.NATURAL, humanSkin);
    }
}
