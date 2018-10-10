package top.fanfpy.websocketdemo.entity;

public class Message {
    private String sendUser;
    private String tuUser;
    private String text;
    private String date;

    public Message(String sendUser, String tuUser, String text, String date) {
        this.sendUser = sendUser;
        this.tuUser = tuUser;
        this.text = text;
        this.date = date;
    }

    public String getSendUser() {
        return sendUser;
    }

    public void setSendUser(String sendUser) {
        this.sendUser = sendUser;
    }

    public String getTuUser() {
        return tuUser;
    }

    public void setTuUser(String tuUser) {
        this.tuUser = tuUser;
    }

    public String getDate() {
        return date;
        }

    public void setDate(String date) {
        date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sendUser='" + sendUser + '\'' +
                ", tuUser='" + tuUser + '\'' +
                ", text='" + text + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
