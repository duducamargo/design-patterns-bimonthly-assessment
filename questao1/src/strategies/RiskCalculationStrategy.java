package strategies;

import core.RiskContext;

public interface RiskCalculationStrategy {
    String calculateRisk(RiskContext context);
}
