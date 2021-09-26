package manager;

import java.util.Date;

public class MemberDto {
	private int num;
	private String memverId;
	private String memverPw;
	private String nickname;
	private Date regdate; 	// java.util.Date
	
	public MemberDto() {}

	public MemberDto(int num, String memverId, String memverPw, String nickname) {
		super();
		this.num = num;
		this.memverId = memverId;
		this.memverPw = memverPw;
		this.nickname = nickname;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getMemverId() {
		return memverId;
	}

	public void setMemverId(String memverId) {
		this.memverId = memverId;
	}

	public String getMemverPw() {
		return memverPw;
	}

	public void setMemverPw(String memverPw) {
		this.memverPw = memverPw;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "MemberDto [num=" + num + ", memverId=" + memverId + ", memverPw=" + memverPw + ", nickname=" + nickname
				+ ", regdate=" + regdate + "]";
	}
}
