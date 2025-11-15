package core;

public class RiskContext {

    private double portfolioValue;
    private double volatility;
    private double confidenceLevel;
    private int timeHorizonInDays;

    public RiskContext(double portfolioValue, double volatility, double confidenceLevel, int timeHorizonInDays) {
        this.portfolioValue = portfolioValue;
        this.volatility = volatility;
        this.confidenceLevel = confidenceLevel;
        this.timeHorizonInDays = timeHorizonInDays;
    }

    public double getPortfolioValue() { return portfolioValue; }
    public double getVolatility() { return volatility; }
    public double getConfidenceLevel() { return confidenceLevel; }
    public int getTimeHorizonInDays() { return timeHorizonInDays; }
}
