package ng.bq.springbootjba.service.impl;

import ng.bq.springbootjba.dao.UserDao;
import ng.bq.springbootjba.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserDao userDao;


    @Override
    public int countAllByUserNameAndPassword(String username, String password) {
        return userDao.countAllByUserNameAndPassword(username, password);
    }


}
