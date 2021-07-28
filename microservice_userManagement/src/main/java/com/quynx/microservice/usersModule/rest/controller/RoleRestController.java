package com.quynx.microservice.usersModule.rest.controller;

import com.quynx.microservice.usersModule.rest.users.dtos.PermissionDTO;
import com.quynx.microservice.usersModule.rest.users.dtos.RoleDTO;
import com.quynx.microservice.usersModule.rest.users.entities.Permission;
import com.quynx.microservice.usersModule.rest.users.entities.Role;
import com.quynx.microservice.usersModule.rest.users.services.EncryptionService;
import com.quynx.microservice.usersModule.rest.users.services.IPermissionService;
import com.quynx.microservice.usersModule.rest.users.services.IRoleService;
import com.quynx.microservice.usersModule.rest.users.services.impl.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users/role")
public class RoleRestController {

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IPermissionService permissionService;

    // roles
    @GetMapping("/roles")
    public ResponseEntity<List<RoleDTO>> getRolePresentationList() {
        Iterable<Role> roleList = roleService.getRoleList();
        ArrayList<RoleDTO> list = new ArrayList<>();
        roleList.forEach(e -> list.add(new RoleDTO(e)));
        return ResponseEntity.ok(list);
    }

    @PostMapping("/roles")
    public ResponseEntity<RoleDTO> createRole(@RequestBody String role) {
        return new ResponseEntity(new RoleDTO(roleService.createRole(role)), null, HttpStatus.CREATED);
    }

    @GetMapping("/roles/{roleId}")
    public RoleDTO getRoleById(@PathVariable("roleId") Long roleId) {
        return new RoleDTO(roleService.getRoleById(roleId));
    }

    // retrieve the permission's list
    @GetMapping("/permissions")
    public ResponseEntity<List<PermissionDTO>> getPermissionPresentationList() {
        Iterable<Permission> permissionList = permissionService.getPermissionList();
        ArrayList<PermissionDTO> list = new ArrayList<>();
        permissionList.forEach(e -> list.add(new PermissionDTO(e)));
        return ResponseEntity.ok(list);
    }

    // permissions

    @GetMapping("/permissions/{permissionKey}")
    public ResponseEntity<PermissionDTO> getPermissionByKey(@PathVariable("permissionKey") String permissionKey) {
        PermissionDTO permissionDTO = new PermissionDTO(permissionService.getPermissionByKey(permissionKey));
        return ResponseEntity.ok(permissionDTO);
    }

    @PostMapping("/permissions")
    public ResponseEntity<PermissionDTO> createPermission(@RequestBody PermissionDTO permissionDTO) {
        return new ResponseEntity(new PermissionDTO(permissionService.createPermission(permissionDTO)), HttpStatus.CREATED);
    }

    @PutMapping("/permissions")
    public ResponseEntity<PermissionDTO> updatePermission(@RequestBody PermissionDTO permissionDTO) {
        return new ResponseEntity(new PermissionDTO(permissionService.updatePermission(permissionDTO)), HttpStatus.CREATED);
    }

    // add or remove a Permission on a Role


    // salt generation
    @GetMapping("/salt")
    public ResponseEntity<String> generateSalt() {
        return new ResponseEntity<String>(EncryptionService.generateSalt(32), HttpStatus.CREATED);
    }

}
