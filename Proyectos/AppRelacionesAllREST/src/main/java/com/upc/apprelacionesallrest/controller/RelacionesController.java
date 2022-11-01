package com.upc.apprelacionesallrest.controller;

import com.upc.apprelacionesallrest.model.oneToMany.bidirectional.Cart;
import com.upc.apprelacionesallrest.model.oneToMany.unidirectional.University;
import com.upc.apprelacionesallrest.model.oneToOne.bidirectional.Car;
import com.upc.apprelacionesallrest.model.oneToOne.bidirectional.Owner;
import com.upc.apprelacionesallrest.model.oneToOne.unidirectional.Address;
import com.upc.apprelacionesallrest.model.oneToOne.unidirectional.User;
import com.upc.apprelacionesallrest.negocio.Negocio;
import com.upc.apprelacionesallrest.repository.oneToOne.bidirectional.CarRepository;
import com.upc.apprelacionesallrest.repository.oneToOne.bidirectional.OwnerRepository;
import com.upc.apprelacionesallrest.repository.oneToOne.unidirectional.AddressRepository;
import com.upc.apprelacionesallrest.repository.oneToOne.unidirectional.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RelacionesController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private Negocio negocio;

    @PostMapping("/address")//OneToOne Unidirectional
    public Address saveAddress(@RequestBody Address address){
        return addressRepository.save(address);
    }

    @PostMapping("/user") //OneToOne Unidirectional
    public User saveUser(@RequestBody User user){
        return negocio.grabar(user);
    }

    @GetMapping("/user") //One to One Unidirectional
    public List<User> listUsers(){
        return negocio.listarUsers();
    }

    @PostMapping("/owner") //OneToOne Bidirectional
    public Owner saveOwner(@RequestBody Owner owner){
        return ownerRepository.save(owner);
    }
    @GetMapping("/owner")
    public List<Owner> listOwners(){
        return negocio.listOwners();
    }
    @PostMapping("/car")
    public Car saveCar(@RequestBody Car car){
        return carRepository.save(car);
    }

    @PostMapping("/university")
    public University saveUniversity(@RequestBody University university){
        return negocio.saveUniversity(university);
    }
    @GetMapping("/university")
    public List<University> listUniversities(){
        return negocio.listUniversities();
    }

    @PostMapping("/cart")
    public Cart saveCart(@RequestBody Cart cart){
        return negocio.saveCart(cart);
    }
    @GetMapping("cart/{id}")
    public Cart getCar(@PathVariable("id") Long id) throws Exception {
        return negocio.getCar(id);
    }

    @GetMapping("/cars") //OneToOne Bidirectional, sólo cars por JsonIgnore
    public List<Car> getCars(){
        return carRepository.findAll();
    }
    @GetMapping("/owners")  //OneToOne Birectional
    public List<Owner> getOwners(){
        return ownerRepository.findAll();
    }
}
