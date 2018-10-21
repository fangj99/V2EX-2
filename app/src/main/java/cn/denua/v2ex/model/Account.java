package cn.denua.v2ex.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Account extends Member implements Parcelable {

    private int number;
    private int balance;
    private int notifications;

    private int favorNodes;
    private int favorTopics;
    private int following;

    private String join;

    public Account(String id, String pic, int number){

        this.id = id;
        this.picUrl = pic;
        this.number = number;
    }

    public Account(String id, String pic, int number, int balance, int notifications, int favorNodes, int favorTopics, int following) {
        this.id = id;
        this.picUrl = pic;
        this.number = number;
        this.balance = balance;
        this.notifications = notifications;
        this.favorNodes = favorNodes;
        this.favorTopics = favorTopics;
        this.following = following;
    }

    public static Creator<Account> CREATOR = new Creator<Account>() {
        @Override
        public Account createFromParcel(Parcel source) {
            return new Account(source );
        }

        @Override
        public Account[] newArray(int size) {
            return new Account[size];
        }
    };

    private Account(Parcel in){

        this.id = in.readString();
        this.picUrl = in.readString();
        this.number = in.readInt();
        this.balance = in.readInt();
        this.notifications = in.readInt();
        this.favorNodes = in.readInt();
        this.favorTopics = in.readInt();
        this.following = in.readInt();
        this.join = in.readString();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(picUrl);
        dest.writeInt(number);
        dest.writeInt(balance);
        dest.writeInt(notifications);
        dest.writeInt(favorNodes);
        dest.writeInt(favorTopics);
        dest.writeInt(following);
        dest.writeString(join);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPic() {
        return picUrl;
    }

    public void setPic(String pic) {
        this.picUrl = pic;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getNotifications() {
        return notifications;
    }

    public void setNotifications(int notifications) {
        this.notifications = notifications;
    }

    public int getFavorNodes() {
        return favorNodes;
    }

    public void setFavorNodes(int favorNodes) {
        this.favorNodes = favorNodes;
    }

    public int getFavorTopics() {
        return favorTopics;
    }

    public void setFavorTopics(int favorTopics) {
        this.favorTopics = favorTopics;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public String getJoin() {
        return join;
    }

    public void setJoin(String join) {
        this.join = join;
    }
}
