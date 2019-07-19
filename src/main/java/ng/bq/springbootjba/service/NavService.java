package ng.bq.springbootjba.service;

import ng.bq.springbootjba.entity.Nav;

import java.util.List;

public interface NavService {
    public List<Nav> findAll();

    public List<Nav> findAllByOrderByIdDesc();
}
