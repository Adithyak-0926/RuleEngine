package org.ruleEngine;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MemoryFiller{
    public static volatile boolean memoryFillingStarted ;
    ExecutorService memoryBloaterExecutorService = Executors.newSingleThreadExecutor();
    public void startAllocatingMemory(){
        memoryFillingStarted = true;
        memoryBloaterExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                allocateMemory();
            }
        });
    }
    public static boolean isMemoryFillingStarted(){
        return memoryFillingStarted;
    }
    public static void allocateMemory() {

        long[][] memoryArray = new long[10_000][];

        try{
            for (int i = 0; i < memoryArray.length; i++) {
                memoryArray[i] = new long[10_000_000]; // Adjust the size of the sub-arrays as needed
//                System.out.println("Memory allocated in this run: " + (memoryArray[i].length * 8) / (1024 * 1024) + " MB");
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
