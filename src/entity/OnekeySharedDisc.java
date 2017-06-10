package entity;



/**
 * 评论类
 * Created by chenfuhai on 2016/12/16 0016.
 */

public class OnekeySharedDisc  {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private int sharedMessageId; //分享结果ID
    private String  userId;
    private String userImgUrl;
    private String  username;
    private Boolean  usersex;
    private String  userage;

    private String message;//评论内容


    public OnekeySharedDisc(int sharedMessageId, String userId) {
        this.sharedMessageId = sharedMessageId;
        this.userId = userId;
    }
    public OnekeySharedDisc() {
       
    }

    public int getSharedMessageId() {
        return sharedMessageId;
    }

    public void setSharedMessageId(int sharedMessageId) {
        this.sharedMessageId = sharedMessageId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserImgUrl() {
        return userImgUrl;
    }

    public void setUserImgUrl(String userImgUrl) {
        this.userImgUrl = userImgUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getUsersex() {
        return usersex;
    }

    public void setUsersex(Boolean usersex) {
        this.usersex = usersex;
    }

    public String getUserage() {
        return userage;
    }

    public void setUserage(String userage) {
        this.userage = userage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
