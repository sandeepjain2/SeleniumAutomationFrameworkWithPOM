package readwordfilewithjson;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJSONFromWordFile1 {

	public static void main(String[] args) {
		try {
			File wordFile = new File("C:\\Users\\Ishaanjain\\Desktop\\Word\\Word.docx");
			FileInputStream fis = new FileInputStream(wordFile);
			XWPFDocument document = new XWPFDocument(fis);

			StringBuilder extractedText = new StringBuilder();

			// Extract plain text from Word document
			for (XWPFParagraph paragraph : document.getParagraphs()) {
				for (XWPFRun run : paragraph.getRuns()) {
					extractedText.append(run.getText(0));
				}
			}

			String plainText = extractedText.toString();

			// Define a regular expression pattern for JSON-like content
			Pattern jsonPattern = Pattern.compile("\\{[^{}]*\\}");

			// Find and process JSON-like content
			Matcher matcher = jsonPattern.matcher(plainText);
			ObjectMapper objectMapper = new ObjectMapper();

			while (matcher.find()) {
				String potentialJson = matcher.group();

				try {
					JsonNode jsonNode = objectMapper.readTree(potentialJson);

					// Process the JSON content as needed
					System.out.println("Extracted JSON: " + jsonNode.toString());
					
					// Iterate through JSON key-value pairs
                    jsonNode.fields().forEachRemaining(entry -> {
                        String key = entry.getKey();
                        String value = entry.getValue().asText();
                        System.out.println("Key: " + key + ", Value: " + value);
                    });					
					
				} catch (IOException e) {
					// Handle invalid JSON if needed
					System.err.println("Invalid JSON: " + potentialJson);
				}
			}

			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
