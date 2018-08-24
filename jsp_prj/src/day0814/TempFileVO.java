package day0814;

import java.util.Date;

public class TempFileVO {

	private String fileName;
	private Date lastModified;
	private long fileSize;

	public TempFileVO() {
		super();
	}

	public TempFileVO(String fileName, Date lastModified, long fileSize) {
		super();
		this.fileName = fileName;
		this.lastModified = lastModified;
		this.fileSize = fileSize;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

}
