import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	//Commentaire de Nathanaël Debaque pour tester un commit

	public static void main (String[] args) throws IOException{
		File mutFile = new File("../tp1/Matrice_mutex.txt");
		File productMatrix = new File("Matrice_Products.txt");
		int eachProductSum[] = new int[5];
		Scanner scan = new Scanner(mutFile);
		String currentLine;
		String splitLine[];
		
		//To can write into the files
		FileWriter productsFw = new FileWriter(productMatrix);
		BufferedWriter productsOutput = new BufferedWriter(productsFw);
		
		while(scan.hasNext()){
			currentLine = scan.next();
			splitLine = currentLine.split(";");
			for(int i=0; i<splitLine.length;i++){
				eachProductSum[i] += Integer.parseInt(splitLine[i]);
			}
		}
		
		scan.close();
		
		for(int i=0;i<eachProductSum.length;i++){
			for(int j=0; j<eachProductSum.length;j++){
				productsOutput.write(Integer.toString(eachProductSum[i] + eachProductSum[j]));
				productsOutput.write(";");
			}
			productsOutput.write("\n");
		}
		productsOutput.flush();
		
		productsOutput.close();
	}
	
}
