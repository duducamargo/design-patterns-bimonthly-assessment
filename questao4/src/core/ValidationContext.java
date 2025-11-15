package core;

import java.util.ArrayList;
import java.util.List;

public class ValidationContext {

    private final NFeDocumento documento;
    private final List<ValidationResult> results = new ArrayList<>();
    private final List<Runnable> rollbackActions = new ArrayList<>();

    private int failuresCount = 0;
    private boolean circuitOpen = false;
    private boolean allPreviousPassed = true;

    public ValidationContext(NFeDocumento documento) {
        this.documento = documento;
    }

    public NFeDocumento getDocumento() { return documento; }

    public void addResult(ValidationResult result) {
        results.add(result);
        if (!result.isSkipped() && !result.isSuccess()) {
            failuresCount++;
            allPreviousPassed = false;
        }
    }

    public List<ValidationResult> getResults() { return results; }

    public int getFailuresCount() { return failuresCount; }

    public boolean isCircuitOpen() { return circuitOpen; }

    public void openCircuit() { this.circuitOpen = true; }

    public boolean isAllPreviousPassed() { return allPreviousPassed; }

    public void registerRollbackAction(Runnable action) {
        rollbackActions.add(action);
    }

    public boolean hasFailures() {
        return failuresCount > 0;
    }

    public void rollbackAll() {
        System.out.println("\n[ROLLBACK] Iniciando rollback de ações...");
        for (int i = rollbackActions.size() - 1; i >= 0; i--) {
            rollbackActions.get(i).run();
        }
    }
}
