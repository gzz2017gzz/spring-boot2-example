package com.gzz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private FastFileStorageClient storageClient;

	@PostConstruct
	public void run() {
		String path = "D:/test.jpg";
		File file = new File(path);
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(storageClient.uploadFile(fileInputStream, file.length(), "jpg", null).getFullPath());
	}
}
