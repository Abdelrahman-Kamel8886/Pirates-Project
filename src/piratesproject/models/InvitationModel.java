
package piratesproject.models;

/**
 *
 * @author Taj
 */
public class InvitationModel {
    String from ;
    String to ;
    String SenderIP ; 
    
    public InvitationModel(){
    }
    public InvitationModel(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSenderIP() {
        return SenderIP;
    }

    public void setSenderIP(String SenderIP) {
        this.SenderIP = SenderIP;
    }
    
}
