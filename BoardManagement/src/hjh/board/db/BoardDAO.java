package hjh.board.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BoardDAO {
	DataSource dataFactory;

	public BoardDAO() {
		Context ctx;
		try {
			ctx = new InitialContext();
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public void reply(int idx, int board_code, int categorys, String writer, String passwd, String email, String title,
			String content, String remote_addr, String dateTime, String is_notice, String is_like, String is_comment,
			String is_reply, String is_private, int fileCnt, int hits, int step, int levels, int seq, int member_seq) {
		// TODO Auto-generated method stub
		increaseReplyStep(seq, step);
		String sql = "insert into board (idx, title, writer, content, seq, step, levels, board_code, ";
		sql += "categorys, passwd, email, remote_addr )";
		sql += "values (board_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) ";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = dataFactory.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, writer);
			pstmt.setString(3, content);
			pstmt.setInt(4, seq);
			pstmt.setInt(5, step + 1);
			pstmt.setInt(6, levels + 1);
			pstmt.setInt(7, board_code);
			pstmt.setInt(8, categorys);
			pstmt.setString(9, passwd);
			pstmt.setString(10, email);
			pstmt.setString(11, remote_addr);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, con);
		}
	}

	public void insert(BoardDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into board (idx, board_code, categorys, writer, ";
		sql += "passwd, email, title, content, remote_addr, seq)";
		sql += " values( idx_seq.nextval , ?, ?, ?, ?, ?, ?, ?, ?,  idx_seq.currval)";
		try {

			pstmt = getCon(con, pstmt, sql);
			pstmt.setInt(1, dto.getBoard_code());
			pstmt.setInt(2, dto.getCategorys());
			pstmt.setString(3, dto.getWriter());
			pstmt.setString(4, dto.getPasswd());
			pstmt.setString(5, dto.getEmail());
			pstmt.setString(6, dto.getTitle());
			pstmt.setString(7, dto.getContent());
			pstmt.setString(8, dto.getRemote_addr());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, con);
		}

	}

	public int curIdx() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int max = 0;
		String sql = "SELECT  max(idx) FROM board";
		try {
			ps = getCon(con, ps, sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				max = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return max;
	}

	public ArrayList<BoardDTO> list(int page) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BoardDTO> dto = new ArrayList<BoardDTO>();
		String sql = "SELECT A.IDX, " + "A.BOARD_CODE," + "    A.CATEGORYS," + "       A.TITLE," + "       A.WRITER,"
				+ "       A.PASSWD," + "       A.EMAIL," + "       A.CONTENT," + "       A.REMOTE_ADDR,"
				+ "       to_char(A.DATE_TIME,'yyyy-mm-dd') DATE_TIME, " + "       A.IS_NOTICE,"
				+ "       A.likecnt,A.badcnt," + "       A.IS_COMMENT," + "       A.IS_REPLY," + "       A.IS_PRIVATE,"
				+ "       A.SEQ," + "       A.LEVELS," + "       A.STEP," + "       A.FILECNT," + "       A.HITS,"
				+ "       A.MEMBER_SEQ  FROM BOARD A order by A.seq desc, A.step asc";
		try {
			pstmt = getCon(con, pstmt, sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int idx = rs.getInt("idx");
				int board_code = rs.getInt("board_code");
				int categorys = rs.getInt("categorys");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String passwd = rs.getString("passwd");
				String email = rs.getString("email");
				String content = rs.getString("content");
				String remote_addr = rs.getString("remote_addr");
				String dateTime = rs.getString("date_Time");
				String is_notice = rs.getString("is_notice");
				int likecnt = rs.getInt("likecnt");
				int badcnt = rs.getInt("badcnt");
				String is_comment = rs.getString("is_comment");
				String is_reply = rs.getString("is_reply");
				String is_private = rs.getString("is_private");
				int seq = rs.getInt("seq");
				int levels = rs.getInt("levels");
				int step = rs.getInt("step");
				int fileCnt = rs.getInt("fileCnt");
				int hits = rs.getInt("hits");
				int member_seq = rs.getInt("member_seq");
				dto.add(new BoardDTO(idx, board_code, categorys, title, writer, passwd, email, content, remote_addr,
						dateTime, is_notice, likecnt, badcnt, is_comment, is_reply, is_private, seq, levels, step,
						fileCnt, hits, member_seq));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, con);
		}
		return dto;
	}

	public PreparedStatement getCon(Connection con, PreparedStatement ps, String sql) throws SQLException {
		con = dataFactory.getConnection();
		ps = con.prepareStatement(sql);
		return ps;
	}

	public void delete(int selectNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "delete board where idx = " + selectNum;
		try {
			con = dataFactory.getConnection();
			con.prepareStatement(sql).executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeAll(null, pstmt, con);
	}

	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void increaseReplyStep(int seq, int step) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update board set step = step + 1 where seq = ? and step > ? ";
		try {
			con = dataFactory.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seq);
			pstmt.setInt(2, step);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, con);
		}

	}

	public void increaseReadCnt(int idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update board set hits = hits + 1 where idx = ?";
		try {
			con = dataFactory.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, con);
		}

	}

	public BoardDTO getDto(int idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDTO dto = new BoardDTO();
		String sql = "SELECT A.IDX, " + "A.BOARD_CODE," + "    A.CATEGORYS," + "       A.TITLE," + "       A.WRITER,"
				+ "       A.PASSWD," + "       A.EMAIL," + "       A.CONTENT," + "       A.REMOTE_ADDR,"
				+ "       to_char(A.DATE_TIME,'yyyy-mm-dd') DATE_TIME, " + "       A.IS_NOTICE,"
				+ "       A.likecnt,A.badcnt," + "       A.IS_COMMENT," + "       A.IS_REPLY," + "       A.IS_PRIVATE,"
				+ "       A.SEQ," + "       A.LEVELS," + "       A.STEP," + "       A.FILECNT," + "       A.HITS,"
				+ "       A.MEMBER_SEQ  FROM BOARD A where idx =? order by A.seq desc, A.step asc";
		try {
			pstmt = getCon(con, pstmt, sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int board_code = rs.getInt("board_code");
				int categorys = rs.getInt("categorys");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String passwd = rs.getString("passwd");
				String email = rs.getString("email");
				String content = rs.getString("content");
				String remote_addr = rs.getString("remote_addr");
				String dateTime = rs.getString("date_Time");
				String is_notice = rs.getString("is_notice");
				int likecnt = rs.getInt("likecnt");
				int badcnt = rs.getInt("badcnt");
				String is_comment = rs.getString("is_comment");
				String is_reply = rs.getString("is_reply");
				String is_private = rs.getString("is_private");
				int seq = rs.getInt("seq");
				int levels = rs.getInt("levels");
				int step = rs.getInt("step");
				int fileCnt = rs.getInt("fileCnt");
				int hits = rs.getInt("hits");
				int member_seq = rs.getInt("member_seq");
				dto = new BoardDTO(idx, board_code, categorys, title, writer, passwd, email, content, remote_addr,
						dateTime, is_notice, likecnt, badcnt, is_comment, is_reply, is_private, seq, levels, step,
						fileCnt, hits, member_seq);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, con);
		}
		return dto;
	}

}