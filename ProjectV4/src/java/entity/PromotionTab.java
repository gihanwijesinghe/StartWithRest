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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "promotion_tab")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PromotionTab.findAll", query = "SELECT p FROM PromotionTab p")
    , @NamedQuery(name = "PromotionTab.findBySiteId", query = "SELECT p FROM PromotionTab p WHERE p.promotionTabPK.siteId = :siteId")
    , @NamedQuery(name = "PromotionTab.findByPromotionId", query = "SELECT p FROM PromotionTab p WHERE p.promotionTabPK.promotionId = :promotionId")
    , @NamedQuery(name = "PromotionTab.findByDescription", query = "SELECT p FROM PromotionTab p WHERE p.description = :description")
    , @NamedQuery(name = "PromotionTab.findByType", query = "SELECT p FROM PromotionTab p WHERE p.type = :type")
    , @NamedQuery(name = "PromotionTab.findByResponsible", query = "SELECT p FROM PromotionTab p WHERE p.responsible = :responsible")
    , @NamedQuery(name = "PromotionTab.findByStartDate", query = "SELECT p FROM PromotionTab p WHERE p.startDate = :startDate")
    , @NamedQuery(name = "PromotionTab.findByEndDate", query = "SELECT p FROM PromotionTab p WHERE p.endDate = :endDate")
    , @NamedQuery(name = "PromotionTab.findByNote", query = "SELECT p FROM PromotionTab p WHERE p.note = :note")
    , @NamedQuery(name = "PromotionTab.findByState", query = "SELECT p FROM PromotionTab p WHERE p.state = :state")})
public class PromotionTab implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PromotionTabPK promotionTabPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 10)
    @Column(name = "TYPE")
    private String type;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "STATE")
    private String state;

    public PromotionTab() {
    }

    public PromotionTab(PromotionTabPK promotionTabPK) {
        this.promotionTabPK = promotionTabPK;
    }

    public PromotionTab(PromotionTabPK promotionTabPK, String description, String state) {
        this.promotionTabPK = promotionTabPK;
        this.description = description;
        this.state = state;
    }

    public PromotionTab(String siteId, String promotionId) {
        this.promotionTabPK = new PromotionTabPK(siteId, promotionId);
    }

    public PromotionTabPK getPromotionTabPK() {
        return promotionTabPK;
    }

    public void setPromotionTabPK(PromotionTabPK promotionTabPK) {
        this.promotionTabPK = promotionTabPK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (promotionTabPK != null ? promotionTabPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PromotionTab)) {
            return false;
        }
        PromotionTab other = (PromotionTab) object;
        if ((this.promotionTabPK == null && other.promotionTabPK != null) || (this.promotionTabPK != null && !this.promotionTabPK.equals(other.promotionTabPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PromotionTab[ promotionTabPK=" + promotionTabPK + " ]";
    }
    
}
