package com.haji.suada.visitorstracker;

import com.haji.suada.visitorstracker.model.data.Visitor;

import java.util.ArrayList;
import java.util.List;

public class TestDataGenerator {

    /**
     * Generates a dummy visitor
     * @return
     */
    public static Visitor generateVisitor() {
        Visitor visitor = new Visitor();
        visitor.setVisitorName("Penny Wanjiru");
        visitor.setVisitingWho("Suada Haji");
        visitor.setVisitedDate("2018-08-28-22:02:33");
        return visitor;
    }

    /**
     * Generates a list of Visitors with {count} items
     * @param count - number of dummy visitors to generate
     */
    public static List<Visitor> generateVisitorList(int count) {
        List<Visitor> visitors = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            visitors.add(generateVisitor());
        }
        return visitors;
    }

}
