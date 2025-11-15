package core;

public abstract class DocumentValidator {

    private DocumentValidator next;
    private final String name;
    private final long timeoutMs;
    private final boolean requiresAllPreviousPass;

    public DocumentValidator(String name, long timeoutMs, boolean requiresAllPreviousPass) {
        this.name = name;
        this.timeoutMs = timeoutMs;
        this.requiresAllPreviousPass = requiresAllPreviousPass;
    }

    public DocumentValidator linkWith(DocumentValidator next) {
        this.next = next;
        return next;
    }

    public final void handle(ValidationContext context) {

        if (context.isCircuitOpen()) {
            context.addResult(new ValidationResult(
                    name,
                    false,
                    true,
                    "Chain circuit is open. Validator skipped."
            ));
            return;
        }

        if (requiresAllPreviousPass && !context.isAllPreviousPassed()) {
            context.addResult(new ValidationResult(
                    name,
                    false,
                    true,
                    "Previous validation failed. Conditional validator skipped."
            ));
        } else {
            long start = System.currentTimeMillis();
            boolean success;
            String message;

            try {
                success = doValidate(context);
                message = success ? "Validation succeeded." : "Validation failed.";
            } catch (Exception e) {
                success = false;
                message = "Exception during validation: " + e.getMessage();
            }

            long elapsed = System.currentTimeMillis() - start;
            if (elapsed > timeoutMs) {
                success = false;
                message = "Validation timeout: " + elapsed + "ms (limit " + timeoutMs + "ms)";
            }

            context.addResult(new ValidationResult(name, success, false, message));

            if (context.getFailuresCount() >= 3) {
                context.openCircuit();
                System.out.println("[CIRCUIT BREAKER] 3 or more validations failed. Chain interrupted.");
            }
        }

        if (next != null && !context.isCircuitOpen()) {
            next.handle(context);
        }
    }

    protected abstract boolean doValidate(ValidationContext context);

    protected String getName() {
        return name;
    }
}
