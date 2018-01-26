package com.example.niragmehta.assignment2;

/**
 * Store information about a single pot
 */

public class Pot {

    private int weight;
    private String name;
    private int weightWithFood;
    private int servingNumber;

    // Set member data based on parameters.
    public Pot(String name, int weightInG) {
        this.name=name;
        this.weight=weightInG;
    }

    public int getWeightWithFood() {
        return weightWithFood;
    }

    public int getServingNumber() {
        return servingNumber;
    }

    // Return the weight
    public int getWeightInG() {
        return weight;
    }

    // Set the weight. Throws IllegalArgumentException if weight is less than 0.
    public void setWeightInG(int weightInG) {
        this.weight=weightInG;
    }

    // Return the name.
    public String getName() {
        return name;
    }

    public int weightOfFood()
    {
        return weightWithFood-weight;
    }

    public int servingWeight()
    {
        if(servingNumber==0)
        {
            System.out.println("Warning: Number of servings=0, hence returning 0 serving weight");
            return 0;
        }
        return servingWeight()/servingNumber;
    }

    // Set the name. Throws IllegalArgumentException if name is an empty string (length 0),
    // or if name is a null-reference.
    public void setName(String name) {
        this.name=name;
    }

    public void setWeightWithFood(int weightWithFood) {
        this.weightWithFood = weightWithFood;
    }

    public void setServingNumber(int servingNumber) {
        this.servingNumber = servingNumber;
    }
}