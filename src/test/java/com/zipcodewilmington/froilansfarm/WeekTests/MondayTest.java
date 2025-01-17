package com.zipcodewilmington.froilansfarm.WeekTests;

import com.zipcodewilmington.froilansfarm.Animals.Farmer;
import com.zipcodewilmington.froilansfarm.Animals.Horse;
import com.zipcodewilmington.froilansfarm.Animals.Pilot;
import com.zipcodewilmington.froilansfarm.CropRow;
import com.zipcodewilmington.froilansfarm.Farm;
import com.zipcodewilmington.froilansfarm.Field;
import com.zipcodewilmington.froilansfarm.Food.Corn;
import com.zipcodewilmington.froilansfarm.Food.Egg;
import com.zipcodewilmington.froilansfarm.Food.Tomato;
import com.zipcodewilmington.froilansfarm.HousingForAnimals.Stables;
import com.zipcodewilmington.froilansfarm.Interfaces.Aircraft;
import com.zipcodewilmington.froilansfarm.Vehicles.CropDuster;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MondayTest {

    public Farm farm;

    @Before
    public void setup(){
        farm = new Farm();
        farm.setup();
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

    @Test
    public void CropDusterFlyTest() {
        Pilot froilanda = (Pilot)farm.farmHouse.get(1);
        farm.aircraft.fly(froilanda);
        Assert.assertTrue(farm.aircraft.fly(froilanda));
    }

    @Test
    public void fertilizeTest() {
        Pilot froilanda = (Pilot)farm.farmHouse.get(1);
        farm.aircraft.fly(froilanda);
        Assert.assertTrue(farm.aircraft.fly(froilanda));
        CropDuster cropDuster = (CropDuster) farm.aircraft;
        for (CropRow crop: farm.field){
            Assert.assertTrue(cropDuster.fertilize(crop));
        }

    }



//    @Before
//    public void setup() {
//        Farm farm = new Farm();
//        Pilot froilanda = new Pilot();
//        Farmer froiland = new Farmer();
//        Field field = new Field();
//        CropRow cr = new CropRow();
//        for (int i = 0; i < 2; i++) {
//            cr.add(new Corn());
//        }
//        field.add(cr);
//        CropRow cr2 = new CropRow();
//        for (int i = 0; i < 2; i++) {
//            cr2.add(new Tomato());
//        }
//        field.add(cr2);
//        for (int i = 0; i < 5; i++) {
//            CropRow c = new CropRow();
//            for (int y = 0; y < 5; y++) {
//                c.add(new Corn());
//            }
//            field.add(c);
//        }
//        //farm.fields = field;
//    }
}








