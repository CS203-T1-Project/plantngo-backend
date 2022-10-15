package me.plantngo.backend.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.plantngo.backend.models.Promotion;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Integer>{
    
    Optional<Promotion> findById(Integer id);
    Optional<Promotion> findByPromocode(String promocode);
    List<Promotion> findByMerchantId(Integer merchant_Id);
    Boolean existsByPromocode(String promocode);

    
}
