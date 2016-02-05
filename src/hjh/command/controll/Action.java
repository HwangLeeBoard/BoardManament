package hjh.command.controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	Forward excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
