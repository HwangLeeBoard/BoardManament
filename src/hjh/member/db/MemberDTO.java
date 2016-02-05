package hjh.member.db;

public class MemberDTO {
	   private int idx;
	   private String email;
	   private String passwd;
	   private String name;
	   private String gender;
	   private String pnum;
	   private String joindate;
	   private String logintime;
	   private String ip;

	   public MemberDTO() {
	      // TODO Auto-generated constructor stub
	   }

	   public MemberDTO(int idx, String email, String passwd, String name, String gender, String pnum, String joindate,
	         String logintime, String ip) {
	      super();
	      this.idx = idx;
	      this.email = email;
	      this.passwd = passwd;
	      this.name = name;
	      this.gender = gender;
	      this.pnum = pnum;
	      this.joindate = joindate;
	      this.logintime = logintime;
	      this.ip = ip;
	   }

	   public int getIdx() {
	      return idx;
	   }

	   public void setIdx(int idx) {
	      this.idx = idx;
	   }

	   public String getEmail() {
	      return email;
	   }

	   public void setEmail(String email) {
	      this.email = email;
	   }

	   public String getPasswd() {
	      return passwd;
	   }

	   public void setPasswd(String passwd) {
	      this.passwd = passwd;
	   }

	   public String getName() {
	      return name;
	   }

	   public void setName(String name) {
	      this.name = name;
	   }

	   public String getGender() {
	      return gender;
	   }

	   public void setGender(String gender) {
	      this.gender = gender;
	   }

	   public String getPnum() {
	      return pnum;
	   }

	   public void setPnum(String pnum) {
	      this.pnum = pnum;
	   }

	   public String getJoindate() {
	      return joindate;
	   }

	   public void setJoindate(String joindate) {
	      this.joindate = joindate;
	   }

	   public String getLogintime() {
	      return logintime;
	   }

	   public void setLogintime(String logintime) {
	      this.logintime = logintime;
	   }

	   public String getIp() {
	      return ip;
	   }

	   public void setIp(String ip) {
	      this.ip = ip;
	   }

	   @Override
	   public int hashCode() {
	      final int prime = 31;
	      int result = 1;
	      result = prime * result + idx;
	      return result;
	   }

	   @Override
	   public boolean equals(Object obj) {
	      if (this == obj)
	         return true;
	      if (obj == null)
	         return false;
	      if (getClass() != obj.getClass())
	         return false;
	      MemberDTO other = (MemberDTO) obj;
	      if (idx != other.idx)
	         return false;
	      return true;
	   }

	   @Override
	   public String toString() {
	      return "MemberDTO [idx=" + idx + ", email=" + email + ", passwd=" + passwd + ", name=" + name + ", gender="
	            + gender + ", pnum=" + pnum + ", joindate=" + joindate + ", logintime=" + logintime + ", ip=" + ip
	            + "]";
	   }
	   

	}