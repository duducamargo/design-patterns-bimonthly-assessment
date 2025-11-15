package strategies;

import core.RiskAlgorithmType;

public class RiskStrategyFactory {

    public static RiskCalculationStrategy createStrategy(RiskAlgorithmType type) {

        switch (type) {
            case VALUE_AT_RISK:
                return new VarRiskStrategy();
            case EXPECTED_SHORTFALL:
                return new ExpectedShortfallStrategy();
            case STRESS_TESTING:
                return new StressTestingStrategy();
            default:
                throw new IllegalArgumentException("Unknown risk algorithm type: " + type);
        }
    }
}
