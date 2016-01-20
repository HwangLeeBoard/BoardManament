package hjh.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {

	DataSource ds;

	public MemberDAO() {
		Context ctx;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeAll(ResultSet rs, PreparedStatement ps, Connection con) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
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

	public PreparedStatement getSql(Connection con, PreparedStatement ps, String sql) throws SQLException {

		return ds.getConnection().prepareStatement(sql);
	}

	public void join(MemberDTO mDto) {
		Connection con = null;
		PreparedStatement ps = null;
		MemberDTO dto = new MemberDTO();
		String sql = "INSERT INTO MEMBER ( IDX,EMAIL,PASSWD,NAME,GENDER,PNUM,IP )"
				+ "VALUES ( MEMBER_SEQ.nextval, ?, ?, ?,? , ?, ?)";
		try {
			ps = getSql(con, ps, sql);
			ps.setString(1, mDto.getEmail());
			ps.setString(2, mDto.getPasswd());
			ps.setString(3, mDto.getName());
			ps.setString(4, mDto.getGender());
			ps.setString(5, mDto.getPnum());
			ps.setString(6, mDto.getIp());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(null, ps, con);
		}
	}

	public MemberDTO selById(String email) {
		MemberDTO memberDTO = new MemberDTO();
		String sql = "SELECT A.IDX," + "       A.EMAIL," + "       A.PASSWD," + "       A.NAME," + "       A.GENDER,"
				+ "       A.PNUM," + "       TO_CHAR(A.joindate,'yyyy-mm-dd') joindate,"
				+ "       TO_CHAR(A.LOGINTIME,'yyyy-mm-dd') LOGINTIME," + "       A.IP"
				+ "  FROM MEMBER A where email = ?";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			ps = getSql(con, ps, sql);
			ps.setString(1, email);
			rs = ps.executeQuery();

			if (rs.next()) {
				int idx = rs.getInt("idx");
				String passwd = rs.getString("passwd");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String pnum = rs.getString("pnum");
				String joindate = rs.getString("joindate");
				String logintime = rs.getString("logintime");
				String ip = rs.getString("ip");
				memberDTO = new MemberDTO(idx, email, passwd, name, gender, pnum, joindate, logintime, ip);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(null, ps, con);
		}
		return memberDTO;
	}

	public int loginChk(String email, String passwd) {
		int result = 0;
		MemberDTO chkDto = selById(email);
		

		if (chkDto.getEmail() != null) {

			if (chkDto.getEmail().equals(email) && chkDto.getPasswd().equals(passwd)) {
				result = 1; // 로그인 성공
			} else if (chkDto.getEmail().equals(email) && !chkDto.getPasswd().equals(passwd)) {
				result = 2; // 패스워드가 틀립니다.
			} else if (!chkDto.getEmail().equals(email)) {
				result = 0; // 회원정보가 없습니다.
			}
		}
		return result;

	}

	public int idChk(String email) {
		
		int result = 0;
		MemberDTO chkDto = selById(email);
		

		if (chkDto.getEmail() != null) {
			if (chkDto.getEmail().equals(email)) {
				result = 1; // 중복아이디
			}
		}
		return result;

	}
}
