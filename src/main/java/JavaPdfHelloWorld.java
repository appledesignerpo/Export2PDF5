import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class JavaPdfHelloWorld {

    public static void main(String[] args) {
        createPDF();
        createDOCX();
    }

    public static void createPDF() {
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));
            document.open();

            // Písmo s podporou diakritiky
            BaseFont baseFont = BaseFont.createFont("arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font = new Font(baseFont, 25);

            // Prida text s diakritikou do PDF
            Paragraph paragraph = new Paragraph("A Hello World PDF document with diacritics: šščťšť ľava 1 strana ", font);
            document.add(paragraph);

            document.close();
            writer.close();

            System.out.println("PDF created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createDOCX() {
        try {
            XWPFDocument document = new XWPFDocument();
            FileOutputStream fos = new FileOutputStream("HelloWorld.docx");


            // Vytvor odsek a spustite text s diakritikou
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();

            // Set the font to Arial
            run.setFontFamily("Arial");

            // Set the font size (optional)
            run.setFontSize(25);

            run.setText("A Hello World DOCX document with diacritics: šščťšť ľava 2 strana  ");

            document.write(fos);
            fos.close();

            System.out.println("DOCX created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
