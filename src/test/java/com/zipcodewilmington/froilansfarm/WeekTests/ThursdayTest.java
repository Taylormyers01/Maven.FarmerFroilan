package com.zipcodewilmington.froilansfarm.WeekTests;


import com.zipcodewilmington.froilansfarm.Animals.Farmer;
import com.zipcodewilmington.froilansfarm.Animals.Horse;
import com.zipcodewilmington.froilansfarm.Animals.Pilot;
import com.zipcodewilmington.froilansfarm.Farm;
import com.zipcodewilmington.froilansfarm.Food.Corn;
import com.zipcodewilmington.froilansfarm.Food.Egg;
import com.zipcodewilmington.froilansfarm.Food.Tomato;
import com.zipcodewilmington.froilansfarm.HousingForAnimals.Stables;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ThursdayTest {

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

}
