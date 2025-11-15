package core;

public class NFeDocumento {

    private String xml;
    private String numero;
    private boolean certificadoValido;
    private boolean impostosCorretos;
    private boolean respostaSefazOk;

    public NFeDocumento(String xml, String numero) {
        this.xml = xml;
        this.numero = numero;
        this.certificadoValido = true;
        this.impostosCorretos = true;
        this.respostaSefazOk = true;
    }

    public String getXml() { return xml; }
    public String getNumero() { return numero; }
    public boolean isCertificadoValido() { return certificadoValido; }
    public boolean isImpostosCorretos() { return impostosCorretos; }
    public boolean isRespostaSefazOk() { return respostaSefazOk; }

    public void setCertificadoValido(boolean certificadoValido) {
        this.certificadoValido = certificadoValido;
    }

    public void setImpostosCorretos(boolean impostosCorretos) {
        this.impostosCorretos = impostosCorretos;
    }

    public void setRespostaSefazOk(boolean respostaSefazOk) {
        this.respostaSefazOk = respostaSefazOk;
    }
}
