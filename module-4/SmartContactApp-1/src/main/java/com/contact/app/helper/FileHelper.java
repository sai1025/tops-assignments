package com.contact.app.helper;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileHelper {

	//private  final String dir=new ClassPathResource("static/images/").getFile().getAbsolutePath();
	private final String dir="C:/Users/Kalyan Krishna/Documents/workspace-spring-tool-suite-4-4.26.0.RELEASE/SmartContactApp-1/src/main/resources/static/images";
	public FileHelper() throws IOException {
		
	}
	public void fileUpload(MultipartFile file) throws IOException
	{

		System.out.println(dir);
		System.out.println(file.getOriginalFilename());
		
		Files.copy(file.getInputStream(),Paths.get(dir+File.separator+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);

	}

}
