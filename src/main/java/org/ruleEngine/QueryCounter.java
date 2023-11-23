package org.ruleEngine;

import java.util.Timer;
import java.util.TimerTask;

public class QueryCounter {
    public static volatile int queryCounter = 0;
    public static volatile boolean queryCountingStarted = false;
    public void startCount() {
        queryCountingStarted = true;
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                queryCounter++;
            }
        };
        timer.scheduleAtFixedRate(task, 0, 10);
    }
    public static boolean isQueryCountingStarted(){
        return queryCountingStarted;
    }
}

