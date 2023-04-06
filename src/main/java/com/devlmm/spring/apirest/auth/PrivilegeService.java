package com.devlmm.spring.apirest.auth;

import com.devlmm.spring.apirest.models.dao.IPrivilegeDao;
import com.devlmm.spring.apirest.models.entity.Privilege;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PrivilegeService {

    private final IPrivilegeDao privilegeDao;

    public Privilege getPrivilegeByName(String name) {
        return privilegeDao.findByName(name).orElse(null);
    }

    public Privilege getPrivilegeById(Long id) {
        return privilegeDao.findPrivilegeById(id).orElseThrow();
    }

    public List<Privilege> getPrivilegesByIds(List<Long> ids) {
        ArrayList<Privilege> privileges = new ArrayList<>();
        ids.forEach((id) -> privileges.add(this.getPrivilegeById(id)));
        return privileges;
    }

    public List<Privilege> getAllPrivileges(){
        return privilegeDao.findAll();
    }

    public List<Privilege> getPrivilegesByNames(String... names) {
        ArrayList<Privilege> privileges = new ArrayList<>();
        Arrays.stream(names).forEach((name) -> privileges.add(this.getPrivilegeByName(name)));
        return privileges;
    }

}
