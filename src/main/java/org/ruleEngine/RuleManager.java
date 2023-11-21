package org.ruleEngine;

import org.ruleEngine.event.Event;
import org.ruleEngine.event.Rule2;
import org.ruleEngine.event.RuleI;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RuleManager {
    public static Queue<Event> firedRules = new LinkedList<>();
    public static ArrayList<Event> allRules;
    public void fillUpFiredRules(){
        allRules.add(new RuleI());
        allRules.add(new Rule2());
        for(Event event : allRules){
            if(event.isRuleEnabled() && event.fireRule()){
                firedRules.add(event);
            }
        }
    }

}
