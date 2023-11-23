package org.ruleEngine;

import org.ruleEngine.Rule.Rule;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class EventHandler implements Runnable{
    public RuleManager ruleManager;
    public EventHandler(RuleManager ruleManager){
        this.ruleManager = ruleManager;
    }
    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Override
    public void run() {
        System.out.println("Running Event Handler, HEAP USAGE: " + (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024));
        System.out.println("Query count is: " + QueryCounter.queryCounter);
//        ArrayList<Event> desiredRules = ruleManager.getRules();
        Queue<Rule> firedRules = ruleManager.fillUpFiredRules(ruleManager.getRules());
        if(!firedRules.isEmpty()){
           for(Rule event : firedRules) {
               executorService.submit(() -> EventHandler.this.handleEvent(event));
           }
        }
        firedRules.clear();
    }
    public void handleEvent(Rule event){
        event.handle();
    }

}
