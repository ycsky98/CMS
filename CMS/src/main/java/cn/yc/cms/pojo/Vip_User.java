package cn.yc.cms.pojo;

import java.util.Date;

public class Vip_User {
    private Integer vipId;

    private String vipName;

    private String vipUsername;

    private String vipPassword;

    private Integer vipSex;

	private Integer vipState;

    private String vipPhone;

    private String vipEmail;

    private String vipAddress;

    private Date vipTime;

    public Integer getVipId() {
        return vipId;
    }

    public void setVipId(Integer vipId) {
        this.vipId = vipId;
    }

    public String getVipName() {
        return vipName;
    }

    public void setVipName(String vipName) {
        this.vipName = vipName;
    }

    public String getVipUsername() {
        return vipUsername;
    }

    public void setVipUsername(String vipUsername) {
        this.vipUsername = vipUsername;
    }

    public String getVipPassword() {
        return vipPassword;
    }

    public void setVipPassword(String vipPassword) {
        this.vipPassword = vipPassword;
    }

    public Integer getVipSex() {
        return vipSex;
    }

    public void setVipSex(Integer vipSex) {
        this.vipSex = vipSex;
    }

    public Integer getVipState() {
        return vipState;
    }

    public void setVipState(Integer vipState) {
        this.vipState = vipState;
    }

    public String getVipPhone() {
        return vipPhone;
    }

    public void setVipPhone(String vipPhone) {
        this.vipPhone = vipPhone;
    }

    public String getVipEmail() {
        return vipEmail;
    }

    public void setVipEmail(String vipEmail) {
        this.vipEmail = vipEmail;
    }

    public String getVipAddress() {
        return vipAddress;
    }

    public void setVipAddress(String vipAddress) {
        this.vipAddress = vipAddress;
    }

    public Date getVipTime() {
        return vipTime;
    }

    public void setVipTime(Date vipTime) {
        this.vipTime = vipTime;
    }
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vipAddress == null) ? 0 : vipAddress.hashCode());
		result = prime * result + ((vipEmail == null) ? 0 : vipEmail.hashCode());
		result = prime * result + ((vipId == null) ? 0 : vipId.hashCode());
		result = prime * result + ((vipName == null) ? 0 : vipName.hashCode());
		result = prime * result + ((vipPassword == null) ? 0 : vipPassword.hashCode());
		result = prime * result + ((vipPhone == null) ? 0 : vipPhone.hashCode());
		result = prime * result + ((vipSex == null) ? 0 : vipSex.hashCode());
		result = prime * result + ((vipState == null) ? 0 : vipState.hashCode());
		result = prime * result + ((vipTime == null) ? 0 : vipTime.hashCode());
		result = prime * result + ((vipUsername == null) ? 0 : vipUsername.hashCode());
		return result;
	}
    
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vip_User other = (Vip_User) obj;
		if (vipAddress == null) {
			if (other.vipAddress != null)
				return false;
		} else if (!vipAddress.equals(other.vipAddress))
			return false;
		if (vipEmail == null) {
			if (other.vipEmail != null)
				return false;
		} else if (!vipEmail.equals(other.vipEmail))
			return false;
		if (vipId == null) {
			if (other.vipId != null)
				return false;
		} else if (!vipId.equals(other.vipId))
			return false;
		if (vipName == null) {
			if (other.vipName != null)
				return false;
		} else if (!vipName.equals(other.vipName))
			return false;
		if (vipPassword == null) {
			if (other.vipPassword != null)
				return false;
		} else if (!vipPassword.equals(other.vipPassword))
			return false;
		if (vipPhone == null) {
			if (other.vipPhone != null)
				return false;
		} else if (!vipPhone.equals(other.vipPhone))
			return false;
		if (vipSex == null) {
			if (other.vipSex != null)
				return false;
		} else if (!vipSex.equals(other.vipSex))
			return false;
		if (vipState == null) {
			if (other.vipState != null)
				return false;
		} else if (!vipState.equals(other.vipState))
			return false;
		if (vipTime == null) {
			if (other.vipTime != null)
				return false;
		} else if (!vipTime.equals(other.vipTime))
			return false;
		if (vipUsername == null) {
			if (other.vipUsername != null)
				return false;
		} else if (!vipUsername.equals(other.vipUsername))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vip_User [vipId=" + vipId + ", vipName=" + vipName + ", vipUsername=" + vipUsername + ", vipPassword="
				+ vipPassword + ", vipSex=" + vipSex + ", vipState=" + vipState + ", vipPhone=" + vipPhone
				+ ", vipEmail=" + vipEmail + ", vipAddress=" + vipAddress + ", vipTime=" + vipTime + "]";
	}
}