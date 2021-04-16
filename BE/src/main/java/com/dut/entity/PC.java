package com.dut.entity;

public class PC {
    private Integer id;

    private String ip;

    private String pcName;

    private Integer groupId;

    private String accountName;

    private String accountPassword;

    private String status;

    private Integer clientFlag;

    private Integer manageFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPcName() {
        return pcName;
    }

    public void setPcName(String pcName) {
        this.pcName = pcName;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getClientFlag() {
        return clientFlag;
    }

    public void setClientFlag(Integer clientFlag) {
        this.clientFlag = clientFlag;
    }

    public Integer getManageFlag() {
        return manageFlag;
    }

    public void setManageFlag(Integer manageFlag) {
        this.manageFlag = manageFlag;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", ip=").append(ip);
        sb.append(", pcName=").append(pcName);
        sb.append(", groupId=").append(groupId);
        sb.append(", accountName=").append(accountName);
        sb.append(", accountPassword=").append(accountPassword);
        sb.append(", status=").append(status);
        sb.append(", clientFlag=").append(clientFlag);
        sb.append(", manageFlag=").append(manageFlag);
        sb.append("]");
        return sb.toString();
    }
}