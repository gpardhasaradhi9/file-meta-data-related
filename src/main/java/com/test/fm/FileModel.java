package com.test.fm;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FileModel {
	@Id
	@GeneratedValue
	private Long fileId;
	private String fileName;
	private String contentType;
	private String createdBy;
	private Date createdDate;

	public FileModel() {
	}

	public FileModel(String fileName, String contentType, String createdBy) {
		super();
		this.fileName = fileName;
		this.contentType = contentType;
		this.createdBy = createdBy;
	}

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDate() {
		return FileCustomUtil.formatDate(createdDate);
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
}