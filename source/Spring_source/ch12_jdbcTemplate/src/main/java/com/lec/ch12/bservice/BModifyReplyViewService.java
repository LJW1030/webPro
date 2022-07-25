package com.lec.ch12.bservice;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.ch12.dao.BoardDao;

public class BModifyReplyViewService implements Service {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int bid = (Integer) map.get("bid");
		BoardDao bDao = BoardDao.getInstance();
		model.addAttribute("bDto", bDao.modifyView_replyView(bid));
		
	}

}
