package com.zoolatech.lecture4.tasks._1;

/**
 * Create a class Container that holds some value (choose any type) and an inner class ContainerUpdatesListener.
 * The Container should accept a value during an object creation, and provide methods to get or set a value.
 * The ContainerUpdatesListener should provide a single method hasValueChanged, that returns a boolean value.
 * The method needs to return true if the value inside of the container has changed after the associated instance of
 * the ContainerUpdatesListener class was created, and false - otherwise. (e.g., new Container ->
 * new ContainerUpdatesListener -> hasValueChanged (false) -> container.setValue -> hasValueChanged(true))
 */
public class TaskOne {
    public static void main(String[] args) {
        Container container = new Container("test");
        Container.ContainerUpdatesListener updatesListener = container.new ContainerUpdatesListener();
        System.out.println(updatesListener.hasValueChanged());
        container.setValue("test2");
        System.out.println(updatesListener.hasValueChanged());

    }
}

