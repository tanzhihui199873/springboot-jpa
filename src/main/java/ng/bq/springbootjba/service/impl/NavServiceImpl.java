package ng.bq.springbootjba.service.impl;

import ng.bq.springbootjba.dao.NavDao;
import ng.bq.springbootjba.entity.Nav;
import ng.bq.springbootjba.service.NavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NavServiceImpl implements NavService {
    @Autowired
    NavDao navDao;
    @Override
    public List<Nav> findAll() {
        return navDao.findAll();
    }

    @Override
    public List<Nav> findAllByOrderByIdDesc() {
        return navDao.findAllByOrderByIdDesc();
    }
}
