package com.tja.frame.core.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;

import com.alibaba.fastjson.annotation.JSONField;
import com.tja.frame.common.util.Constants;

@Entity
@Table(name="frame_user")
public class User implements Serializable {
	
	public static final String MALE = "M";  // 男
	public static final String FEMALE = "F"; //女
	
	public static final int NORMAL = 0;  //用户状态  - 正常
	public static final int LOCKED = 1;  //用户状态 - 锁定
	public static final int INVALID = 3;  //用户状态 - 无效 (如离职等原因)
	
	@Transient
	public boolean isRoot() {
		return this.id == 0;
	}
	
	@Transient
	public boolean isNormal() {
		return this.status == NORMAL;
	}
	
	@Transient
	public Boolean hasAllPerm(Integer siteId) {
		if (isRoot() && Constants.IS_ROOT_ALL_PERMS) {
			return true;
		}
		return false;
	}
	
	@Transient
	public Set<String> getPerms(Integer siteId) {
		Set<String> set = new HashSet<String>();
		if (isRoot() && Constants.IS_ROOT_ALL_PERMS) {
			// root用户，拥有所有权限，直接返回
			set.add("*");
			return set;
		}
		List<Role> roles = getRoles();
		if (roles == null) {
			return null;
		}
		for (Role role : roles) {
			String perms = role.getPerms();
			if (StringUtils.isNotBlank(perms)) {
				for (String perm : StringUtils.split(perms, ',')) {
					set.add(perm);
				}
			}
		}
		return set;
	}
	
	
	@Transient
	public List<Role> getRoles() {
		List<UserRole> userRoles = getUserRoles();
		if (userRoles == null) {
			return null;
		}
		List<Role> roles = new ArrayList<Role>(userRoles.size());
		for (UserRole userRole : userRoles) {
			Role role = userRole.getRole();
			roles.add(role);
		}
		return roles;
	}
	
	
	private static final long serialVersionUID = 4715116195063579238L;

	private Integer id;
	
	private String userName;
	
	private String password;
	
	private String salt;
	
	private String realName;
	
	private String gender;
	
	private Integer status;
	
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date birthDate;

	private Organization organization;
	
	//@JSONField(serialize=false)
	private List<UserRole> userRoles = new ArrayList<UserRole>(0);
	
	
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@TableGenerator(name = "tg_frame_user", pkColumnValue = "frame_user", table = "t_id_table", pkColumnName = "f_table", valueColumnName = "f_id_value", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tg_frame_user")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotNull
	@Column(name="user_name",unique=true,nullable=false)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name="password",length=128)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "salt", length = 32)
	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Length(max=32)
	@Column(name="real_name",length=32)
	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	@Pattern(regexp = "[F,M]")
	@Length(max=1)
	@Column(name="gender", length=1)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name="status")
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "birth_date", length = 19)
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "org_id", nullable = false)
	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.REMOVE }, mappedBy = "user")
	@OrderBy("roleIndex")
	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

}
