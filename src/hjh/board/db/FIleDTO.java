package hjh.board.db;

public class FIleDTO {
	private int idx ;
	private int board_idx ;
	private String filename ;
	private int filesize ;
	public FIleDTO() {
		// TODO Auto-generated constructor stub
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getFilesize() {
		return filesize;
	}
	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}
	public FIleDTO(int idx, int board_idx, String filename, int filesize) {
		super();
		this.idx = idx;
		this.board_idx = board_idx;
		this.filename = filename;
		this.filesize = filesize;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idx;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FIleDTO other = (FIleDTO) obj;
		if (idx != other.idx)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "FIleDTO [idx=" + idx + ", board_idx=" + board_idx + ", filename=" + filename + ", filesize=" + filesize
				+ "]";
	}
	
}
