package com.zipcodewilmington.froilansfarm.WeekTests;

import com.zipcodewilmington.froilansfarm.Animals.Farmer;
import com.zipcodewilmington.froilansfarm.Animals.Horse;
import com.zipcodewilmington.froilansfarm.Animals.Pilot;
import com.zipcodewilmington.froilansfarm.CropRow;
import com.zipcodewilmington.froilansfarm.Farm;
import com.zipcodewilmington.froilansfarm.Food.*;
import com.zipcodewilmington.froilansfarm.HousingForAnimals.Stables;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SundayTest {

    public Farm farm;

    @Before
    public void setup(){
        farm = new Farm();
        farm.setup();
    }

    @Test
    public void plantFirstCropRow(){
        Farmer froiland = (Farmer)farm.farmHouse.get(0);
        CropRow<CornStalk> cropRow = new CropRow<>();
        CornStalk cornStalk = new CornStalk();

        for (int i = 0; i < farm.buildCornRow().size(); i++){
            //froiland.plant(this.Corn, cropRow);
            assertTrue(froiland.plant(cornStalk, cropRow));
        }
        //assertEquals(corn, cropRow);
        //assertEquals(5, cropRow.size());
    }

    @Test
    public void plantSecondCropRow(){
        Farmer froiland = (Farmer)farm.farmHouse.get(0);
        CropRow<TomatoPlant> cropRow = new CropRow<>();
        TomatoPlant tomatoPlant = new TomatoPlant();

        for (int i = 0; i < farm.buildTomatoPlant().size(); i++){
            assertTrue(froiland.plant(tomatoPlant, cropRow));

        }
    }

    @Test
    public void plantThirdCropRow(){
        Farmer froiland = (Farmer)farm.farmHouse.get(0);
        CropRow<TomatoPlant> cropRow = new CropRow<>();
        TomatoPlant tomatoPlant = new TomatoPlant();
        CornStalk cornStalk = new CornStalk();

        for (int i = 0; i < farm.buildTomatoPlant().size(); i++){
            assertTrue(froiland.plant(tomatoPlant, cropRow));
            assertTrue(froiland.plant(cornStalk, cropRow));
        }
    }

    @Test
    public void rideEachHorse(){
        Farmer froiland = (Farmer)farm.farmHouse.get(0);
        for(Stables s: farm.stables){
            Assert.assertTrue(froiland.rideHorses(s));
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
        //Corn corn = new Corn();
        for(Stables s: farm.stables){
            for(Horse h: s){
                Assert.assertTrue(h.eat(new Corn()));
            }
        }
    }

    @Test
    public void froilandEat(){
        Farmer froiland = (Farmer)farm.farmHouse.get(0);
        Assert.assertTrue(froiland.eat(new Corn()));
        for(int i =0; i < 2 ; i++){
            Assert.assertTrue(froiland.eat(new Tomato()));
        }
        for(int i = 0; i < 5; i++){
            Assert.assertTrue(froiland.eat(new Egg()));
        }
    }
}
