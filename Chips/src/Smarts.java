import java.io.File;
import java.io.IOException;

import com.healthmarketscience.jackcess.ColumnBuilder;
import com.healthmarketscience.jackcess.DataType;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Table;
import com.healthmarketscience.jackcess.TableBuilder;

/**
 * Program to create a simple Access Database of two fields and four records for
 * people and their IQs
 * 
 * @author Eric Wojcik
 * @version 08 April 2017
 */
public class Smarts {
	public static void main(String args[]) {
		try {
			File file = new File("first.mdb");
			Database db = new DatabaseBuilder(file)
					.setFileFormat(Database.FileFormat.V2010)
					.create();
			Table table = new TableBuilder("Smarts")
					.addColumn(new ColumnBuilder("Name", DataType.TEXT))
					.addColumn(new ColumnBuilder("IQ", DataType.INT))
					.toTable(db);
			table.addRow("Eric", 180);
			table.addRow("Adam", 100);
			table.addRow("Mike", 90);
			table.addRow("Lisa", 120);
			db.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}