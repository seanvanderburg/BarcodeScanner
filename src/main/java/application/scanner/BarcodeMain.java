package application.scanner;

import java.io.IOException;

/**
 * @author Sean 
 * main method, init barcodescanner
 */
public class BarcodeMain {
	public static void main(String[] args) {
		try {
			BarcodeScanner.scanCode();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
