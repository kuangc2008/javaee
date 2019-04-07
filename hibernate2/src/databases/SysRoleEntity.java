package databases;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sys_role", schema = "stu", catalog = "")
public class SysRoleEntity {
    private long roleId;
    private String roleName;
    private String roleMemo;

    @Id
    @Column(name = "role_id")
    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "role_name")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "role_memo")
    public String getRoleMemo() {
        return roleMemo;
    }

    public void setRoleMemo(String roleMemo) {
        this.roleMemo = roleMemo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysRoleEntity that = (SysRoleEntity) o;
        return roleId == that.roleId &&
                Objects.equals(roleName, that.roleName) &&
                Objects.equals(roleMemo, that.roleMemo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleName, roleMemo);
    }
}
