package org.ruleEngine.Rule;

public interface Rule {
//     boolean isRuleEnabled();
     void ruleDefinition();
     boolean fireEvent();
     void handle();

}
