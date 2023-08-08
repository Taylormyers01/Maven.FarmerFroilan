package com.zipcodewilmington.froilansfarm.Vehicles;

import com.zipcodewilmington.froilansfarm.Animals.Farmer;
import com.zipcodewilmington.froilansfarm.CropRow;
import com.zipcodewilmington.froilansfarm.Farm;
import com.zipcodewilmington.froilansfarm.Food.Corn;
import com.zipcodewilmington.froilansfarm.Food.CornStalk;
import com.zipcodewilmington.froilansfarm.Food.Tomato;
import com.zipcodewilmington.froilansfarm.Food.TomatoPlant;
import com.zipcodewilmington.froilansfarm.Interfaces.Edible;
import com.zipcodewilmington.froilansfarm.Interfaces.FarmVehicle;
import com.zipcodewilmington.froilansfarm.Interfaces.Rider;
import com.zipcodewilmington.froilansfarm.Interfaces.Vehicle;

import java.util.ArrayList;



public class Tractor implements FarmVehicle<Farmer> {

    public boolean operate(Farm farm) {
        return true;
    }

    public ArrayList<Edible> harvest(CropRow cropRow){
        ArrayList<Edible> holdCrops = new ArrayList<>();
        for (Object c:cropRow) {
            if(c instanceof CornStalk) {
                holdCrops.add(new Corn());
            } else if(c instanceof TomatoPlant) {
                holdCrops.add(new Tomato());
            }
        }
        cropRow.clear();
//        System.out.println(cropRow.size());
//        System.out.println(holdCrops.size());
        return holdCrops;
    }

    @Override
    public String makeNoise() {
        return "rumble rumble rumble";
    }


    @Override
    public boolean ride(Farmer rider) {
        return rider!=null;
    }
}
