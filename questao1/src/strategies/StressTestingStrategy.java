package strategies;

import core.RiskContext;

public class StressTestingStrategy implements RiskCalculationStrategy {

    @Override
    public String calculateRisk(RiskContext context) {
        double shockedValue = context.getPortfolioValue() * 0.7;
        return "[Stress Testing] Portfolio under stress: " + String.format("%.2f", shockedValue);
    }
}
