package com.jeff.springbootmybatis.model;

import javax.persistence.*;

@Table(name = "f_configuration")
public class Configuration {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 键
     */
    @Column(name = "conf_key")
    private String confKey;

    /**
     * 名称
     */
    @Column(name = "conf_name")
    private String confName;

    /**
     * 值
     */
    @Column(name = "conf_value")
    private String confValue;

    /**
     * 类型
     */
    @Column(name = "conf_type")
    private String confType;

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
     * 获取键
     *
     * @return conf_key - 键
     */
    public String getConfKey() {
        return confKey;
    }

    /**
     * 设置键
     *
     * @param confKey 键
     */
    public void setConfKey(String confKey) {
        this.confKey = confKey;
    }

    /**
     * 获取名称
     *
     * @return conf_name - 名称
     */
    public String getConfName() {
        return confName;
    }

    /**
     * 设置名称
     *
     * @param confName 名称
     */
    public void setConfName(String confName) {
        this.confName = confName;
    }

    /**
     * 获取值
     *
     * @return conf_value - 值
     */
    public String getConfValue() {
        return confValue;
    }

    /**
     * 设置值
     *
     * @param confValue 值
     */
    public void setConfValue(String confValue) {
        this.confValue = confValue;
    }

    /**
     * 获取类型
     *
     * @return conf_type - 类型
     */
    public String getConfType() {
        return confType;
    }

    /**
     * 设置类型
     *
     * @param confType 类型
     */
    public void setConfType(String confType) {
        this.confType = confType;
    }
}