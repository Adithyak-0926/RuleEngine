package org.ruleEngine;

import org.ruleEngine.Rule.MemoryUsageRule;
import org.ruleEngine.Rule.QueryCountRule;

public class Main{

    public static void main(String[] args) {

        // HEAP SPACE -> 1GB
        // THRESHOLD NUMBER OF LONGS -> 33_554_432
        System.out.println("MAX HEAP SPACE: " + Runtime.getRuntime().maxMemory() / (1024 * 1024));
        System.out.println("HEAP USAGE 1: " + (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024));

        RuleManager ruleManager = new RuleManager();
        ruleManager.addRule(new MemoryUsageRule());
        ruleManager.addRule(new QueryCountRule());

        MemoryFiller memoryFiller = new MemoryFiller();
        memoryFiller.startAllocatingMemory();

        QueryCounter queryCounter = new QueryCounter();
        queryCounter.startCount();

        BackgroundServerStarter listener = new BackgroundServerStarter();
        listener.init(ruleManager);

        ruleManager.removeRule(new QueryCountRule());

        System.out.println("HEAP USAGE 2: " + (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024));

    }

    public static void allocateMemory() {

        long[][] memoryArray = new long[10_000][];

        try{
            for (int i = 0; i < memoryArray.length; i++) {
                memoryArray[i] = new long[10_000_000]; // Adjust the size of the sub-arrays as needed
                System.out.println("Memory allocated in this run: " + (memoryArray[i].length * 8) / (1024 * 1024) + " MB");
                System.out.println("HEAP USAGE: " + (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024));
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}