package com.ttf.A00_review;

import java.util.ArrayList;
import java.util.List;

public class TX032_FindMaxHappyValue {
    public static class Employee {
        int happy;
        List<Employee> nexts;

        public Employee(int happy) {
            this.happy = happy;
            this.nexts = new ArrayList<>();
        }
    }

    /**
     * return the Max Happy value for given Employee tree rooted as head.
     * The only constraint is you cannot invite the nodes adjacent with each other.
     */
    public int MaxHappyValue(Employee head) {
        return Math.max(process(head).withX, process(head).withoutX);
    }

    private Info process(Employee x) {
        if (x == null) {
            return new Info(0, 0);
        }
        int size = x.nexts.size();
        int withX = x.happy;
        int withoutX = 0;
        for (int i = 0; i < size; i++) {
            Info info = process(x.nexts.get(i));
            withX += info.withoutX;
            withoutX += Math.max(info.withX, info.withoutX);
        }

        return new Info(withX, withoutX);
    }

    private static class Info {
        public int withX;
        public int withoutX;

        public Info(int wx, int wix) {
            this.withX = wx;
            this.withoutX = wix;
        }

    }

    public int MaxHappyValue2(Employee head) {
        return 0;
    }
}
