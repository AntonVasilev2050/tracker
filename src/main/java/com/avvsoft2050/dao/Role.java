package com.avvsoft2050.dao;

import java.util.List;

public interface Role {
    void addRole(Role role);
    void deleteRole(int roleId);
    void updateRole(Role role);
    List<Role> getAllRoles();
    Role getRoleById(int roleId);
}
