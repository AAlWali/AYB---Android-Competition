package com.example.aybapplication;

import java.util.*;
import java.util.ListIterator;
import java.util.LinkedList;

public class Tshirt {
    public String name;
    public static long ID = 0;
    public float price;
    public String size;
    public String color;
    public static LinkedList<Tshirt> tshirts = new LinkedList<Tshirt>();



    public Tshirt()
    {
        ID++;
        tshirts.add(this);
    }
    public  Tshirt(String name, float price, String color, String size)
    {
        this.name = name;
        this.price = price;
        this.color = color;
        this.size = size;
    }
    public static LinkedList<Tshirt> filterByColor(String color)
    {
        LinkedList<Tshirt> returnable = new LinkedList<Tshirt>();
        ListIterator<Tshirt> it = tshirts.listIterator();
        int i;
        switch (color)
        {
            case "Black":
                i = 0;
                while(i < tshirts.size())
                {
                    Tshirt thisTshirt = tshirts.get(i);
                   if(thisTshirt.color == "Black")
                   {
                       returnable.add(thisTshirt);
                   }
                }
                break;
            case "Blue":
                i = 0;
                while(i < tshirts.size())
                {
                    Tshirt thisTshirt = tshirts.get(i);
                    if(thisTshirt.color == "Blue")
                    {
                        returnable.add(thisTshirt);
                    }
                }
                break;
            case "Green":
                i = 0;
                while(i < tshirts.size())
                {
                    Tshirt thisTshirt = tshirts.get(i);
                    if(thisTshirt.color == "Green")
                    {
                        returnable.add(thisTshirt);
                    }
                }
                break;
            case "Orange":
                i = 0;
                while(i < tshirts.size())
                {
                    Tshirt thisTshirt = tshirts.get(i);
                    if(thisTshirt.color == "Orange")
                    {
                        returnable.add(thisTshirt);
                    }
                }
                break;
            case "Purple":
                i = 0;
                while(i < tshirts.size())
                {
                    Tshirt thisTshirt = tshirts.get(i);
                    if(thisTshirt.color == "Purple")
                    {
                        returnable.add(thisTshirt);
                    }
                }
                break;
            case "Red":
                i = 0;
                while(i < tshirts.size())
                {
                    Tshirt thisTshirt = tshirts.get(i);
                    if(thisTshirt.color == "Red")
                    {
                        returnable.add(thisTshirt);
                    }
                }
                break;
            case "White":
                i = 0;
                while(i < tshirts.size())
                {
                    Tshirt thisTshirt = tshirts.get(i);
                    if(thisTshirt.color == "White")
                    {
                        returnable.add(thisTshirt);
                    }
                }
                break;
            case "Yellow":
                i = 0;
                while(i < tshirts.size())
                {
                    Tshirt thisTshirt = tshirts.get(i);
                    if(thisTshirt.color == "Yellow")
                    {
                        returnable.add(thisTshirt);
                    }
                }
                break;
        }
        return returnable;
    }

    public static LinkedList<Tshirt> filterBySize(String size)
    {
        LinkedList<Tshirt> returnable = new LinkedList<Tshirt>();
        ListIterator<Tshirt> it = tshirts.listIterator();
        int i;
        switch (size)
        {
            case "S":
                i = 0;
                while(i < tshirts.size())
                {
                    Tshirt thisTshirt = tshirts.get(i);
                    if(thisTshirt.size == "S")
                    {
                        returnable.add(thisTshirt);
                    }
                }
                break;
            case "M":
                i = 0;
                while(i < tshirts.size())
                {
                    Tshirt thisTshirt = tshirts.get(i);
                    if(thisTshirt.size == "M")
                    {
                        returnable.add(thisTshirt);
                    }
                }
                break;
            case "L":
                i = 0;
                while(i < tshirts.size())
                {
                    Tshirt thisTshirt = tshirts.get(i);
                    if(thisTshirt.size == "L")
                    {
                        returnable.add(thisTshirt);
                    }
                }
                break;
            case "XL":
                i = 0;
                while(i < tshirts.size())
                {
                    Tshirt thisTshirt = tshirts.get(i);
                    if(thisTshirt.size == "XL")
                    {
                        returnable.add(thisTshirt);
                    }
                }
                break;

        }
        return returnable;
    }
}
