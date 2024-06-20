public class EchoServer extends Server {

    public EchoServer(int pPort) {
        super(pPort);
    }

    @Override
    public void processNewConnection(String pClientIP, int pClientPort) {
        this.send(pClientIP, pClientPort, "Willkommen! Wählen sie eine Größe und eine Farbe für ihr T-Shirt.");
    }

    @Override
    public void processMessage(String pClientIP, int pClientPort, String pMessage) {
        String[] nachrichtTeil = pMessage.split(":");
        if (nachrichtTeil[0].equals("TSHIRT")) {
            this.send(pClientIP, pClientPort, "Die Größe ist " + nachrichtTeil[1] + ", die Farbe ist " + nachrichtTeil[2] + " und es kostet 19,99€! Bitte bestätigen sie die Bestellung.");
        }else if(nachrichtTeil[0].equals("BESTAETIGUNG")){
            if(nachrichtTeil[1].equals("ja")){
                this.send(pClientIP,pClientPort,"Vielen Dank für ihre Bestellung.");

            } else if (nachrichtTeil[1].equals("nein")) {
                this.send(pClientIP,pClientPort, "Deine Bestellung wurde abgebrochen.");
            }else (this.send(pClientIP, pClientPort, "Bitte geben sie ja oder nein ein.");

        }
    }

    @Override
    public void processClosingConnection(String pClientIP, int pClientPort) {

    }
}
