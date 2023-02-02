package org.sbitnev.part2.repository;

import org.sbitnev.part2.entity.OneTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OneTaskRepository extends JpaRepository<OneTask, Long> {
}
