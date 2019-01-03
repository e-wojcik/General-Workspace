import java.io.File;
import java.io.IOException;

import com.healthmarketscience.jackcess.ColumnBuilder;
import com.healthmarketscience.jackcess.DataType;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Table;
import com.healthmarketscience.jackcess.TableBuilder;

public class ChipGameDataBase {

	public String fileName;
	public static Database dataBase;
	public static Table table;
	public static void main(String args[]){
		
		
		
		
		
		

	
		
	}
public void createChipDatabase(String name){
		
		
		File file = new File(name);
		try {
			Database db = new DatabaseBuilder(file)
					.setFileFormat(Database.FileFormat.V2000)
					.create();
			dataBase = db;
		} catch (IOException e) {
			System.err.println("Error in Creating Database");
			e.printStackTrace();
		}
		
		
	}
public  void createTable(String tableName){
	try {
		 table = new TableBuilder(tableName)
				.addColumn(new ColumnBuilder("Match", DataType.TEXT))
				.addColumn(new ColumnBuilder("Player1_Name",DataType.TEXT))
				.addColumn(new ColumnBuilder("Player1_Score",DataType.INT))
				.addColumn(new ColumnBuilder("Player2_Name",DataType.TEXT))
				.addColumn(new ColumnBuilder("Player2_Score",DataType.TEXT))
				.addColumn(new ColumnBuilder("Winner Of Match",DataType.TEXT))
				.toTable(dataBase);
		
		
	} catch (IOException e) {
		System.err.println("Theres an error in creating Table");
		e.printStackTrace();
	}
	
}
public void addData(String matchName, String player1Name, int player1Score, String player2Name, int player2Score, String winner){
	
	try {
		table.addRow(matchName,player1Name,player1Score,player2Name,player2Score,winner);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
	
	
}
