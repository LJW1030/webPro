package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;

public class BModifySerivce implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int bid         = Integer.parseInt(request.getParameter("bid"));
		String bname    = request.getParameter("bname");
		String btitle   = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bip      = request.getRemoteAddr();
		BoardDao bDao = BoardDao.getInstance();
		request.setAttribute("modifyResult", bDao.modify(bid, bname, btitle, bcontent, bip));
	}

}
