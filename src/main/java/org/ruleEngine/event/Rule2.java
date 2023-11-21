package org.ruleEngine.event;

public class Rule2 implements Event{
    @Override
    public boolean isRuleEnabled() {
        return false;
    }

    @Override
    public void ruleDefinition() {

    }

    @Override
    public boolean fireRule() {
        return false;
    }

    @Override
    public void handle() {

    }
}
