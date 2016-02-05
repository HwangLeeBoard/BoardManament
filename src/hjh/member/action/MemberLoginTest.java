package hjh.member.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hjh.command.controll.Action;
import hjh.command.controll.Forward;
import hjh.member.db.MemberDAO;
import hjh.member.db.MemberDTO;

public class MemberLoginTest implements Action{
	@Override
	public Forward excute(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException {
		// TODO Auto-generated method stub
		Forward forward = new Forward();
		String email=request.getParameter("inputemail");
		String passwd=request.getParameter("inputpasswd");
		MemberDAO mDao = new MemberDAO();
		MemberDTO mDto = new MemberDTO();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		int result = mDao.loginChk(email, passwd);
		if (result==1) {
			mDto= mDao.selById(email);
			session.setAttribute("mem", mDto);
			out.println("1");//로그인 성공
			return null;
		}else if (result==2) {
			out.println("2");//패스워드가 틀립니다.
			return null;
			
		}else if (result==0) {
			out.println("0");//회원정보가 없습니다.
			
			return null;
		}
		
		
		return forward;
		
		
	}
}
