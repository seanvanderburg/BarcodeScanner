package application.scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import application.restclient.ClientApplication;

/**
 * @author Sean
 * barcodescanner, scans bottle barcodes
 */
public class BarcodeScanner {

	private static String drinkName;
	private static String bottleType;
	private static String dateScanned;
	
	/**
	 * scan barcode string, barcode scanner should use key registration followed by enter. add current scanned date 
	 * @throws IOException
	 */
	public static void scanCode() throws IOException {
		while (true) {

			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			System.out.print("Barcode scan ready \n");

			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();

			drinkName = br.readLine();
			dateScanned = dateFormat.format(date);
			bottleType = "beer";


			System.out.println(drinkName + "\n");
			ClientApplication.addBottle(dateScanned, drinkName, bottleType);
		}
	}
	
}
