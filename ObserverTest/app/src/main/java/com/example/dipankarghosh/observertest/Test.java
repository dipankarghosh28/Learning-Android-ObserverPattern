package com.example.dipankarghosh.observertest;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * Observer Pattern
 * Subject(or observable) class, any changes to this object will ne notified to all the observers of this calss
 */
public class Test extends Observable {

    private String name = "Dipankar Ghosh";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        setChanged(); //to indicate that change has happened
        notifyObservers(); // to notify the observers aboout the change, update method will be called in the observer calss
    }
}
