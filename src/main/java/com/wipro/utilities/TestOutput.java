package com.wipro.utilities;

import java.io.FileWriter;
import java.io.IOException;

public class TestOutput {
	public static FileWriter writer;
	public static String folder = "/Users/SI20466403/eclipse-workspace/CapstoneTutorialsNinja/src/test/resources/test-output/";
	public static void writeMsgToFile(String loc, String data) throws IOException {
		writer = new FileWriter(folder + loc);
		writer.write(data);
		writer.close();
	}
}
