package databases;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class SysUserRoleEntityPK implements Serializable {
    private long roleId;
    private long userId;

    @Column(name = "role_id")
    @Id
    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Column(name = "user_id")
    @Id
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysUserRoleEntityPK that = (SysUserRoleEntityPK) o;
        return roleId == that.roleId &&
                userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, userId);
    }
}
