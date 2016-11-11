/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gihan
 */
@Entity
@Table(name = "user_tab")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserTab.findAll", query = "SELECT u FROM UserTab u")
    , @NamedQuery(name = "UserTab.findByUserId", query = "SELECT u FROM UserTab u WHERE u.userId = :userId")
    , @NamedQuery(name = "UserTab.findByUserName", query = "SELECT u FROM UserTab u WHERE u.userName = :userName")
    , @NamedQuery(name = "UserTab.findByUserPwd", query = "SELECT u FROM UserTab u WHERE u.userPwd = :userPwd")
    , @NamedQuery(name = "UserTab.findByReadvalidation", query = "SELECT u FROM UserTab u WHERE u.readvalidation = :readvalidation")
    , @NamedQuery(name = "UserTab.findByCreatevalidation", query = "SELECT u FROM UserTab u WHERE u.createvalidation = :createvalidation")
    , @NamedQuery(name = "UserTab.findByModifyvalidation", query = "SELECT u FROM UserTab u WHERE u.modifyvalidation = :modifyvalidation")})
public class UserTab implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_ID")
    private int userId;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "USER_NAME")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "USER_PWD")
    private String userPwd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "READVALIDATION")
    private String readvalidation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "CREATEVALIDATION")
    private String createvalidation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "MODIFYVALIDATION")
    private String modifyvalidation;

    public UserTab() {
    }

    public UserTab(String userName) {
        this.userName = userName;
    }

    public UserTab(String userName, int userId, String userPwd, String readvalidation, String createvalidation, String modifyvalidation) {
        this.userName = userName;
        this.userId = userId;
        this.userPwd = userPwd;
        this.readvalidation = readvalidation;
        this.createvalidation = createvalidation;
        this.modifyvalidation = modifyvalidation;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getReadvalidation() {
        return readvalidation;
    }

    public void setReadvalidation(String readvalidation) {
        this.readvalidation = readvalidation;
    }

    public String getCreatevalidation() {
        return createvalidation;
    }

    public void setCreatevalidation(String createvalidation) {
        this.createvalidation = createvalidation;
    }

    public String getModifyvalidation() {
        return modifyvalidation;
    }

    public void setModifyvalidation(String modifyvalidation) {
        this.modifyvalidation = modifyvalidation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userName != null ? userName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserTab)) {
            return false;
        }
        UserTab other = (UserTab) object;
        if ((this.userName == null && other.userName != null) || (this.userName != null && !this.userName.equals(other.userName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.UserTab[ userName=" + userName + " ]";
    }
    
}
