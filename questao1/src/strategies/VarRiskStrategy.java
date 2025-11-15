package strategies;

import core.RiskContext;

public class VarRiskStrategy implements RiskCalculationStrategy {

    @Override
    public String calculateRisk(RiskContext context) {
        double dummyVar = context.getPortfolioValue()
                * context.getVolatility()
                * Math.sqrt(context.getTimeHorizonInDays())
                * context.getConfidenceLevel();

        return "[VaR] Estimated Value at Risk: " + String.format("%.2f", dummyVar);
    }
}
