package inc.skt.couponservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import inc.skt.couponservice.model.Coupon;
import inc.skt.couponservice.repository.CouponRepository;

@RestController
@RequestMapping("/couponapi")
public class CouponRestController {

	@Autowired
	private CouponRepository repository;

	@PostMapping("/coupons")
	public Coupon create(@RequestBody Coupon coupon) {
		return repository.save(coupon);
	}
	
	@GetMapping("/coupons/{code}")
	public Coupon getCoupon(@PathVariable("code") String code) {
		return repository.findByCode(code);
	}
	
}
