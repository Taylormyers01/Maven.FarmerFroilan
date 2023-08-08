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

public class WednesdayTest {

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
}
