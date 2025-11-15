package core;

public class ValidationResult {

    private final String validatorName;
    private final boolean success;
    private final boolean skipped;
    private final String message;

    public ValidationResult(String validatorName, boolean success, boolean skipped, String message) {
        this.validatorName = validatorName;
        this.success = success;
        this.skipped = skipped;
        this.message = message;
    }

    public String getValidatorName() { return validatorName; }
    public boolean isSuccess() { return success; }
    public boolean isSkipped() { return skipped; }
    public String getMessage() { return message; }

    @Override
    public String toString() {
        return "[" + validatorName + "] "
                + (skipped ? "SKIPPED" : (success ? "OK" : "FAIL"))
                + " - " + message;
    }
}
