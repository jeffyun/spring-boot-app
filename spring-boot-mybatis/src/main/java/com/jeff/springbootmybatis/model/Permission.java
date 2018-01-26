package com.jeff.springbootmybatis.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "T_PERMISSION")
public class Permission {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 权限编码
     */
    @Column(name = "perm_code")
    private String permCode;

    /**
     * 权限名称
     */
    @Column(name = "perm_name")
    private String permName;

    /**
     * 状态：1-有效；0-无效
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
     * 最后修改者ID
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
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取权限编码
     *
     * @return perm_code - 权限编码
     */
    public String getPermCode() {
        return permCode;
    }

    /**
     * 设置权限编码
     *
     * @param permCode 权限编码
     */
    public void setPermCode(String permCode) {
        this.permCode = permCode;
    }

    /**
     * 获取权限名称
     *
     * @return perm_name - 权限名称
     */
    public String getPermName() {
        return permName;
    }

    /**
     * 设置权限名称
     *
     * @param permName 权限名称
     */
    public void setPermName(String permName) {
        this.permName = permName;
    }

    /**
     * 获取状态：1-有效；0-无效
     *
     * @return status - 状态：1-有效；0-无效
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态：1-有效；0-无效
     *
     * @param status 状态：1-有效；0-无效
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
     * 获取最后修改者ID
     *
     * @return update_by - 最后修改者ID
     */
    public Integer getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置最后修改者ID
     *
     * @param updateBy 最后修改者ID
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