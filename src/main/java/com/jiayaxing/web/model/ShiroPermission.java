package com.jiayaxing.web.model;

public class ShiroPermission {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column shiro_permission.id
	 * @mbg.generated  Wed Jun 13 09:30:47 CST 2018
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column shiro_permission.name
	 * @mbg.generated  Wed Jun 13 09:30:47 CST 2018
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column shiro_permission.perm
	 * @mbg.generated  Wed Jun 13 09:30:47 CST 2018
	 */
	private String perm;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column shiro_permission.id
	 * @return  the value of shiro_permission.id
	 * @mbg.generated  Wed Jun 13 09:30:47 CST 2018
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column shiro_permission.id
	 * @param id  the value for shiro_permission.id
	 * @mbg.generated  Wed Jun 13 09:30:47 CST 2018
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column shiro_permission.name
	 * @return  the value of shiro_permission.name
	 * @mbg.generated  Wed Jun 13 09:30:47 CST 2018
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column shiro_permission.name
	 * @param name  the value for shiro_permission.name
	 * @mbg.generated  Wed Jun 13 09:30:47 CST 2018
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column shiro_permission.perm
	 * @return  the value of shiro_permission.perm
	 * @mbg.generated  Wed Jun 13 09:30:47 CST 2018
	 */
	public String getPerm() {
		return perm;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column shiro_permission.perm
	 * @param perm  the value for shiro_permission.perm
	 * @mbg.generated  Wed Jun 13 09:30:47 CST 2018
	 */
	public void setPerm(String perm) {
		this.perm = perm;
	}
}