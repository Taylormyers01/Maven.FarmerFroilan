package com.zipcodewilmington.froilansfarm;

import org.junit.Assert;
import org.junit.Test;



import com.zipcodewilmington.froilansfarm.Food.CornStalk;
import com.zipcodewilmington.froilansfarm.Food.Crop;
import com.zipcodewilmington.froilansfarm.Food.TomatoPlant;





import static org.junit.jupiter.api.Assertions.*;

public class CropRowTest {
    CropRow cropRow = new CropRow();

    @Test
    public void testNullaryConstructor() {

        Assert.assertTrue(cropRow.isEmpty());
    }

    @Test
    public void testNullaryConstructor2() {

        Assert.assertNotNull(cropRow);
    }

    @Test
    public void testCropsList() {
        cropRow.add(new CornStalk());
        cropRow.add(new TomatoPlant());
        int expected = 2;

        int actual = cropRow.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCropsList2() {
        cropRow.add(new CornStalk());
        cropRow.add(new TomatoPlant());
        cropRow.add(new TomatoPlant());
        cropRow.add(new TomatoPlant());
        int expected = 3;

        int actual = cropRow.size();

        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void testCropsListNull() {
        int expected = 0;
        int actual = cropRow.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void idkWhatImTestingHere() {
        CropRow<Crop> crop = new CropRow<>();

        CornStalk earCorn = new CornStalk();
        TomatoPlant tomatoPlant = new TomatoPlant();

        crop.add(earCorn);
        crop.add(tomatoPlant);

        assertEquals(earCorn, crop.get(0));
        assertEquals(tomatoPlant, crop.get(1));
    }
}