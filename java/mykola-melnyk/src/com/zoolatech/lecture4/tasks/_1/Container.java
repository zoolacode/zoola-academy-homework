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
            Container.this.value = firstValue;
        }
        public boolean hasValueChanged() {
            if (Container.this.value == firstValue) {
                return false;

            } else {
                return true;
            }
        }
    }
}
