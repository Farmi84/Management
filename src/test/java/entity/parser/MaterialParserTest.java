package entity.parser;

import enums.Color;
import enums.Material;
import org.junit.Assert;
import org.junit.Test;

public class MaterialParserTest {

    @Test
    public void testMaterialLeather() {
        String material = "LEATHER";
        Material parsedMaterial = MaterialParser.parseMaterial(material);
        Assert.assertEquals(Material.LEATHER, parsedMaterial);
    }

    @Test
    public void testMaterialSmallLeather() {
        String material = "Leather";
        Material parsedMaterial = MaterialParser.parseMaterial(material);
        Assert.assertEquals(Material.COTTON, parsedMaterial);
    }

    @Test
    public void testMaterialFur() {
        String material = "FUR";
        Material parsedMaterial = MaterialParser.parseMaterial(material);
        Assert.assertEquals(Material.FUR, parsedMaterial);
    }

    @Test
    public void testMaterialOther() {
        String material = "STEEL";
        Material parsedMaterial = MaterialParser.parseMaterial(material);
        Assert.assertEquals(Material.COTTON, parsedMaterial);
    }


}
