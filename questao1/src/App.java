import core.RiskAlgorithmType;
import core.RiskCalculator;
import core.RiskContext;
import strategies.RiskStrategyFactory;

public class App {

    public static void main(String[] args) {

        RiskContext context = new RiskContext(
                1_000_000.0,
                0.15,
                0.95,
                10
        );

        RiskCalculator calculator = new RiskCalculator(context);

        System.out.println("=== Risk Analysis System (Strategy Pattern) ===");

        calculator.setStrategy(
                RiskStrategyFactory.createStrategy(RiskAlgorithmType.VALUE_AT_RISK)
        );
        System.out.println(calculator.calculateRisk());

        calculator.setStrategy(
                RiskStrategyFactory.createStrategy(RiskAlgorithmType.EXPECTED_SHORTFALL)
        );
        System.out.println(calculator.calculateRisk());

        calculator.setStrategy(
                RiskStrategyFactory.createStrategy(RiskAlgorithmType.STRESS_TESTING)
        );
        System.out.println(calculator.calculateRisk());
    }
}
