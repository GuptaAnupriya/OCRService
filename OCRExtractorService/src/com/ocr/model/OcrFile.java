package com.ocr.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Ocr_File")
public class OcrFile {
	@Id
	private String formId;
	private String formName;
	private String uploadForm;
	private String imagePath;
	private String FileData;
	
	public String getFileData() {
		return FileData;
	}
	public void setFileData(String fileData) {
		FileData = fileData;
	}
	public String getFormId() {
		return formId;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	}
	public String getFormName() {
		return formName;
	}
	public void setFormName(String formName) {
		this.formName = formName;
	}
	public String getUploadForm() {
		return uploadForm;
	}
	public void setUploadForm(String uploadForm) {
		this.uploadForm = uploadForm;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
}
