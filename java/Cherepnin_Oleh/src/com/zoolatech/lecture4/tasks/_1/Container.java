package com.zoolatech.lecture4.tasks._1;

public class Container {
    private String value;
    private ContainerUpdatesListener innerContainer;

    {
        innerContainer = new ContainerUpdatesListener();
    }

    public Container(String value) {
        this.value = value;
        System.out.println(innerContainer.hasValueChanged(value));
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        System.out.println(innerContainer.hasValueChanged(value));
        this.value = value;
    }

    class ContainerUpdatesListener {
        boolean hasValueChanged(String newValue) {
            if (value == null)
                return false;
            return !value.equals(newValue);
        }
    }
}
