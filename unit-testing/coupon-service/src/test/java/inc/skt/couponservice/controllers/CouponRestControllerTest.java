package inc.skt.couponservice.controllers;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import inc.skt.couponservice.model.Coupon;
import inc.skt.couponservice.repository.CouponRepository;

@SpringBootTest
class CouponRestControllerTest {

	@Mock
	private CouponRepository repository;

	@InjectMocks
	CouponRestController ctrl;

	@Test
	void testCreateShouldCreateCoupon() {
		Coupon coupon = new Coupon();
		when(repository.save(coupon)).thenReturn(coupon);
		Coupon couponCreated = ctrl.create(coupon);
		verify(repository, times(1)).save(coupon);
		assertNotNull(couponCreated);
	}

	@Test
	void testGetCouponShouldReturnCoupon() {

		Coupon coupon = new Coupon();
		when(repository.findByCode("")).thenReturn(coupon);
		Coupon couponFound = ctrl.getCoupon("");
		verify(repository, times(1)).findByCode("");
		assertNotNull(couponFound);
	}
	
}
