package com.sower.actions;

import java.io.File;

import com.opensymphony.xwork2.Action;

public class FileUploadAction implements Action 
{

		private File fileUpload;
		private String fileUploadContentType;
		private String fileUploadFileName;

		public String getFileUploadContentType() {
			return fileUploadContentType;
		}

		public void setFileUploadContentType(String fileUploadContentType) {
			this.fileUploadContentType = fileUploadContentType;
		}

		public String getFileUploadFileName() {
			return fileUploadFileName;
		}

		public void setFileUploadFileName(String fileUploadFileName) {
			this.fileUploadFileName = fileUploadFileName;
		}

		public File getFileUpload() {
			return fileUpload;
		}

		public void setFileUpload(File fileUpload) {
			this.fileUpload = fileUpload;
		}

		public String execute() throws Exception{

			System.out.println(fileUpload.getAbsolutePath());
			return SUCCESS;

		}

		public String display() {
			return NONE;
		}

	}