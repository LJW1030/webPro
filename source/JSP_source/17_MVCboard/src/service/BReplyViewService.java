package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;

public class BReplyViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int bid = Integer.parseInt(request.getParameter("bid"));
		BoardDao bDao = BoardDao.getInstance();
		request.setAttribute("reply_view", bDao.modify_reply_View(bid));
	}

}
