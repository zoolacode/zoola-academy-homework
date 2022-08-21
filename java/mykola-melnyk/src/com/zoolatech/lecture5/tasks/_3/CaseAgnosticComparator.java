package com.zoolatech.lecture5.tasks._3;

import java.util.Comparator;

public class CaseAgnosticComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if (o1.equalsIgnoreCase(o2)) {
            return 0;
        }
        return o1.compareTo(o2);
    }
}
