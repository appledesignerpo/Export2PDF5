import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class JavaPdfHelloWorld {
    public static void main(String[] args) {
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));
            document.open();

            // podpora diakritiky
            BaseFont baseFont = BaseFont.createFont("arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font = new Font(baseFont, 19);

            // prida diakritiku
            Paragraph paragraph = new Paragraph("A Hello World PDF document with diacritics: šščťšť ľava strana", font);
            document.add(paragraph);

            document.close();
            writer.close();

            System.out.println("PDF created successfully.");
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }
}
