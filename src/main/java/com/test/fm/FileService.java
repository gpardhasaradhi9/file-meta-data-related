package com.test.fm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
	@Autowired
	private FileRepository fileRepository;

	public void saveFile(MultipartFile file) {
		FileModel fileModel = new FileModel();
		boolean isFileSaveError = false;

		fileModel.setFileName(file.getOriginalFilename());
		fileModel.setContentType(file.getContentType());
		fileModel.setCreatedBy(file.getName());
		fileModel.setCreatedDate(new Date());
		fileModel = fileRepository.save(fileModel);

		if (fileModel.getFileId() != null) {
			try (OutputStream out = new FileOutputStream(new File(FileCustomUtil.FILE_STORE_LOCATION + "\\" + file.getOriginalFilename()))) {
				byte[] fileContent = file.getBytes();
				out.write(fileContent);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				isFileSaveError = true;
				e.printStackTrace();
			}
		}

		if (isFileSaveError) {
			fileRepository.delete(fileModel);
		}

	}

	public FileModel getFile(String fileName) {
		return fileRepository.findByFileName(fileName);
	}

	public List<FileModel> getAllFiles() {
		List<FileModel> fileModels = new ArrayList<>();
		fileRepository.findAll().forEach(fileModels::add);
		return fileModels;
	}
}
