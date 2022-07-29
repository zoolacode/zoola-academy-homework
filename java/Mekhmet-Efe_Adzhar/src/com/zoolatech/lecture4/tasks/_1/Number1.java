package com.zoolatech.lecture4.tasks._1;

/*
Create a class Container that holds some value (choose any type) and an inner class ContainerUpdatesListener.
The Container should accept a value during an object creation, and provide methods to get or set a value.
The ContainerUpdatesListener should provide a single method hasValueChanged, that returns a boolean value.
The method needs to return true if the value inside of the container has changed after the associated
instance of the ContainerUpdatesListener class was created, and false - otherwise.
(e.g., new Container -> new ContainerUpdatesListener -> hasValueChanged (false) -> container.setValue -> hasValueChanged(true))
 */

public class Number1 {
    public static void main(String[] args) {

        Container container = new Container(5);
        Container.ContainerUpdatesListener containerUpdatesListener = container.new ContainerUpdatesListener();
        container.setNumber(3);
        System.out.println(containerUpdatesListener.hasValueChanged());
        container.setNumber(3);
        System.out.println(containerUpdatesListener.hasValueChanged());
    }
}

class Container {

    private int number;

    ContainerUpdatesListener containerUpdatesListener = new ContainerUpdatesListener();

    public Container(int number) {
        this.number = number;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    class ContainerUpdatesListener {
        int integer = number;

        public boolean hasValueChanged() {
            return Container.this.number != integer;
        }
    }
}