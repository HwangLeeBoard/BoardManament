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

public class MemberLogin implements Action{
	@Override
	public Forward excute(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException {
		// TODO Auto-generated method stub
		Forward forward = new Forward();
		String email=request.getParameter("inputemail");
		String passwd=request.getParameter("inputpasswd");
		System.out.println(email);
		MemberDAO mDao = new MemberDAO();
		MemberDTO mDto = new MemberDTO();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		int result = mDao.loginChk(email, passwd);
		
		if (result==1) {
			mDto= mDao.selById(email);
			session.setAttribute("mem", mDto);
			forward.setDispacher(false);
			forward.setPath("List.do");
		}else if (result==2) {
			out.println("<script>alert('패스워드가 틀립니다.');location.href='LoginForm.do'</script>");
			return null;
			
		}else if (result==0) {
			out.println("<script>alert('회원정보가 없습니다.');location.href='LoginForm.do'</script>");
			return null;
		}
		
		
		return forward;
		
		
	}
}
