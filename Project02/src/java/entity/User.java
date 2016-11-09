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
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findByUserID", query = "SELECT u FROM User u WHERE u.userID = :userID")
    , @NamedQuery(name = "User.findByUserName", query = "SELECT u FROM User u WHERE u.userName = :userName")
    , @NamedQuery(name = "User.findByUserPwd", query = "SELECT u FROM User u WHERE u.userPwd = :userPwd")
    , @NamedQuery(name = "User.findByReadValidation", query = "SELECT u FROM User u WHERE u.readValidation = :readValidation")
    , @NamedQuery(name = "User.findByCreateValidation", query = "SELECT u FROM User u WHERE u.createValidation = :createValidation")
    , @NamedQuery(name = "User.findByModifyValidation", query = "SELECT u FROM User u WHERE u.modifyValidation = :modifyValidation")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_ID")
    private int userID;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "user_name")
    private String userName;
    @Size(max = 15)
    @Column(name = "user_pwd")
    private String userPwd;
    @Size(max = 1)
    @Column(name = "readValidation")
    private String readValidation;
    @Size(max = 1)
    @Column(name = "createValidation")
    private String createValidation;
    @Size(max = 1)
    @Column(name = "modifyValidation")
    private String modifyValidation;

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }

    public User(String userName, int userID) {
        this.userName = userName;
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    public String getReadValidation() {
        return readValidation;
    }

    public void setReadValidation(String readValidation) {
        this.readValidation = readValidation;
    }

    public String getCreateValidation() {
        return createValidation;
    }

    public void setCreateValidation(String createValidation) {
        this.createValidation = createValidation;
    }

    public String getModifyValidation() {
        return modifyValidation;
    }

    public void setModifyValidation(String modifyValidation) {
        this.modifyValidation = modifyValidation;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userName == null && other.userName != null) || (this.userName != null && !this.userName.equals(other.userName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.User[ userName=" + userName + " ]";
    }
    
}
