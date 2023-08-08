package com.zipcodewilmington.froilansfarm.WeekTests;

import com.zipcodewilmington.froilansfarm.Animals.Farmer;
import com.zipcodewilmington.froilansfarm.Animals.Horse;
import com.zipcodewilmington.froilansfarm.Animals.Pilot;
import com.zipcodewilmington.froilansfarm.CropRow;
import com.zipcodewilmington.froilansfarm.Farm;
import com.zipcodewilmington.froilansfarm.Food.*;
import com.zipcodewilmington.froilansfarm.HousingForAnimals.Stables;
import com.zipcodewilmington.froilansfarm.Interfaces.Edible;
import com.zipcodewilmington.froilansfarm.Vehicles.Tractor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TuesdayTest {

    public Farm farm;

    @Before
    public void setup(){
        farm = new Farm();
        farm.setup();
    }

    @Test
    public void rideEachHorse(){
        Farmer froilan = (Farmer)farm.farmHouse.get(0);
        for(Stables s: farm.stables){
            Assert.assertTrue(froilan.rideHorses(s));
        }
    }
    @Test
    public void rideEachHorse2(){
        Pilot froilanda = (Pilot)farm.farmHouse.get(1);
        for(Stables s: farm.stables){
            Assert.assertTrue(froilanda.rideHorses(s));
        }
    }
    @Test
    public void feedEachHorse(){
        for(Stables s: farm.stables){
            for(Horse h: s){
                Assert.assertTrue(h.eat(new Corn()));
            }
        }
    }

    @Test
    public void froilanEat(){
        Farmer froilan = (Farmer)farm.farmHouse.get(0);
        Assert.assertTrue(froilan.eat(new Corn()));
        for(int i =0; i < 2 ; i++){
            Assert.assertTrue(froilan.eat(new Tomato()));
        }
        for(int i = 0; i < 5; i++){
            Assert.assertTrue(froilan.eat(new Egg()));
        }
    }

    @Test
    public void froilandaEat(){
        Farmer froilanda = (Farmer)farm.farmHouse.get(0);
        Assert.assertTrue(froilanda.eat(new Tomato()));
        for(int i =0; i < 2 ; i++){
            Assert.assertTrue(froilanda.eat(new Corn()));
        }
        for(int i = 0; i < 2; i++){
            Assert.assertTrue(froilanda.eat(new Egg()));
        }
    }

    @Test
    public void harvestCropRows(){
        Farmer froilan = (Farmer)farm.farmHouse.get(0);
        Tractor tractor = new Tractor();
        Assert.assertTrue(tractor.ride(froilan));

        CropRow cropRow1 = new CropRow<>();
        cropRow1.add(new CornStalk());
        cropRow1.add(new TomatoPlant());
        cropRow1.add(new TomatoPlant());

        CropRow cropRow2 = new CropRow<>();
        cropRow2.add(new CornStalk());
        cropRow2.add(new CornStalk());
        cropRow2.add(new TomatoPlant());

        CropRow cropRow3 = new CropRow<>();
        cropRow3.add(new TomatoPlant());
        cropRow3.add(new TomatoPlant());
        cropRow3.add(new CornStalk());

        ArrayList<Edible> holdCrops1 = tractor.harvest(cropRow1);
        Assert.assertEquals(holdCrops1.size(), 3);
        Assert.assertEquals(cropRow1.size(), 0);

        ArrayList<Edible> holdCrops2 = tractor.harvest(cropRow2);
        Assert.assertEquals(holdCrops2.size(), 3);
        Assert.assertEquals(cropRow2.size(), 0);

        ArrayList<Edible> holdCrops3 = tractor.harvest(cropRow3);
        Assert.assertEquals(holdCrops3.size(), 3);
        Assert.assertEquals(cropRow3.size(), 0);

    }
}
