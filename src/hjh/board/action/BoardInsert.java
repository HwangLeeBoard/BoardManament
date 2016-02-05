package hjh.board.action;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import hjh.board.db.BoardDAO;
import hjh.board.db.BoardDTO;
import hjh.board.db.FIleDTO;
import hjh.board.db.FileDAO;
import hjh.command.controll.Action;
import hjh.command.controll.Forward;


public class BoardInsert implements Action {

	@Override
	public Forward excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getRealPath("file1");
		FileDAO fDao = new FileDAO();
		Forward forward = new Forward();
		File fileObj = null;
		int size = 1024 * 1024 * 10;
		String name = "";
		String filename = null;
		String origiginFileName = "";

		BoardDAO bDao = new BoardDAO();

		MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy()

		);

//		int board_code = Integer.parseInt(multi.getParameter("board_code"));
//		int categorys = Integer.parseInt(multi.getParameter("categorys"));
		String writer = multi.getParameter("writer");
		String passwd = multi.getParameter("passwd");
		String email = multi.getParameter("email");
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		String remote_addr = request.getRemoteAddr();
		String is_comment = "";
		String dateTime="";
		
		String is_notice = "";
		int likecnt = 0;
		int badcnt = 0;
		String is_reply = "";
		String is_private="";
		int fileCnt =0;
		int hits =0;
		int step =0;
		int levels =0;
		int seq =0;
		int member_seq =0;

		
		BoardDTO bDto = new BoardDTO(0, 0, 0, title, writer, passwd, email, content, remote_addr, dateTime, is_notice, likecnt, badcnt, is_comment, is_reply, is_private, seq, levels, step, fileCnt, hits, member_seq);
		
		bDao.insert(bDto);
		int boardnum = bDao.curIdx();
		
		int filesize;
		try {
			Enumeration files = multi.getFileNames();

			int i = 0;

			while (files.hasMoreElements()) {
				
				String f = (String) files.nextElement();
				fileObj = multi.getFile(f);
				filename = multi.getFilesystemName(f);
				filesize = 0;
				origiginFileName = multi.getOriginalFileName(f);
				FIleDTO fDto = new FIleDTO(0, boardnum, filename, filesize);
				fDao.insert(fDto);
				i++;
			}
		} catch (Exception e) {

		}
		forward.setDispacher(false);
		forward.setPath("List.do");
		
		return forward;

	}

}
