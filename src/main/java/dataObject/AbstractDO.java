package dataObject;

import java.util.Date;

/**
 * ��AbstractDO.java��ʵ������������DO
 * 
 * @author jizhi.qy 2017��11��11�� ����7:16:47
 */
public abstract class AbstractDO {
    private Long id;
    private Date gmtCreate;
    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

}
