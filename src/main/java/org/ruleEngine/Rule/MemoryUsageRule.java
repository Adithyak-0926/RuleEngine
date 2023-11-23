package org.ruleEngine.Rule;

public class MemoryUsageRule implements Rule {

    public boolean m_bIsRuleValid;
    public long m_lTotalMemoryInBytes = Runtime.getRuntime().maxMemory();

//    public boolean isRuleEnabled() {
//        return true;
//    }

    @Override
    public void ruleDefinition() {
        m_bIsRuleValid = Runtime.getRuntime().freeMemory() < 0.5 * m_lTotalMemoryInBytes;
    }

    @Override
    public boolean fireEvent() {
        return m_bIsRuleValid;
    }

    @Override
    public void handle() {
        System.out.println("*** Getting out of memory ***");
    }
}
