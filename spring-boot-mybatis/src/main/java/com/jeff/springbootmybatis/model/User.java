package com.jeff.springbootmybatis.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "T_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户中文名
     */
    private String cname;

    /**
     * 密码
     */
    private String password;

    private String salt;

    /**
     * 性别:1-男；0-女
     */
    private Integer sex;

    /**
     * 状态:1-激活；0-禁用
     */
    private Integer status;

    /**
     * 创建者ID
     */
    @Column(name = "create_by")
    private Integer createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_datetime")
    private Date createDatetime;

    /**
     * 最后修改者
     */
    @Column(name = "update_by")
    private Integer updateBy;

    /**
     * 最后修改时间
     */
    @Column(name = "update_datetime")
    private Date updateDatetime;

    /**
     * 备注
     */
    private String remark;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取用户中文名
     *
     * @return cname - 用户中文名
     */
    public String getCname() {
        return cname;
    }

    /**
     * 设置用户中文名
     *
     * @param cname 用户中文名
     */
    public void setCname(String cname) {
        this.cname = cname;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * @param salt
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 获取性别:1-男；0-女
     *
     * @return sex - 性别:1-男；0-女
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别:1-男；0-女
     *
     * @param sex 性别:1-男；0-女
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取状态:1-激活；0-禁用
     *
     * @return status - 状态:1-激活；0-禁用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态:1-激活；0-禁用
     *
     * @param status 状态:1-激活；0-禁用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取创建者ID
     *
     * @return create_by - 创建者ID
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建者ID
     *
     * @param createBy 创建者ID
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取创建时间
     *
     * @return create_datetime - 创建时间
     */
    public Date getCreateDatetime() {
        return createDatetime;
    }

    /**
     * 设置创建时间
     *
     * @param createDatetime 创建时间
     */
    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    /**
     * 获取最后修改者
     *
     * @return update_by - 最后修改者
     */
    public Integer getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置最后修改者
     *
     * @param updateBy 最后修改者
     */
    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取最后修改时间
     *
     * @return update_datetime - 最后修改时间
     */
    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    /**
     * 设置最后修改时间
     *
     * @param updateDatetime 最后修改时间
     */
    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}