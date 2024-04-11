package readwordfilewithjson;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadJSONFromWordFile {

	public static void main(String[] args) {
        try {
            File wordFile = new File("C:\\Users\\Ishaanjain\\Desktop\\Word\\Word.docx");
            FileInputStream fis = new FileInputStream(wordFile);
            XWPFDocument document = new XWPFDocument(fis);

            // Initialize regex patterns for delimiters
            Pattern startPattern = Pattern.compile("<!--JSON_START-->");
            Pattern endPattern = Pattern.compile("<!--JSON_END-->");
            
            System.out.println(startPattern);
            System.out.println(endPattern);

            boolean insideJSON = false;
            StringBuilder jsonBuilder = new StringBuilder();

            for (XWPFParagraph paragraph : document.getParagraphs()) {
                for (XWPFRun run : paragraph.getRuns()) {
                    String text = run.getText(0);

                    Matcher startMatcher = startPattern.matcher(text);
                    Matcher endMatcher = endPattern.matcher(text);
                    

                    if (startMatcher.find()) {
                        insideJSON = true;
                        jsonBuilder = new StringBuilder();
                    }

                    if (insideJSON) {
                        jsonBuilder.append(text);
                    }

                    if (endMatcher.find()) {
                        insideJSON = false;
                        String jsonText = jsonBuilder.toString()
                            .replace("<!--JSON_START-->", "")
                            .replace("<!--JSON_END-->", "");

                        // Parse the JSON content
                        ObjectMapper objectMapper = new ObjectMapper();
                        JsonNode jsonNode = objectMapper.readTree(jsonText);

                        // Iterate through JSON key-value pairs
                        jsonNode.fields().forEachRemaining(entry -> {
                            String key = entry.getKey();
                            String value = entry.getValue().asText();
                            System.out.println("Key: " + key + ", Value: " + value);
                        });
                    }
                }
            }

            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
