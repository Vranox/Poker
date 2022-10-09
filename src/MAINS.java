public enum MAINS {
    CARTEHAUTE("carte la plus haute"),
    PAIRE("paire"),
    DOUBLE_PAIRE("double paire"),
    BRELAN("brelan"),
    SUITE("suite"),
    COULEUR("couleur"),
    FULL("full"),
    CARRE("carré"),
    QUINTE_FLUSH("quinte flush");
    public final String label;

    private MAINS(String label) {
        this.label = label;
    }
}
