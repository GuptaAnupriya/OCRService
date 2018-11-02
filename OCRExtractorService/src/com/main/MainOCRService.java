/*package com.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class MainOCRService {
public static void main(String[] args) throws IOException {
	Properties prop = new Properties();
	InputStream input = null;
	
	input = new FileInputStream("D:\\contactReview\\NDA\\OCRService\\resources\\config.properties");
	
	prop.load(input);
	System.out.println(prop.getProperty("tessdata"));
	
	File img= new File("D:\\contactReview\\NDA\\OCRService\\images\\eurotext.pdf");
	ITesseract i = new Tesseract();
	i.setDatapath(prop.getProperty("tessdata"));
	
	try{
		String result= i.doOCR(img);
		System.out.println(result);
		}
	catch(TesseractException e){
		
	}
}
}
*/