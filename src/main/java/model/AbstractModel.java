package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 类AbstractModel.java的实现描述：抽象model
 * 
 * @author jizhi.qy 2017年11月11日 上午11:01:56
 */
public abstract class AbstractModel {

    private Long id;
    private Date gmtCreate;
    private Date gmtModified;

    Set<String> changeSet = new HashSet<String>();

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

    public Set<String> changeSet() {
        if (changeSet == null) {
            changeSet = new HashSet<String>();
        }
        return changeSet;
    }

    public void addChange(final String changeName) {
        changeSet().add(changeName);
    }

    public void addAllChange(final Set<String> changeSet) {
        if (changeSet == null || changeSet.size() <= 0) {
            return;
        }
        changeSet().addAll(changeSet);
    }

}
