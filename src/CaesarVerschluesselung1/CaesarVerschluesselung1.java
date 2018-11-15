package CaesarVerschluesselung1;
import java.util.Scanner;

public class CaesarVerschluesselung1 {

	public static void main(String[] args) {
		int auswahl = 0;
		String text = "";
		Scanner input = new Scanner(System.in);
		System.out.println("Bitte geben Sie zuerst den Text ein, der ver- oder entschluesselt werden soll! (nur Buchstaben von A-Z, keine Umlaute)");
		text = input.nextLine();
		text = text.toUpperCase();
		System.out.println("M�chten Sie:");
		System.out.println("(1) den eingegebenen Text verschluesseln oder");
		System.out.println("(2) den eingegebenen Text entschluesseln?");
		System.out.println("Bitte geben Sie die entsprechende Zahl ein!");
		
		auswahl = input.nextInt();
		switch (auswahl) {
		case 1:
			verschluesseln(text);
			break;
		case 2: 
			entschluesseln(text);
			break;
		}
		
	}

	public static void verschluesseln(String text) {
		String Textverschluesselt = "";
		char zeichen = ' ';
		System.out.println("Bitte geben Sie den Schl�ssel als Zahl ein (Um wieviele Stellen soll das Alphabet verschoben werden? z.B. um 3 Stellen --> A wird zu D)");
		int verschiebung = eingabeSchluessel();
		
		
		for (int i = 0; i < text.length(); i++) {
			int a = text.charAt(i);
			if (a >= 65 && a <= 90) { //Wenn das Zeichen kein Buchstabe, sondern z.B. ein Ausrufezeichen oder Leerzeichen ist, soll es nicht verschl�sselt werden, sondern weiterhin im Klartext erscheinen
			int b = a + verschiebung;
			if (b > 90) {			//der Unicode als Dezimalzahl f�r den letzten Gro�buchstaben im Alphabet (Z) ist 90; wenn die Zahl dar�ber liegt, muss man also wieder zum Anfang des Alphabets zur�ckspringen (Z um 1 nach rechts verschoben ist A) https://unicode-table.com/de/#control-character
				b = b - 26;
			}
			zeichen = (char) b; } else {
				zeichen = text.charAt(i);
			}
			Textverschluesselt = Textverschluesselt + zeichen;
		}
		System.out.println("Entschl�sselter Text: " + Textverschluesselt);
		
	}

	public static void entschluesseln(String text) {
		String Textentschluesselt = "";
		char zeichen = ' ';
		System.out.println("Bitte geben Sie den Schl�ssel ein (Um wieviele Stellen wurde das Alphabet bei der Verschl�sselung verschoben?)");
		int verschiebung = eingabeSchluessel();
		
		for (int i = 0; i < text.length(); i++) { 
			int a = text.charAt(i);
			if (a >= 65 && a <= 90) { //da Sonderzeichen bei der Verschl�sselung nicht verschoben werden, d�rfen diese auch bei der Entschl�sselung nicht zur�ckverschoben werden
			int b = a - verschiebung;
			if (b < 65) {   //der Unicodewert als Zahl f�r den ersten Gro�buchstaben im Alphabet (A) ist 65; wenn die Zahl durch die Verschiebung darunter liegt, muss man ans Ende des Alphabets zur�ckspringen (A um 1 nach links verschoben ist Z)  https://unicode-table.com/de/#control-character
			b = b + 26;   
			}
			zeichen = (char) b; } else {
				zeichen = text.charAt(i);
			}
			Textentschluesselt = Textentschluesselt + zeichen;
	}
		System.out.println("Entschl�sselter Text: " + Textentschluesselt);
	}
	
	public static int eingabeSchluessel() {
		int verschiebung;
		Scanner in = new Scanner(System.in);
		verschiebung = in.nextInt();
		in.close();
		return verschiebung;
	}
}
