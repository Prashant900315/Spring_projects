package com.luv2code.springboot.cruddemo.Utils;

import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfWriter;
import com.luv2code.springboot.cruddemo.request.EmailServiceRequest;

import java.io.FileOutputStream;


public class GeneratePdfReport {
	
	public void pdfReport(EmailServiceRequest emailServiceRequest) {
        Utility util = new Utility();
        Document document = new Document();
        try
        {
        	String url = "C:\\pdf\\"+emailServiceRequest.getEmailUser().getUsername()+".pdf";
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(url));
            
          
            document.open();
            
            
            String filename = "C:\\pdf\\image.jpg"; 

            Image image = Image.getInstance(filename);
          //  image.setAbsolutePosition(100, 250);
            image.setAlignment(Image.MIDDLE);
            
            //document.add(new Paragraph(&quot;Styling Example&quot;));
         
            //Paragraph with color and font styles
          //  Paragraph paragraphOne = new Paragraph("new paragraph");
          //  document.add(paragraphOne);
         
            //Create chapter and sections
            Paragraph chapterTitle = new Paragraph("Course Detail Report");
            chapterTitle.setAlignment(Paragraph.ALIGN_CENTER);
            Paragraph chapterNewLine = new Paragraph("\n\n\n");
            chapterTitle.add(chapterNewLine);
            Chapter chapter1 = new Chapter(chapterTitle, 1);
            chapter1.setNumberDepth(0);
         
            
            
            
            String courseName=" Course Applied For: "+util.courseName(emailServiceRequest.getEmailSubject().getSubject());
            Paragraph sectionTitle = new Paragraph(courseName);
            Section section1 = chapter1.addSection(sectionTitle);
            
            Paragraph chapterNewLine2 = new Paragraph("\n\n\n");
            section1.add(chapterNewLine2);
         
            String username=emailServiceRequest.getEmailUser().getUsername();
            Paragraph sectionContent = new Paragraph("\nDear "+username+", ");
            section1.add(sectionContent);
            
            Paragraph chapterNewLine3 = new Paragraph("\n\n");
            section1.add(chapterNewLine3);
            
            Paragraph sectionContent2 = new Paragraph("We are pleased to announce that you are now a part of our organisation.");
            section1.add(sectionContent2);
            
            Paragraph sectionContent3 = new Paragraph("We will provide you the best faculty and materials for the mentioned course.");
            section1.add(sectionContent3);
            
            
            Paragraph sectionContent4 = new Paragraph("Thank you for applying for this course.");
            section1.add(sectionContent4);
            
            Paragraph chapterNewLine4 = new Paragraph("\n\n\n");
            section1.add(chapterNewLine4);
            
            Paragraph sectionContent5 = new Paragraph("Thanks & Regards");
            section1.add(sectionContent5);
            
            Paragraph chapterNewLine5 = new Paragraph("\n");
            section1.add(chapterNewLine5);
            
            Paragraph sectionContent6 = new Paragraph("Happy Course Services \nAnthony Mark\nGeneral Manager\n9988298293");
            section1.add(sectionContent6);
            document.add(image);
            document.add(chapter1);
         
            document.close();
            writer.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
	
}
}
