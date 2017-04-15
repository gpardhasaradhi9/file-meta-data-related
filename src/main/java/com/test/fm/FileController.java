package com.test.fm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {
	@Autowired
	private FileService fileService;

	@RequestMapping(method = RequestMethod.POST, value = "/file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public void saveFile(@RequestParam("file") MultipartFile file) {
		fileService.saveFile(file);
	}

	@RequestMapping("/file/{fileName:.+}")
	public FileModel getFile(@PathVariable String fileName) {
		return fileService.getFile(fileName);
	}

	@RequestMapping("/files")
	public List<FileModel> getAllFiles() {
		return fileService.getAllFiles();
	}
}
