public class TimeClient extends Client {

    public TimeClient(String pServerIP, int pServerPort) {
	super(pServerIP, pServerPort);
    }

    public void processMessage(String pMessage) {
	System.out.println("Empfange: " + pMessage);
    }

    public static void main(String[] args) {

	TimeClient tc = new TimeClient("titan", 13);
	
	if (tc.isConnected() == true) System.out.println("Verbindung hergestellt.");
	else { 
	    System.out.println("Verbindung fehlgeschlagen.");
	    System.exit(1);
	}

	tc.close();
    }
}