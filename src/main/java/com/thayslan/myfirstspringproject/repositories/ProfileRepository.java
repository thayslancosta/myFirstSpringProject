package com.thayslan.myfirstspringproject.repositories;


import com.thayslan.myfirstspringproject.entities.Category;
import com.thayslan.myfirstspringproject.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface ProfileRepository extends JpaRepository <Profile, Long> {
}

