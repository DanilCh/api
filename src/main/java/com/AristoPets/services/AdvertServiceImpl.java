package com.AristoPets.services;


import com.AristoPets.dao.AdvertsRepository;
import com.AristoPets.entity.Advert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class AdvertServiceImpl implements AdvertService{

    @Autowired
    AdvertsRepository advertsRepository;

    @Override
    public List<Advert> findAll() {

        return advertsRepository.findAll();
    }

    @Override
    public Advert getAdvert(long id) {

        return advertsRepository.findOne(id);
    }
}
