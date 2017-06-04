package entity;
/**
 * 反馈类
 * @author wuguofei
 *
 */
public class Feedback {
	private String feedbackId;
	//用户的信息
    private String userName;
    private String userAge;
    private String userSex;
    private String feedbackMsg;
    

	//联系方式
    private String qq;
    private String email;
    private String phone;
    
    public String getFeedbackId() {
		return feedbackId;
	}
    
	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId;
	}
	
	public String getFeedbackMsg() {
		return feedbackMsg;
	}

	public void setFeedbackMsg(String feedbackMsg) {
		this.feedbackMsg = feedbackMsg;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
