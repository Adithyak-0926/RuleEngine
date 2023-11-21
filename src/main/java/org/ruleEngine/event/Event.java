package org.ruleEngine.event;

import java.util.Queue;

public interface Event {
     boolean isRuleEnabled();
     void ruleDefinition();
     boolean fireRule();
     void handle();

}
