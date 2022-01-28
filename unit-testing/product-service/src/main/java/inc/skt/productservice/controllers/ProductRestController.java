package inc.skt.productservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import inc.skt.productservice.json.Coupon;
import inc.skt.productservice.model.Product;
import inc.skt.productservice.repositories.ProductRepository;

@RestController
@RequestMapping("/productapi")
public class ProductRestController {

	@Value("${couponService.url}")
	private String couponServiceUrl;

	public String getCouponServiceUrl() {
		return couponServiceUrl;
	}

	public void setCouponServiceUrl(String couponServiceUrl) {
		this.couponServiceUrl = couponServiceUrl;
	}

	@Autowired
	private ProductRepository repository;

	@Autowired
	private RestTemplate restTemaplate;

	@PostMapping("/products")
	public Product create(@RequestBody Product product) {

		Coupon coupon = restTemaplate.getForObject(couponServiceUrl + product.getCouponCode(), Coupon.class);
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));

		return repository.save(product);
	}

	@GetMapping("/products/{name}")
	public Product getProduct(@PathVariable("name") String name) {
		return repository.findByName(name);
	}
}
