package com.zoolatech.lecture4.tasks._1;

import java.util.Objects;

public class Container {
    String anyValue;

    public String getAnyValue() {
        return anyValue;
    }

    public void setAnyValue(String anyValue) {
        this.anyValue = anyValue;
    }

    public Container(String anyValue){
        this.anyValue = anyValue;
    }

    class ContainerUpdatesListener{
        String newAnyValue;

        public ContainerUpdatesListener(){
            Container.this.anyValue = newAnyValue;
        }

        public boolean hasValueChanged(){
            return !Objects.equals(getAnyValue(), newAnyValue);
        }
    }

    public static void main(String[] args) {
        String value = "jeej";
        Container container = new Container(value);
        Container.ContainerUpdatesListener containerUpdatesListener = container.new ContainerUpdatesListener();
        System.out.println(containerUpdatesListener.hasValueChanged());
        container.setAnyValue("fjjf");
        System.out.println(containerUpdatesListener.hasValueChanged());
    }
}
