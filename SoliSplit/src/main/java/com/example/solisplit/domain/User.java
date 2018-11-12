package com.example.solisplit.domain;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="users")
public class User
{
  private Long id;
  private String username;
  private String password;
  private String confirmPassword;
  private Set<Group> groups = new TreeSet<>();
  private Set<Authority> authorities = new HashSet<>();
  
  @Id @GeneratedValue
  public Long getId()
  {
    return id;
  }
  public void setId(Long id)
  {
    this.id = id;
  }
  public String getUsername()
  {
    return username;
  }
  public void setUsername(String username)
  {
    this.username = username;
  }
  public String getPassword()
  {
    return password;
  }
  public void setPassword(String password)
  {
    this.password = password;
  }
  
  @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="user")
  public Set<Group> getGroups()
  {
    return groups;
  }
  public void setGroups(Set<Group> groups)
  {
    this.groups = groups;
  }
  
  @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="user")
  public Set<Authority> getAuthorities() {
	return authorities;
  }
  public void setAuthorities(Set<Authority> authorities) {
	this.authorities = authorities;
  }
  
  @Transient
  public String getConfirmPassword() {
	  return confirmPassword;
  }
  public void setConfirmPassword(String confirmPassword) {
	  this.confirmPassword = confirmPassword;
  }
  
  
}