package com.sutest512.entity;

public class UserKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.Host
     *
     * @mbg.generated Fri May 12 11:05:15 JST 2023
     */
    private String host;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.User
     *
     * @mbg.generated Fri May 12 11:05:15 JST 2023
     */
    private String user;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Host
     *
     * @return the value of user.Host
     *
     * @mbg.generated Fri May 12 11:05:15 JST 2023
     */
    public String getHost() {
        return host;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Host
     *
     * @param host the value for user.Host
     *
     * @mbg.generated Fri May 12 11:05:15 JST 2023
     */
    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.User
     *
     * @return the value of user.User
     *
     * @mbg.generated Fri May 12 11:05:15 JST 2023
     */
    public String getUser() {
        return user;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.User
     *
     * @param user the value for user.User
     *
     * @mbg.generated Fri May 12 11:05:15 JST 2023
     */
    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }
}