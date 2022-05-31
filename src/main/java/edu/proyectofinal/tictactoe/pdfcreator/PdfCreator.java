package edu.proyectofinal.tictactoe.pdfcreator;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * <p>PdfCreator class.</p>
 *
 *
 * @version : 1.0
 * Class that creates the pdf
 */
public class PdfCreator {

        /**
         * Method which creates the pdf
         *
         * @param fileName - String
         * @param text     - String
         * @throws java.io.IOException - in some circunstancies
         * @throws com.itextpdf.text.DocumentException - in some circunstancies
         * @throws java.net.URISyntaxException - in some circunstancies
         */
        public void createPDF(String fileName, String text, String suggestion) throws IOException, DocumentException, URISyntaxException {

            Path path = Paths.get(ClassLoader.getSystemResource("static/img/icon.png").toURI());

            Document document = new Document();
            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(fileName + ".pdf"));

            document.open();
            Paragraph paragraph = createParagraph(text);
            Paragraph comment = createParagraph(suggestion);
            Image image = createImage(path);

            document.add(paragraph);
            document.add(comment);
            document.add(image);
            document.close();

        }

        /**
         * Method which creates the image that is going to be in the pdf
         *
         * @param path - Path
         * @return image - Image
         * @throws BadElementException
         * @throws IOException
         */
        private Image createImage(Path path) throws BadElementException, IOException {
            Image image = Image.getInstance(path.toAbsolutePath().toString());
            image.scalePercent(40);
            return image;
        }

        /**
         * Method which create and return the text which is going to be written in pdf
         *
         * @param text - Stirng
         * @return paragraph - Paragraph
         */
        private Paragraph createParagraph(String text) {
            Font font = FontFactory.getFont(FontFactory.HELVETICA, 16, BaseColor.BLACK);
            Paragraph paragraph = new Paragraph(text, font);
            paragraph.setSpacingAfter(25f);
            return paragraph;
        }

    }

