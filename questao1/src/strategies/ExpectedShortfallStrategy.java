package strategies;

import core.RiskContext;

public class ExpectedShortfallStrategy implements RiskCalculationStrategy {

    @Override
    public String calculateRisk(RiskContext context) {
        double base = context.getPortfolioValue()
                * context.getVolatility()
                * context.getConfidenceLevel();

        double dummyEs = base * 1.2;

        return "[ES] Expected Shortfall: " + String.format("%.2f", dummyEs);
    }
}
