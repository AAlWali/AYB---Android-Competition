package com.example.aybapplication;

import java.util.LinkedList;
import java.util.ListIterator;

public class Service {

    public String details;
    public boolean acquired;

    public static LinkedList<Service> services = new LinkedList<Service>();

    public static LinkedList<Service> filterBySize(boolean acq)
    {
        LinkedList<Service> returnable = new LinkedList<Service>();
        ListIterator<Service> it = services.listIterator();
        int i;
        if(acq)
        {
            i = 0;
            while (i < services.size()) {
                Service thisService = services.get(i);
                if (thisService.acquired) {
                    returnable.add(thisService);
                }
            }
        }
        if(!acq)
        {
                i = 0;
                while(i < services.size()) {
                    Service thisService = services.get(i);
                    if (!thisService.acquired) {
                        returnable.add(thisService);
                    }
                }

        }
        return returnable;
    }
}

