package com.ocr.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ocr.model.OcrFile;

public interface OcrFileRepository extends MongoRepository<OcrFile, String>{

}
