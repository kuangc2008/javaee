package databases;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sys_user_role", schema = "stu", catalog = "")
@IdClass(SysUserRoleEntityPK.class)
public class SysUserRoleEntity {
    private long roleId;
    private long userId;

    @Id
    @Column(name = "role_id")
    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Id
    @Column(name = "user_id")
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
        SysUserRoleEntity that = (SysUserRoleEntity) o;
        return roleId == that.roleId &&
                userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, userId);
    }
}
