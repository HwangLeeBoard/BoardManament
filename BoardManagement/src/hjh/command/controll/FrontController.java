package hjh.command.controll;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hjh.board.action.BoardInsert;
import hjh.board.action.BoardList;
import hjh.board.action.BoardView;
import hjh.member.action.MemberJoin;
import hjh.member.action.MemberLogin;
import hjh.member.action.MemberLoginTest;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String ctx = request.getContextPath();
		String uri = request.getRequestURI();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String path = uri.substring(ctx.length());
		Action action = null;
		Forward forward = null;
		if (path.equals("/Insert.do")) {
			action = new BoardInsert();
			forward = action.excute(request, response);

		} else if (path.equals("/Write.do")) {
			forward = new Forward();
			forward.setPath("write.jsp");
			forward.setDispacher(true);
		
		} else if (path.equals("/List.do")) {
			action = new BoardList();
			forward = action.excute(request, response);

		} else if (path.equals("/View.do")) {
			action = new BoardView();
			forward= action.excute(request, response);

		} else if (path.equals("/MemberInsert.do")) {
			action = new MemberJoin();
			forward=action.excute(request, response);

		} else if (path.equals("/JoinForm.do")) {
			forward = new Forward();
			forward.setDispacher(true);
			forward.setPath("member_join.jsp");
			

		} else if (path.equals("/LoginForm.do")) {
			forward = new Forward();
			forward.setDispacher(true);
			forward.setPath("login_form.jsp");
			
		} else if (path.equals("/Login.do")) {
			action = new MemberLogin();
			forward=action.excute(request, response);

		} else if (path.equals("/Logout.do")) {
			HttpSession session = request.getSession();
			session.removeAttribute("mem");
			session.invalidate();
			forward = new Forward();
			forward.setDispacher(false);
			forward.setPath("List.do");
		}else if (path.equals("/Test.do")) {
			action = new MemberLoginTest();
			forward=action.excute(request, response);
		}
		
		
		if (forward != null) {
			if (forward.isDispacher() == false) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
			}
		}
		

	}

}
