package home.petshop.repository.datajpa;

import home.petshop.entity.user.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudAddressRepository extends JpaRepository<Address, Integer> {
}
