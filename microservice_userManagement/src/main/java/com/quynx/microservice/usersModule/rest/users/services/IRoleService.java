package com.quynx.microservice.usersModule.rest.users.services;

import com.quynx.microservice.usersModule.rest.users.entities.Role;

public interface IRoleService {

    public Iterable<Role> getRoleList();

    public Role getRoleById(Long id);

    public  void validateRoleName(String roleName);

    public Role createRole(String roleStr);

    public void deleteRole(Long id);

    public Role addPermissionOnRole(Long roleId, String permissionKey);

    public Role removePermissionOnRole(Long roleId, String permissionKey);
}
