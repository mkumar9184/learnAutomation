package utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HTMLTableBuilder {

	private int columns;
	private final StringBuilder table = new StringBuilder();
	public static String HTML_START = "<html>";
	public static String HTML_END = "</html>";
	public static String TABLE_START_BORDER = "<table border=\"2\">";
	public static String TABLE_START = "<table>";
	public static String TABLE_END = "</table>";
	public static String HEADER_START = "<th>";
	public static String HEADER_END = "</th>";
	public static String ROW_START = "<tr>";
	public static String ROW_END = "</tr>";
	public static String COLUMN_START = "<td>";
	public static String COLUMN_END = "</td>";

	public HTMLTableBuilder(String header, boolean border, int rows, int columns) {
		this.columns = columns;
		header ="<center>"+ header+"</center>";
		if (header != null) {
			table.append("<u><b> ");
			table.append(header+"<br> <br>");
			table.append("</b></u>");
		}
		table.append(HTML_START);
		table.append(border ? TABLE_START_BORDER : TABLE_START);
		table.append(TABLE_END);
		table.append(HTML_END);
	}

	/**
	 * @param values
	 */
	public void addTableHeader(String... values) {
		if (values.length != columns) {
			System.out.println("Error column lenth");
		} else {
			int lastIndex = table.lastIndexOf(TABLE_END);
			if (lastIndex > 0) {
				StringBuilder sb = new StringBuilder();
				sb.append(ROW_START);
				for (String value : values) {
					HEADER_START = "<th bgcolor=\"Gray\">";
					sb.append(HEADER_START);
					sb.append(value);
					sb.append(HEADER_END);
				}
				sb.append(ROW_END);
				table.insert(lastIndex, sb.toString());
			}
		}
	}

	/**
	 * @param values
	 */
	public void addRowValues(String imagepath, String... values) {
		if (values.length != columns) {
			System.out.println("Error column lenth");
		} else {
			int lastIndex = table.lastIndexOf(ROW_END);
			if (lastIndex > 0) {
				int index = lastIndex + ROW_END.length();
				StringBuilder sb = new StringBuilder();
				sb.append(ROW_START);
				for (String value : values) {
					if (value.equalsIgnoreCase("Pass")) {
						COLUMN_START = "<td bgcolor=\"Green\">";
						sb.append(COLUMN_START);
						sb.append(value);
						sb.append(COLUMN_END);

					} else if (value.equalsIgnoreCase("Fail")) {
						COLUMN_START = "<td bgcolor=\"red\">";
						sb.append(COLUMN_START);
						sb.append(value);
						sb.append(COLUMN_END);
					} else if (value.equalsIgnoreCase("ClickLog")) {

						COLUMN_START = "<td><a href=" + imagepath + "> ClickLog </a></td>";
						sb.append(COLUMN_START);

						sb.append(COLUMN_END);
					}

					else {
						COLUMN_START = "<td bgcolor=\"white\">";
						sb.append(COLUMN_START);
						sb.append(value);
						sb.append(COLUMN_END);
					}
					System.out.println(value);

				}
				sb.append(ROW_END);
				table.insert(index, sb.toString());
			}
		}
	}

	/**
	 * @return
	 */
	public String build() {
		return table.toString();
	}

	public static void Htmfilecreateor(String filepath, String table) {

		FileWriter fWriter = null;
		BufferedWriter writer = null;
		// ("F://fileNameTest.html"
		try {
			fWriter = new FileWriter(filepath);
			writer = new BufferedWriter(fWriter);
			writer.write(table);
			// writer.newLine(); //this is not actually needed for html files -
			// can make your code more readable though
			writer.close(); // make sure you close the writer object
		} catch (Exception e) {
			// catch any exceptions here
		}

	}

	public String CreateDirectory(String Folderpath, String folderName) {

		SimpleDateFormat dateforamte = new SimpleDateFormat("dd_MM_YY");

		Date d = new Date();

		// project directory
		String workingDirectory = Folderpath;
		String dir = workingDirectory + folderName + "_" + dateforamte.format(d);

		System.out.println("Final file directory : " + dir);

		// create a directory in the path

		File file = new File(dir);

		if (!file.exists()) {
			file.mkdir();
			System.out.println("Directory is created!");
		} else {
			System.out.println("Directory is already existed!");
		}
		return dir;
	}

	/**
	 * @param args
	 */
	/*
	 * public static void main(String[] args) {
	 * 
	 * 
	 * HTMLTableBuilder htmlBuilder = new HTMLTableBuilder("Table Result", true,
	 * 3, 4); htmlBuilder.addTableHeader("1H", "2H", "3H","H4");
	 * htmlBuilder.addRowValues("1", "HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH",
	 * "Fail","Email"); htmlBuilder.addRowValues("4", "5", "Pass","Email");
	 * htmlBuilder.addRowValues("9", "8", "Pass","Email");
	 * htmlBuilder.addRowValues("9", "8", "Pass","EmailTest");
	 * 
	 * String table = htmlBuilder.build();
	 * Htmfilecreateor("F://fileNameTest.html",table);
	 * 
	 * /* HTMLTableBuilder htmlBuilder1 = new HTMLTableBuilder("Table Result",
	 * true, 3, 4); htmlBuilder1.addTableHeader("1H", "2H", "3H","H4");
	 * htmlBuilder1.addRowValues("1", "TTTTTTTTT", "Fail","Email");
	 * htmlBuilder1.addRowValues("4", "5", "Pass","EmailTEst");
	 * htmlBuilder1.addRowValues("9", "8", "Pass","EmailT");
	 * htmlBuilder1.addRowValues("9", "8", "Pass","EmailTest1");
	 * 
	 * String table1 = htmlBuilder1.build();
	 * Htmfilecreateor("F://fileNameTest1.html",table1);
	 * 
	 * }
	 */

}
