package hjh.board.db;

import java.io.Serializable;

public class BoardDTO implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private int idx; // 글 인덱스
	private int board_code; // 게시판 종류의 번호
	private int categorys; // 게시판 종류의 번호
	private String title; // 타이틀
	private String writer; // 작성자
	private String passwd; // 비번
	private String email; // email
	private String content; // 내용
	private String remote_addr; // 접속 ip
	private String dateTime; // 쓴날자
	private String is_notice; // 공지글
	private int likecnt; // 좋아요
	private int badcnt; // 좋아요
	private String is_comment; // 코멘트 허용
	private String is_reply; // 답글허용
	private String is_private; // 공개 허용
	private int seq; // 답글의 원글번호
	private int levels; // 답글의 들여쓰기
	private int step; // 답글의 표기순서
	private int fileCnt; // 파일
	private int hits; // 조회수
	private int member_seq; // 맴버의 기본키

	public BoardDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getBoard_code() {
		return board_code;
	}

	public void setBoard_code(int board_code) {
		this.board_code = board_code;
	}

	public int getCategorys() {
		return categorys;
	}

	public void setCategorys(int categorys) {
		this.categorys = categorys;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRemote_addr() {
		return remote_addr;
	}

	public void setRemote_addr(String remote_addr) {
		this.remote_addr = remote_addr;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getIs_notice() {
		return is_notice;
	}

	public void setIs_notice(String is_notice) {
		this.is_notice = is_notice;
	}

	public int getLikecnt() {
		return likecnt;
	}

	public void setLikecnt(int likecnt) {
		this.likecnt = likecnt;
	}

	public int getBadcnt() {
		return badcnt;
	}

	public void setBadcnt(int badcnt) {
		this.badcnt = badcnt;
	}

	public String getIs_comment() {
		return is_comment;
	}

	public void setIs_comment(String is_comment) {
		this.is_comment = is_comment;
	}

	public String getIs_reply() {
		return is_reply;
	}

	public void setIs_reply(String is_reply) {
		this.is_reply = is_reply;
	}

	public String getIs_private() {
		return is_private;
	}

	public void setIs_private(String is_private) {
		this.is_private = is_private;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getLevels() {
		return levels;
	}

	public void setLevels(int levels) {
		this.levels = levels;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getFileCnt() {
		return fileCnt;
	}

	public void setFileCnt(int fileCnt) {
		this.fileCnt = fileCnt;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public int getMember_seq() {
		return member_seq;
	}

	public void setMember_seq(int member_seq) {
		this.member_seq = member_seq;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BoardDTO(int idx, int board_code, int categorys, String title, String writer, String passwd, String email,
			String content, String remote_addr, String dateTime, String is_notice, int likecnt, int badcnt,
			String is_comment, String is_reply, String is_private, int seq, int levels, int step, int fileCnt, int hits,
			int member_seq) {
		super();
		this.idx = idx;
		this.board_code = board_code;
		this.categorys = categorys;
		this.title = title;
		this.writer = writer;
		this.passwd = passwd;
		this.email = email;
		this.content = content;
		this.remote_addr = remote_addr;
		this.dateTime = dateTime;
		this.is_notice = is_notice;
		this.likecnt = likecnt;
		this.badcnt = badcnt;
		this.is_comment = is_comment;
		this.is_reply = is_reply;
		this.is_private = is_private;
		this.seq = seq;
		this.levels = levels;
		this.step = step;
		this.fileCnt = fileCnt;
		this.hits = hits;
		this.member_seq = member_seq;
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
		BoardDTO other = (BoardDTO) obj;
		if (idx != other.idx)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BoardDTO [idx=" + idx + ", board_code=" + board_code + ", categorys=" + categorys + ", title=" + title
				+ ", writer=" + writer + ", passwd=" + passwd + ", email=" + email + ", content=" + content
				+ ", remote_addr=" + remote_addr + ", dateTime=" + dateTime + ", is_notice=" + is_notice + ", likecnt="
				+ likecnt + ", badcnt=" + badcnt + ", is_comment=" + is_comment + ", is_reply=" + is_reply
				+ ", is_private=" + is_private + ", seq=" + seq + ", levels=" + levels + ", step=" + step + ", fileCnt="
				+ fileCnt + ", hits=" + hits + ", member_seq=" + member_seq + "]";
	}

}