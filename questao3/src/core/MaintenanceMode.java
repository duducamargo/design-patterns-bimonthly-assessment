package core;

public class MaintenanceMode {

    private boolean ativo = false;

    public void ativar() {
        ativo = true;
        System.out.println("Modo MANUTENÇÃO ativado!");
    }

    public void desativar() {
        ativo = false;
        System.out.println("Modo MANUTENÇÃO desativado!");
    }

    public boolean isAtivo() {
        return ativo;
    }
}
