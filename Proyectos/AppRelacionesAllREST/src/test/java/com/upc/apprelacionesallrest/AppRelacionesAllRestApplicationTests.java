package com.upc.apprelacionesallrest;

import com.upc.apprelacionesallrest.model.manyToMany.Stream;
import com.upc.apprelacionesallrest.model.manyToMany.Viewer;
import com.upc.apprelacionesallrest.model.oneToMany.bidirectional.Cart;
import com.upc.apprelacionesallrest.model.oneToMany.bidirectional.Item;
import com.upc.apprelacionesallrest.model.oneToMany.unidirectional.Student;
import com.upc.apprelacionesallrest.model.oneToMany.unidirectional.University;
import com.upc.apprelacionesallrest.model.oneToOne.bidirectional.Car;
import com.upc.apprelacionesallrest.model.oneToOne.bidirectional.Owner;
import com.upc.apprelacionesallrest.model.oneToOne.unidirectional.Address;
import com.upc.apprelacionesallrest.model.oneToOne.unidirectional.User;
import com.upc.apprelacionesallrest.repository.manyToMany.StreamRepository;
import com.upc.apprelacionesallrest.repository.manyToMany.ViewerRepository;
import com.upc.apprelacionesallrest.repository.oneToMany.bidirectional.CartRepository;
import com.upc.apprelacionesallrest.repository.oneToMany.bidirectional.ItemRepository;
import com.upc.apprelacionesallrest.repository.oneToMany.unidirectional.StudentRepository;
import com.upc.apprelacionesallrest.repository.oneToMany.unidirectional.UniversityRepository;
import com.upc.apprelacionesallrest.repository.oneToOne.bidirectional.CarRepository;
import com.upc.apprelacionesallrest.repository.oneToOne.bidirectional.OwnerRepository;
import com.upc.apprelacionesallrest.repository.oneToOne.unidirectional.AddressRepository;
import com.upc.apprelacionesallrest.repository.oneToOne.unidirectional.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class AppRelacionesAllRestApplicationTests {

	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private OwnerRepository ownerRepository;
	@Autowired
	private UniversityRepository universityRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private StreamRepository streamRepository;
	@Autowired
	private ViewerRepository viewerRepository;
	@Test
	void contextLoads() {
	}

	//@Test
	public void test1() {
		//        OneToOne Unidirectional, pass
		Address firstAddress = new Address();
		firstAddress.setStreet("Home st.");
		User firstUser = new User();
		firstUser.setName("John Doe");
		addressRepository.save(firstAddress);
		firstUser.setAddress(firstAddress);//asignándole su direción
		User save = userRepository.save(firstUser);
	}

	//@Test
	public void test2() {
		//OneToOne bidirectional, pass
		Car car = new Car();
		car.setModel("Vega200");
		Owner owner = new Owner();
		owner.setName("John Doe");
		carRepository.save(car);
		owner.setCar(car);
		ownerRepository.save(owner);
		car.setOwner(owner);
		carRepository.save(car);
		List<Car> cars = carRepository.findAll();
		for(Car carr:cars){
			System.out.println(carr.getId()+"  "+carr.getOwner().getName()+ "  " + carr.getOwner().getId());
		}
	}

	//@Test
	public void test3() {
		//OneToMany Unidirectional university side
		Student firstStudent = new Student();
		Student secondStudent = new Student();
		//For cascade = CascadeType.ALL do not save or else error will be thrown
		studentRepository.save(firstStudent);
		studentRepository.save(secondStudent);
		List<Student> students = new ArrayList<>();
		students.add(firstStudent);
		students.add(secondStudent);
		University university = new University();
		university.setName("PEPE");
		university.setStudents(students);
		universityRepository.save(university);
	}
	//@Test
	void testListOneToManyUnidirectional(){
		for(University uni:universityRepository.findAll()){
			for (Student student: uni.getStudents()){
				System.out.println(uni.getName()+ "  " + student);
			}
		}
	}
	//@Test
	public void test4(){
		//       OneToMany Bidirectional
		Cart cart = new Cart();
		Item firstItem = new Item();
		Item secondItem = new Item();
		List<Item> items = Arrays.asList(firstItem, secondItem);
		cart.setItems(items);
		cartRepository.save(cart);
	}
	//@Test
	void test4OneToMany_Bid_List(){
		System.out.println("---- List carts and items from car -----");
		for(Cart c: cartRepository.findAll()){
			System.out.println(c.getName());
			for(Item item:c.getItems()){
				System.out.println(item.getSerialNumber());
			}
		}
		System.out.println("-----List de Items and Cart ------");

		for(Item item:itemRepository.findAll()){
			System.out.println(item.getSerialNumber()+"  id cart:" + item.getCart().getId());
		}
	}
	//@Test
	public void test5(){
		//      ManyToMany
		Viewer johnViewer = new Viewer("John12");
		Viewer willViewer = new Viewer("WillM2");
		Viewer samViewer = new Viewer("MightySam");
		List<Viewer> viewers = Arrays.asList(johnViewer, willViewer, samViewer);

		Stream cookingStream = new Stream("CookingIsAwesome");
		Stream gamingStream = new Stream("ChillGaming");
		List<Stream> streams = Arrays.asList(cookingStream, gamingStream);

		streamRepository.saveAll(streams);

		johnViewer.followStream(cookingStream);
		willViewer.followStream(gamingStream);
		samViewer.followStream(gamingStream);

		viewerRepository.saveAll(viewers);
	}
	//@Test
	public void testBidManyToMany(){
		for(Viewer viewer: viewerRepository.findAll()){
			System.out.println(viewer);
		}

		System.out.println("----------------------");
		for(Stream stream: streamRepository.findAll()){
			System.out.println(stream);
		}
	}
}
