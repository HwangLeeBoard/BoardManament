package hjh.board.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hjh.board.db.BoardDAO;
import hjh.board.db.BoardDTO;
import hjh.command.controll.Action;
import hjh.command.controll.Forward;

public class BoardList implements Action {

	@Override
	public Forward excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<BoardDTO> list = new ArrayList<>();
		BoardDAO dao = new BoardDAO();
		Forward forward = new Forward();
		int page= 0;
		list=dao.list(page);
		request.setAttribute("listDTO", list);
		
		forward.setDispacher(true);
		forward.setPath("list.jsp");
		return forward;

	}

}
