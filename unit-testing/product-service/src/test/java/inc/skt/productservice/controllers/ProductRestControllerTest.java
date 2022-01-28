package inc.skt.productservice.controllers;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import inc.skt.productservice.json.Coupon;
import inc.skt.productservice.model.Product;
import inc.skt.productservice.repositories.ProductRepository;

@SpringBootTest
class ProductRestControllerTest {

	@Mock
	private RestTemplate restTemplate;

	@Mock
	private ProductRepository repo;

	@InjectMocks
	private ProductRestController ctrl;

	private BigDecimal price = new BigDecimal(100);
	private BigDecimal discount = new BigDecimal(100);

	private static final String COUPON_SERVICE_URL = "http://localhost:9091/couponapi/coupons/";

	private static final String COUPON_CODE = "SUPERSALE";

	@Test
	void testCreateShouldCreateProduct() {
		Coupon coupon = new Coupon();
		coupon.setCode(COUPON_CODE);
		coupon.setDiscount(discount);
		ctrl.setCouponServiceUrl(COUPON_SERVICE_URL);
		when(restTemplate.getForObject(COUPON_SERVICE_URL + COUPON_CODE, Coupon.class)).thenReturn(coupon);

		Product product = new Product();
		product.setPrice(price);
		product.setCouponCode(COUPON_CODE);
		when(repo.save(product)).thenReturn(product);
		Product productCreated = ctrl.create(product);

		verify(restTemplate).getForObject(COUPON_SERVICE_URL + COUPON_CODE, Coupon.class);
		verify(repo).save(product);
		assertNotNull(productCreated);
	}

}
