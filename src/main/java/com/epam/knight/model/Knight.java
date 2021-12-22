package com.epam.knight.model;

import com.epam.knight.model.ammunition.Ammunition;
import com.epam.knight.model.ammunition.Damage;
import com.epam.knight.model.ammunition.Protection;
import com.epam.knight.model.sort.SortAmmunitionByCost;
import com.epam.knight.model.sort.SortAmmunitionByWeight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Knight {

    private List<Ammunition> ammunitionList;

    public List<Ammunition> getAmmunition() {
        return ammunitionList;
    }

    public Knight() {
        ammunitionList = new ArrayList<>();
    }

    /**
     * Add new ammunition element to knight
     *
     * @param element that should be equipped to the knight
     */
    public void equip(Ammunition element) {
        ammunitionList.add(element);
    }

    public int calculateAmmunitionCost() {
        int sumCost = 0;
        for (Ammunition value : ammunitionList) {
            sumCost += value.getCost();
        }
        return sumCost;
    }

    public int calculateAmmunitionWeight() {
        int sumWeight = 0;
        for (Ammunition value : ammunitionList) {
            sumWeight += value.getWeight();
        }
        return sumWeight;
    }

    public int calculateAmmunitionDamage() {
        int sumDamage = 0;
        for (Ammunition value : ammunitionList) {
            if(value instanceof Damage){
                sumDamage += ((Damage)value).getDamage();
            }
        }
        return sumDamage;
    }

    public int calculateAmmunitionProtection() {
        int sumProtection = 0;
        for (Ammunition value : ammunitionList) {
            if(value instanceof Protection){
                sumProtection += ((Protection)value).getProtection();
            }
        }
        return sumProtection;
    }

    public List<Ammunition> sortByCost(){
        List<Ammunition> clonedAmmunition = new ArrayList<>(ammunitionList);
        Collections.sort(ammunitionList, new SortAmmunitionByCost());
        return clonedAmmunition;
    }

    public void sortByWeight(){
        ammunitionList.sort(new SortAmmunitionByWeight());
    }
}