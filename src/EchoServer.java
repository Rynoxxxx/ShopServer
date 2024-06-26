public class EchoServer extends Server {
    List warenkorb;
    Double preis = 0.0;

    public EchoServer(int pPort) {

        super(pPort);
        warenkorb = new List<String>();
    }

    @Override
    public void processNewConnection(String pClientIP, int pClientPort) {
        this.send(pClientIP, pClientPort, "Willkommen! Wählen sie eine Größe und eine Farbe für ihr T-Shirt.");
    }

    @Override
    public void processMessage(String pClientIP, int pClientPort, String pMessage) {
        String[] nachrichtTeil = pMessage.split(":");

        switch (nachrichtTeil[0]) {
            case "TSHIRT":
                this.send(pClientIP, pClientPort, "Die Größe ist " + nachrichtTeil[1] + ", die Farbe ist " + nachrichtTeil[2] + " und es kostet 19,99€! Bitte bestätigen sie die Bestellung.");
                String objekt = nachrichtTeil[0];
                String groesse = nachrichtTeil[1];
                String farbe = nachrichtTeil[2];
                preis = preis + 19.99;

                warenkorb.append(objekt + ", " + groesse + ", " + farbe + ", " + "Preis: 19.99€");
                break;

            case "BESTAETIGUNG":
                switch (nachrichtTeil[1]) {
                    case "ja":
                        this.send(pClientIP, pClientPort, "Vielen Dank für ihre Bestellung.");
                        break;
                    case "nein":
                        this.send(pClientIP, pClientPort, "Deine Bestellung wurde abgebrochen.");
                        break;
                    default:
                        this.send(pClientIP, pClientPort, "Bitte geben sie ja oder nein ein.");
                        break;
                }

            case "warenkorb":
                this.send(pClientIP, pClientPort, "Hier ist der Warenkorb:");
                for (warenkorb.toFirst(); warenkorb.hasAccess(); warenkorb.next()) {
                    this.send(pClientIP, pClientPort, warenkorb.getContent().toString());

                }
                this.send(pClientIP, pClientPort,"Gesamtpreis: "+preis+"€");
                break;

            default:
                this.send(pClientIP, pClientPort, "Korrigiere deine Nachricht!");
                break;
        }
    }

    @Override
    public void processClosingConnection(String pClientIP, int pClientPort) {

    }
}
