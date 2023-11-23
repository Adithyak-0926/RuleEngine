package org.ruleEngine;

import org.ruleEngine.Rule.Rule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RuleManager {

//    fired rules are nothing but fired events here
    public Queue<Rule> m_firedRules = new LinkedList<>();
    public ArrayList<Rule> m_allRules;
    public RuleManager(){
        this.m_allRules = new ArrayList<>();
    }
    public void addRule(Rule rule){
        m_allRules.add(rule);
    }
    public void removeRule(Rule rule){
        m_allRules.remove(rule);
    }
    public ArrayList<Rule> getRules(){
        return m_allRules;
    }
    public Queue<Rule> fillUpFiredRules(ArrayList<Rule> desiredRules){
        for(Rule rule : desiredRules){
//            if(event.isRuleEnabled()) {
                rule.ruleDefinition();
                if (rule.fireEvent()) {
                    m_firedRules.add(rule);
                }
//            }
        }
        return m_firedRules;
    }

}
