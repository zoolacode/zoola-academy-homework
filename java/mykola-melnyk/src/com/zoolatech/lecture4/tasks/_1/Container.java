package com.zoolatech.lecture4.tasks._1;

public class Container {
    private int value;

    public Container (int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    class ContainerUpdatesListener {
        private int firstValue;

        public ContainerUpdatesListener() {
            firstValue = value;
        }
        public boolean hasValueChanged() {
            return Container.this.value != firstValue;
        }
    }
}
