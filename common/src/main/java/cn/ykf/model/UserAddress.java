package cn.ykf.model;

import java.io.Serializable;

/**
 * 用户地址
 *
 * @author YuKaiFan<yukf @ pvc123.com>
 * @date 2020-11-21
 */
public class UserAddress implements Serializable {

    /** id */
    private String id;

    /** 地址 */
    private String address;

    /** 用户id */
    private String userId;

    /** 收货人 */
    private String consignee;

    /** 手机号码 */
    private String phone;

    /** 是否默认, {@code true} - 默认， {@code false} - 非默认 */
    private Boolean defaulted;

    public UserAddress(String id, String address, String userId, String consignee, String phone, Boolean defaulted) {
        this.id = id;
        this.address = address;
        this.userId = userId;
        this.consignee = consignee;
        this.phone = phone;
        this.defaulted = defaulted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getDefaulted() {
        return defaulted;
    }

    public void setDefaulted(Boolean defaulted) {
        this.defaulted = defaulted;
    }

    @Override
    public String toString() {
        return "UserAddress{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", userId='" + userId + '\'' +
                ", consignee='" + consignee + '\'' +
                ", phone='" + phone + '\'' +
                ", defaulted=" + defaulted +
                '}';
    }
}
