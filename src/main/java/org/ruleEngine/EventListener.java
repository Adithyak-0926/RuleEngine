package org.ruleEngine;

import java.util.concurrent.*;

public class EventListener {
    public boolean isHandlingStarted = false;
    public volatile boolean queryCounterTrigger;
    public volatile boolean memoryFillingStarted ;

//    public final ArrayBlockingQueue m_queue = new ArrayBlockingQueue<>();
    public ScheduledExecutorService eventHandlerExecutorService;
    public EventListener(){
        this.queryCounterTrigger = QueryCounter.isQueryCountingStarted();
        this.memoryFillingStarted = MemoryFiller.isMemoryFillingStarted();
        this.eventHandlerExecutorService = Executors.newSingleThreadScheduledExecutor();
    };
    public void startHandling( RuleManager ruleManager){
        eventHandlerExecutorService.scheduleAtFixedRate(new EventHandler(ruleManager), 5, 5, TimeUnit.SECONDS);
        isHandlingStarted = true;
    }
    public void init(RuleManager ruleManager){
        if(!isHandlingStarted){
            startHandling(ruleManager);
        }
    }

//    public void listen(Event event){
//        m_queue.add(event);
//    }

}
