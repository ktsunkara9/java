package inc.skt.couponservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import inc.skt.couponservice.model.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

	Coupon findByCode(String code);


}
