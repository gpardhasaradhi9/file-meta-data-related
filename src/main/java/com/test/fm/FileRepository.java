package com.test.fm;

import org.springframework.data.repository.CrudRepository;

public interface FileRepository extends CrudRepository<FileModel, Long> {
	public FileModel findByFileName(String fileName);
}