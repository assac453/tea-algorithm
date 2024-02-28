package com.assac453.tea;

import com.assac453.tea.file.FileManager;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class TeaApplication implements CommandLineRunner {

	private final FileManager fileManager;

	public static void main(String[] args) {
		SpringApplication.run(TeaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		fileManager.encrypt();
		fileManager.decrypt();
	}
}
