package com.codesuibi.service;

import com.codesuibi.dao.ClazzDAO;
import com.codesuibi.entity.Clazz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzDAO clazzDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Clazz> findAll() {
        return clazzDAO.findAll();
    }

    @Override
    public void save(Clazz clazz) {
        Clazz clazzDB = clazzDAO.findByName(clazz.getName());

        if(clazzDB == null){
            clazzDAO.save(clazz);
        }else{
            throw new RuntimeException("该班级已经存在");
        }
    }
}
