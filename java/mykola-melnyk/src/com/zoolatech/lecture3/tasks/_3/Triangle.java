//package com.zoolatech.lecture3.tasks._3;
//
//public final class Triangle implements Shape {
//    double a;
//    double b;
//    double c;
//
//    public Triangle(double a, double b, double c) {
//        this.a = a;
//        this.b = b;
//        this.c = c;
//    }
//    @Override
//    public void findPerimeter() {
//        double perimeter = a + b + c;
//        System.out.println(perimeter);
//    }
//
//    @Override
//    public void findArea() {
//        double s = (a + b + c) / 2;
//        double temp = s * (s - a) * (s - b) * (s - c);
//        double area = Math.sqrt(temp);
//        System.out.println(area);
//    }
//
//    @Override
//    public String toString() {
//        return "Triangle{" +
//                "a=" + a +
//                ", b=" + b +
//                ", c=" + c +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null) return false;
//        if (getClass() != obj.getClass()) return false;
//        Triangle other = (Triangle) obj;
//        return a == other.a
//                && b == other.b
//                && c == other.c;
//    }
//}
