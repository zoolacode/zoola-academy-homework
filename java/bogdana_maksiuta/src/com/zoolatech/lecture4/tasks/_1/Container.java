package com.zoolatech.lecture4.tasks._1;

public class Container {
    private int value;

    public Container(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int codeNumber) {
        this.value = codeNumber;
    }

    class ContainerUpdatesListener {
        private int valueForChange;

        public ContainerUpdatesListener() {
            this.valueForChange = value;
        }

        Boolean hasValueChanged() {
            boolean isValueChanged = valueForChange != value;
            System.out.println(isValueChanged);
            return isValueChanged;
        }
    }
}
