package com.zipcodewilmington.froilansfarm.Vehicles;

import com.zipcodewilmington.froilansfarm.Animals.Farmer;
import com.zipcodewilmington.froilansfarm.Animals.Pilot;
import com.zipcodewilmington.froilansfarm.CropRow;
import com.zipcodewilmington.froilansfarm.Farm;
import com.zipcodewilmington.froilansfarm.Food.Corn;
import com.zipcodewilmington.froilansfarm.Food.CornStalk;
import com.zipcodewilmington.froilansfarm.Food.Tomato;
import com.zipcodewilmington.froilansfarm.Food.TomatoPlant;
import com.zipcodewilmington.froilansfarm.Interfaces.Edible;
import com.zipcodewilmington.froilansfarm.Interfaces.FarmVehicle;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TractorTest {
    Tractor tractor = new Tractor();

    @Test
    public void testOperate() {
        Farm farm = new Farm();

        Assert.assertTrue(tractor.operate(farm));
    }

    @Test
    public void testInheritance() {

        Assert.assertTrue(tractor instanceof FarmVehicle);
    }

    @Test
    public void testInheritance2() {

        Assert.assertFalse(tractor instanceof Edible);
    }

    @Test
    public void testHarvest() {
        CropRow cropRow = new CropRow();
        cropRow.add(new CornStalk());
        cropRow.add(new TomatoPlant());

        ArrayList<Edible> harvestCrops = tractor.harvest(cropRow);

        Assert.assertEquals(harvestCrops.size(), 2);
    }

    @Test
    public void testHarvest2() {
        CropRow cropRow = new CropRow();
        cropRow.add(new Corn());
        cropRow.add(new Tomato());
        cropRow.add(new Tomato());

        ArrayList<Edible> expected = new ArrayList<>();
        for (int i = 0; i < cropRow.size()-1; i++) {
            expected.add((Edible)cropRow.get(i));
        }

        ArrayList<Edible> actual = tractor.harvest(cropRow);

        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void testMakeNoise() {
        String expected = "rumble rumble rumble";
        String actual = tractor.makeNoise();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMakeNoise2() {
        String expected = "boo beep boo beep";
        String actual = tractor.makeNoise();

        Assert.assertNotEquals(expected, actual);
    }
}