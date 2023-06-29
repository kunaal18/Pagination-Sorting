package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductServiceImple implements ProductService {

	@Autowired
	private ProductRepository repository;

//	@PostConstruct
//	public void initDB() {
//
//		List<Product> collect = IntStream.rangeClosed(1, 250)
//				.mapToObj(i -> new Product("product" + i, new Random().nextInt(100), new Random().nextInt(50000)))
//				.collect(Collectors.toList());
//		repository.saveAll(collect);
//	}

	@Override
	public List<Product> findAllProducts() {

		return repository.findAll();
	}

	@Override
	public List<Product> findProductsWithSorting(String field) {
		return repository.findAll(Sort.by(field));
		// Sort.by(Direction.DESC,field)
	}

	@Override
	public Page<Product> findProductsWithPagination(int offset, int pageSize) { // pageSize-- means per page how many
																				// items you want to see,, offset - next
																				// element

		return repository.findAll(PageRequest.of(offset, pageSize));
	}

	@Override
	public Page<Product> findProductsWithPaginationAndSorting(int offset, int pageSize, String field) {

		return repository.findAll(PageRequest.of(offset, pageSize, Sort.by(field)));
	}

}
