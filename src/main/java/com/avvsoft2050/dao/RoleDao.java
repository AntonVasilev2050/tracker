package com.avvsoft2050.dao;

import com.avvsoft2050.model.Role;

import java.util.List;

public interface RoleDao {
    void addRole(Role role);
    void deleteRole(int roleId);
    void updateRole(Role role);
    List<Role> getAllRoles();
    Role getRoleById(int roleId);
}
