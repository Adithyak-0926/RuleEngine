package org.ruleEngine.Rule;

import org.ruleEngine.QueryCounter;

public class QueryCountRule implements Rule{
//    volatile int m_IQueryCounter = QueryCounter.queryCounter;
    boolean isRuleValid;
//    @Override
//    public boolean isRuleEnabled() {
//        return true;
//    }
    @Override
    public void ruleDefinition() {
        isRuleValid = QueryCounter.queryCounter > 1000;
    }

    @Override
    public boolean fireEvent() {
        return isRuleValid;
    }

    @Override
    public void handle() {
      System.out.println("***Query count reached threshold***");
    }
}
