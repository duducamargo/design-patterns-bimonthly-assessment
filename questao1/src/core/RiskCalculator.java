package core;

import strategies.RiskCalculationStrategy;

public class RiskCalculator {

    private final RiskContext context;
    private RiskCalculationStrategy strategy;

    public RiskCalculator(RiskContext context) {
        this.context = context;
    }

    public void setStrategy(RiskCalculationStrategy strategy) {
        this.strategy = strategy;
    }

    public String calculateRisk() {
        if (strategy == null) {
            throw new IllegalStateException("No strategy defined.");
        }
        return strategy.calculateRisk(context);
    }
}
