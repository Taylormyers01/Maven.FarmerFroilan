package com.zipcodewilmington.froilansfarm;

import com.zipcodewilmington.froilansfarm.Animals.Chicken;
import com.zipcodewilmington.froilansfarm.Animals.Farmer;
import com.zipcodewilmington.froilansfarm.Animals.Horse;
import com.zipcodewilmington.froilansfarm.Animals.Pilot;
import com.zipcodewilmington.froilansfarm.Food.Corn;
import com.zipcodewilmington.froilansfarm.Food.CornStalk;
import com.zipcodewilmington.froilansfarm.Food.TomatoPlant;
import com.zipcodewilmington.froilansfarm.HousingForAnimals.ChickenCoop;
import com.zipcodewilmington.froilansfarm.HousingForAnimals.FarmHouse;
import com.zipcodewilmington.froilansfarm.HousingForAnimals.Stables;
import com.zipcodewilmington.froilansfarm.Interfaces.Aircraft;
import com.zipcodewilmington.froilansfarm.Interfaces.FarmVehicle;
import com.zipcodewilmington.froilansfarm.Vehicles.CropDuster;
import com.zipcodewilmington.froilansfarm.Vehicles.Tractor;

import java.util.ArrayList;

public class Farm {
    public ArrayList<Stables> stables = new ArrayList<>();
    ArrayList<ChickenCoop> chickenCoops= new ArrayList<>();
    public Field field = new Field();
    public FarmHouse farmHouse = new FarmHouse();
    public Aircraft aircraft;
    ArrayList<FarmVehicle> farmVehicles= new ArrayList<>();

    public void setup(){
        farmHouse.add(new Farmer("Froiland"));
        farmHouse.add( new Pilot("Froilanda"));
        field.addAll(buildField());
        aircraft = new CropDuster();
        for(int i = 0; i < 3; i++){
            chickenCoops.add(buildchickenCoop(4));
        }
        chickenCoops.add(buildchickenCoop(3));
        stables.add(buildStables(3));
        stables.add(buildStables(4));
        stables.add(buildStables(3));
        farmVehicles.add(new Tractor());
        farmVehicles.add(new Tractor());
    }

    public Field buildField(){
        Field hold = new Field();
        for(int i = 1; i <=5; i++ ){
            if (i%2 ==0){
                hold.add(buildTomatoPlant());
            }
            else{
                hold.add(buildCornRow());
            }
        }
        return hold;
    }
    public CropRow<CornStalk> buildCornRow(){
        CropRow<CornStalk> cs = new CropRow<>();
        for(int i = 0; i < 5; i++){
            cs.add(new CornStalk());
        }
        return cs;
    }
    public CropRow<TomatoPlant> buildTomatoPlant(){
        CropRow<TomatoPlant> tp = new CropRow<>();
        for(int i = 0; i < 5; i++){
            tp.add(new TomatoPlant());
        }
        return tp;
    }

    public ChickenCoop buildchickenCoop(int numOfChick){
        ChickenCoop cc = new ChickenCoop();
        for(int i = 0; i < numOfChick; i++){
            cc.add(new Chicken());
        }
        return cc;
    }
    public Stables buildStables(int numOfHorse){
        Stables s = new Stables();
        for(int i = 0; i < numOfHorse; i++){
            s.add(new Horse());
        }
        return s;
    }
}
