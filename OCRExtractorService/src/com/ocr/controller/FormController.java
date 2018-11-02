package com.ocr.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ocr.model.OcrFile;
import com.ocr.repository.OcrFileRepository;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

@RestController
@RequestMapping("/ocr")
public class FormController {

	OcrFile form;
	@Value("${savedir}")
	private String savdir;

	@Autowired
	OcrFileRepository fileRepository;

	@PostMapping(value = "/forms")
	public ResponseEntity addForm(@RequestParam("Form_Name") String form_Name,
			@RequestParam("Upload_Form") MultipartFile upload_File) {

		if (form_Name == null || form_Name.isEmpty()) {
			System.out.println("form name is null");

		} else if (upload_File == null || upload_File.isEmpty()) {
			System.out.println("uploaded folder is null");
		} else {
			try {
				int word = 1;
				char[] ch = form_Name.toCharArray();
				for (int i = 0; i < form_Name.length(); ++i) {
					if (Character.isLetter(ch[i]) || Character.isSpaceChar(ch[i]) || Character.isDigit(ch[i])) {
						word++;
					}
				}

				if (word <= 25) {

					form.setFormName(form_Name);
					form.setUploadForm(upload_File.getOriginalFilename());
					form.setImagePath(savdir);
					
					Properties prop = new Properties();
					InputStream input = null;
					
					input = new FileInputStream("D:\\eclipseWorkspace\\OCRExtractorService\\src\\com\\ocr\\resources\\config.properties");
					
					prop.load(input);
					System.out.println(prop.getProperty("tessdata"));
					File img= new File(upload_File.getName());
				//	File img= new File("D:\\contactReview\\NDA\\OCRService\\images\\eurotext.pdf");
					ITesseract i = new Tesseract();
					i.setDatapath(prop.getProperty("tessdata"));
					
					try{
						String result= i.doOCR(img);
						System.out.println(result);
						form.setFileData(result);
						}
					catch(TesseractException e){
						
					}

					form = fileRepository.save(form);
				} else {
					System.out.println("File should be less than 25 character");
				}
			} catch (Exception e) {

			}

		}
		return new ResponseEntity(form, HttpStatus.OK);
	}

}
