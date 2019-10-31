package com.ailbaba.cloud.cgc.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "z_member")
@Data
public class ZMember implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "u_id")
    private Integer uId;

    @Column(name = "is_vip")
    private Integer isVip;

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
     * @return u_id
     */
    public Integer getuId() {
        return uId;
    }

    /**
     * @param uId
     */
    public void setuId(Integer uId) {
        this.uId = uId;
    }

    /**
     * @return is_vip
     */
    public Integer getIsVip() {
        return isVip;
    }

    /**
     * @param isVip
     */
    public void setIsVip(Integer isVip) {
        this.isVip = isVip;
    }
}