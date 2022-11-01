package com.upc.apprelacionesallrest.negocio;

import com.upc.apprelacionesallrest.model.oneToMany.bidirectional.Cart;
import com.upc.apprelacionesallrest.model.oneToMany.unidirectional.University;
import com.upc.apprelacionesallrest.model.oneToOne.bidirectional.Owner;
import com.upc.apprelacionesallrest.model.oneToOne.unidirectional.User;
import com.upc.apprelacionesallrest.repository.oneToMany.bidirectional.CartRepository;
import com.upc.apprelacionesallrest.repository.oneToMany.unidirectional.UniversityRepository;
import com.upc.apprelacionesallrest.repository.oneToOne.bidirectional.OwnerRepository;
import com.upc.apprelacionesallrest.repository.oneToOne.unidirectional.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Negocio {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private UniversityRepository universityRepository;

    @Autowired
    private CartRepository cartRepository;

    @Transactional
    public User grabar(User user){
      return userRepository.save(user);
    }

    public List<User> listarUsers() {
        return userRepository.findAll();
    }

    public List<Owner> listOwners() {
        return ownerRepository.findAll();
    }

    public University saveUniversity(University university) {
       return universityRepository.save(university);
    }

    public List<University> listUniversities() {
        return universityRepository.findAll();
    }

    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Cart getCar(Long id) throws Exception {
        return cartRepository.findById(id).orElseThrow(() ->new Exception("No existe"));
    }
}
