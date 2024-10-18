package monopoly;

import java.util.Objects;

public class GoldKey {
	//(맴버변수) - gkId, content 
	
	private int gkId;  //황금열쇠 id
	private String content;  //황금열쇠 내용
	private String detail; //세부내용
	
	//생성자
	public GoldKey() {}
	public GoldKey(int gkId, String content, String detail) {
		this.gkId = gkId;
		this.content = content;
		this.detail = detail;
	}

	@Override
	public String toString() {
	    return String.format(
	        " ┌───────────────────────────────────────────────┐\n" +
	        " │ %-45s │\n" +
	        " │ %-2s %-1s │\n" +
	        " │ %-25s │\n" +
	        " │ %-45s │\n" +
	        " └───────────────────────────────────────────────┘",
	        " ", 
	        gkId, content, 
	        detail, 
	        " "
	    );
	}
	
	public int getGkId() {
		return gkId;
	}
	public void setGkId(int gkId) {
		this.gkId = gkId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	@Override
	public int hashCode() {
		return Objects.hash(content, detail, gkId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GoldKey other = (GoldKey) obj;
		return gkId == other.gkId;
	}
	
}


