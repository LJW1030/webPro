package com.lec.ch19.service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.lec.ch19.dao.MemberDao;
import com.lec.ch19.dto.Member;
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private JavaMailSenderImpl mailSender;
	@Override
	public int confirm(String mid) {
		return memberDao.confirm(mid);
	}

	@Override
	public int join(final Member member, HttpSession session) {
		//member.getName()에게 메일보내기, member insert, session에 mid attribute 추가하기
		MimeMessagePreparator message = new MimeMessagePreparator() {
			String content = "<div style=\"width:500px; margin: 0 auto;\">\n" + 
					"<h1 style=\"color:blue;\">"+ member.getMname() +"님 회원가입 감사합니다</h1>\n" + 
					"	<div>\n" + 
					"		<p>아무개 사이트에서만 사용가능한 감사쿠폰을 드립니다</p>\n" + 
					"		<p>\n" + 
					"			<img src=\"http://localhost:8090/ch19/img/coupon.jpg\">\n" + 
					"		</p>\n" + 
					"	</div>\n" + 
					"	<div>\n" + 
					"		<p style=\"color:red;\">빨간 글씨 부분</p>\n" + 
					"		<p style=\"color:blue;\">파란 글씨 부분</p>\n" + 
					"		<img src=\"D:/webPro/google.jpg\">\n" + 
					"	</div>\n" + 
					"	<p>서울시 어떤구 어떤로 어떤빌딩 어떤데~</p>\n" + 
					"</div>"; // 메일내용(html)
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setFrom(new InternetAddress("dlwlsdn5244@gmail.com")); // 보내는 메일
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(member.getMmail())); //받는메일
				mimeMessage.setSubject(member.getMname()+" 님 회원가입 굳!(쿠폰드림)");
				mimeMessage.setText(content, "utf-8", "html");
			}
		};
		mailSender.send(message); // 메일 발송
		session.setAttribute("mid", member.getMid());
		return memberDao.join(member); // member insert
	}

	@Override
	public String loginCheck(String mid, String mpw, HttpSession session) {
		String result = "로그인 성공";
		Member member = memberDao.memberDetail(mid);
		if(member == null) {
			result = "유효하지 않은 아이디입니다";
		}else if(! mpw.equals(member.getMpw())) {
			result = "비밀번호를 확인해주세요";
		}else {
			// 로그인 성공
			session.setAttribute("member", member);
			session.setAttribute("mid", mid);
		}
		return result;
	}

	@Override
	public Member memberDetail(String mid) {
		return memberDao.memberDetail(mid);
	}

	@Override
	public int modifyMember(Member member) {
		return memberDao.modifyMember(member);
	}

}
