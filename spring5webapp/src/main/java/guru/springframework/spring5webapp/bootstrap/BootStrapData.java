package guru.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
@Component
public class BootStrapData implements ApplicationListener<ContextRefreshedEvent>{
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	



	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}



	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		initData();
	}



	public void initData(){
		Publisher publisher = new Publisher();
		publisher.setName("foo");
		publisher.setAddress("Delhi");		
		publisherRepository.save(publisher);
		
		Author Chetan = new Author("Chetan","Bhagat");
		Book newBook = new Book("Half GirlFriend","9788129135728",publisher);
		Chetan.getBooks().add(newBook);
		newBook.getAuthors().add(Chetan);
	
		authorRepository.save(Chetan);
		bookRepository.save(newBook);
		Publisher publisher2 = new Publisher();
		publisher2.setName("foo");
		publisher2.setAddress("Delhi");		
		publisherRepository.save(publisher2);
		
		Author Chetan2 = new Author("Chetan","Bhagat");
		Book newBook2 = new Book("Girl in Room 105","9781542040464",publisher2);
		
		Chetan2.getBooks().add(newBook2);
		newBook2.getAuthors().add(Chetan2);
		
		authorRepository.save(Chetan2);
		bookRepository.save(newBook2);
		
		
		System.out.println("Started cin the bootstrap");
		System.out.println("Number of Books : "+bookRepository.count());
		
		
		
 	}


	

}
