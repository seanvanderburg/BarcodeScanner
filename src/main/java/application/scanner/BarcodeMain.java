package application.scanner;

import java.io.IOException;

public class BarcodeMain {
	public static void main(String[] args) {
		try {
			BarcodeScanner.scanCode();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

