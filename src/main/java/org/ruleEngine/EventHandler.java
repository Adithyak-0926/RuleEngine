package org.ruleEngine;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class EventHandler implements Runnable{
    @Override
    public void run() {
       RuleManager ruleManager = new RuleManager();
       ruleManager.fillUpFiredRules();
       ScheduledExecutorService service = Executors.newScheduledThreadPool(3);

    }
}
