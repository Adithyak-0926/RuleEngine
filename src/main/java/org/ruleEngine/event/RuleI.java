package org.ruleEngine.event;

public class RuleI implements Event{

    public boolean isRuleValid;
    public long totalMemory = Runtime.getRuntime().totalMemory();
    public boolean isRuleEnabled() {
        return true;
    }
    @Override
    public void ruleDefinition(){
        if(Runtime.getRuntime().freeMemory() < 0.1*totalMemory){
           isRuleValid = true;
        }
        else {
            isRuleValid = false;
        }
    }
    @Override
    public boolean fireRule() {
        return isRuleValid;
    }

    @Override
    public void handle() {
         System.out.println("Getting out of memory");
    }
}
