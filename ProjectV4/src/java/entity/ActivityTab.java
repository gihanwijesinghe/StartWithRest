/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gihan
 */
@Entity
@Table(name = "activity_tab")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActivityTab.findAll", query = "SELECT a FROM ActivityTab a")
    , @NamedQuery(name = "ActivityTab.findByActivitySeqNo", query = "SELECT a FROM ActivityTab a WHERE a.activitySeqNo = :activitySeqNo")
    , @NamedQuery(name = "ActivityTab.findByActivityId", query = "SELECT a FROM ActivityTab a WHERE a.activityId = :activityId")
    , @NamedQuery(name = "ActivityTab.findByDescription", query = "SELECT a FROM ActivityTab a WHERE a.description = :description")
    , @NamedQuery(name = "ActivityTab.findBySiteId", query = "SELECT a FROM ActivityTab a WHERE a.siteId = :siteId")
    , @NamedQuery(name = "ActivityTab.findByPromotionId", query = "SELECT a FROM ActivityTab a WHERE a.promotionId = :promotionId")
    , @NamedQuery(name = "ActivityTab.findByParentId", query = "SELECT a FROM ActivityTab a WHERE a.parentId = :parentId")
    , @NamedQuery(name = "ActivityTab.findByResponsible", query = "SELECT a FROM ActivityTab a WHERE a.responsible = :responsible")
    , @NamedQuery(name = "ActivityTab.findByStartDate", query = "SELECT a FROM ActivityTab a WHERE a.startDate = :startDate")
    , @NamedQuery(name = "ActivityTab.findByEndDate", query = "SELECT a FROM ActivityTab a WHERE a.endDate = :endDate")
    , @NamedQuery(name = "ActivityTab.findByNote", query = "SELECT a FROM ActivityTab a WHERE a.note = :note")
    , @NamedQuery(name = "ActivityTab.findByStatus", query = "SELECT a FROM ActivityTab a WHERE a.status = :status")})
public class ActivityTab implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVITY_SEQ_NO")
    private Integer activitySeqNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ACTIVITY_ID")
    private String activityId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "SITE_ID")
    private String siteId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PROMOTION_ID")
    private String promotionId;
    @Column(name = "PARENT_ID")
    private Integer parentId;
    @Size(max = 10)
    @Column(name = "RESPONSIBLE")
    private String responsible;
    @Column(name = "START_DATE")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Size(max = 1000)
    @Column(name = "NOTE")
    private String note;
    @Size(max = 20)
    @Column(name = "STATUS")
    private String status;

    public ActivityTab() {
    }

    public ActivityTab(Integer activitySeqNo) {
        this.activitySeqNo = activitySeqNo;
    }

    public ActivityTab(Integer activitySeqNo, String activityId, String description, String siteId, String promotionId) {
        this.activitySeqNo = activitySeqNo;
        this.activityId = activityId;
        this.description = description;
        this.siteId = siteId;
        this.promotionId = promotionId;
    }

    public Integer getActivitySeqNo() {
        return activitySeqNo;
    }

    public void setActivitySeqNo(Integer activitySeqNo) {
        this.activitySeqNo = activitySeqNo;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(String promotionId) {
        this.promotionId = promotionId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (activitySeqNo != null ? activitySeqNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActivityTab)) {
            return false;
        }
        ActivityTab other = (ActivityTab) object;
        if ((this.activitySeqNo == null && other.activitySeqNo != null) || (this.activitySeqNo != null && !this.activitySeqNo.equals(other.activitySeqNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ActivityTab[ activitySeqNo=" + activitySeqNo + " ]";
    }
    
}
