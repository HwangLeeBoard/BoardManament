package hjh.member.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hjh.command.controll.Action;
import hjh.command.controll.Forward;
import hjh.member.db.MemberDAO;
import hjh.member.db.MemberDTO;

public class MemberJoin implements Action {

	@Override
	public Forward excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MemberDAO mDao = new MemberDAO();
		Forward forward = new Forward();
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		int result =0;
		
		result = mDao.idChk(email);
		
		if (result==1) {
			out.println("<script>alert('중복된 아이디가 있습니다.');</script>");
			forward.setDispacher(false);
			forward.setPath("JoinForm.do");
		}else{
			String passwd = request.getParameter("passwd");
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String pnum = request.getParameter("pnum");
			String joindate = null;
			String logintime = null;
			String ip = request.getRemoteAddr();
			MemberDTO mDto = new MemberDTO(0, email, passwd, name, gender, pnum, joindate, logintime, ip);
			mDao.join(mDto);
			forward.setDispacher(false);
			forward.setPath("List.do");
		}
		return forward;
		
		
		

	}

}






