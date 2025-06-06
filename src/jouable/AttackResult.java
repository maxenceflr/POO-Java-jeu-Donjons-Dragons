package jouable;

public class AttackResult {

    private final ActionResult m_status;
    private final int m_jetAttaque;
    private final int m_degats;

    public AttackResult(ActionResult status, int jetDes, int degats) {
        this.m_status = status;
        this.m_jetAttaque = jetDes;
        this.m_degats = degats;
    }

    public ActionResult getStatus() { return m_status; }
    public int getJetAttaque() { return m_jetAttaque; }
    public int getDegats() { return m_degats; }
}
