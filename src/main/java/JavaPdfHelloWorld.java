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

import org.apache.poi.xwpf.usermodel.*;
import org.apache.xmlbeans.XmlCursor;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.*;
import java.util.Scanner;

public class JavaPdfHelloWorld {

    public static void main(String[] args) {

       /*  OLD ONE createPDF();
        createDOCX();
        createTXT();*/

        Scanner scanner = new Scanner(System.in);

        System.out.println("Vyberte typ dokumentu, ktorý chcete vytvoriť (PDF - voľba 1 , DOCX - voľba 2, TXT - voľba 3):");
        String choice = scanner.nextLine().trim().toLowerCase();

        if (choice.equals("1")) {
            createPDF();
        } else if (choice.equals("2")) {
            createDOCX();
        } else if (choice.equals("3")) {
            createTXT();
        } else {
            System.out.println("Neplatná voľba. Vyberte si z PDF(1), DOCX(2) alebo TXT(3).");
        }

        scanner.close();
    }


    public static void createPDF() {
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("HelloWorld-PDF .pdf"));
            document.open();

            // Písmo s podporou diakritiky
            BaseFont baseFont = BaseFont.createFont("arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font = new Font(baseFont, 25);

            // Prida text s diakritikou do PDF
            Paragraph paragraph = new Paragraph("A Hello World PDF document with diacritics: šščťšť ľava 1 strana ", font);
            document.add(paragraph);

            document.close();
            writer.close();

            System.out.println("PDF bol úspešne vytvorený.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createDOCX() {
        try {
            XWPFDocument document = new XWPFDocument();
            FileOutputStream fos = new FileOutputStream("HelloWorld-DOCX.docx");


            // Vytvor odsek a spustite text s diakritikou
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();

            // font pre docx
            run.setFontFamily("Arial");

            // velkost
            run.setFontSize(25);

            run.setText("A Hello World DOCX document with diacritics: šščťšť ľava 2 strana  ");

            document.write(fos);
            fos.close();

            System.out.println("DOCX bol úspešne vytvorený.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createTXT() {
        try {
            String text = "A Hello World TXT document with diacritics: šščťšť ľava 3 strana ";
            FileOutputStream fos = new FileOutputStream("HelloWorld-TXT.txt");
            OutputStreamWriter writer = new OutputStreamWriter(fos, "UTF-8");
            writer.write(text);
            writer.close();
            fos.close();

            System.out.println("TXT bol úspešne vytvorený.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
