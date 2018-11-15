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
		System.out.println("Möchten Sie:");
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
		System.out.println("Bitte geben Sie den Schlüssel als Zahl ein (Um wieviele Stellen soll das Alphabet verschoben werden? z.B. um 3 Stellen --> A wird zu D)");
		int verschiebung = eingabeSchluessel();
		
		
		for (int i = 0; i < text.length(); i++) {
			int a = text.charAt(i);
			if (a >= 65 && a <= 90) { //Wenn das Zeichen kein Buchstabe, sondern z.B. ein Ausrufezeichen oder Leerzeichen ist, soll es nicht verschlüsselt werden, sondern weiterhin im Klartext erscheinen
			int b = a + verschiebung;
			if (b > 90) {			//der Unicode als Dezimalzahl für den letzten Großbuchstaben im Alphabet (Z) ist 90; wenn die Zahl darüber liegt, muss man also wieder zum Anfang des Alphabets zurückspringen (Z um 1 nach rechts verschoben ist A) https://unicode-table.com/de/#control-character
				b = b - 26;
			}
			zeichen = (char) b; } else {
				zeichen = text.charAt(i);
			}
			Textverschluesselt = Textverschluesselt + zeichen;
		}
		System.out.println("Entschlüsselter Text: " + Textverschluesselt);
		
	}

	public static void entschluesseln(String text) {
		String Textentschluesselt = "";
		char zeichen = ' ';
		System.out.println("Bitte geben Sie den Schlüssel ein (Um wieviele Stellen wurde das Alphabet bei der Verschlüsselung verschoben?)");
		int verschiebung = eingabeSchluessel();
		
		for (int i = 0; i < text.length(); i++) { 
			int a = text.charAt(i);
			if (a >= 65 && a <= 90) { //da Sonderzeichen bei der Verschlüsselung nicht verschoben werden, dürfen diese auch bei der Entschlüsselung nicht zurückverschoben werden
			int b = a - verschiebung;
			if (b < 65) {   //der Unicodewert als Zahl für den ersten Großbuchstaben im Alphabet (A) ist 65; wenn die Zahl durch die Verschiebung darunter liegt, muss man ans Ende des Alphabets zurückspringen (A um 1 nach links verschoben ist Z)  https://unicode-table.com/de/#control-character
			b = b + 26;   
			}
			zeichen = (char) b; } else {
				zeichen = text.charAt(i);
			}
			Textentschluesselt = Textentschluesselt + zeichen;
	}
		System.out.println("Entschlüsselter Text: " + Textentschluesselt);
	}
	
	public static int eingabeSchluessel() {
		int verschiebung;
		Scanner in = new Scanner(System.in);
		verschiebung = in.nextInt();
		in.close();
		return verschiebung;
	}
}
