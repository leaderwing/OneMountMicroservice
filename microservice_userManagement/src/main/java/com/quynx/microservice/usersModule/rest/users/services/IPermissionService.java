package com.quynx.microservice.usersModule.rest.users.services;

import com.quynx.microservice.usersModule.rest.users.dtos.PermissionDTO;
import com.quynx.microservice.usersModule.rest.users.entities.Permission;

public interface IPermissionService {

    public Iterable<Permission> getPermissionList();

    public Permission getPermissionByKey(String key);

    public Permission createPermission(PermissionDTO permissionDTO);

    public Permission updatePermission(PermissionDTO permissionDTO);

    public void deletePermissionByKey(String permissionKey);
}
