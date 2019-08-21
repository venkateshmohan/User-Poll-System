package com.company2.socialpolling;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserInviteRepository extends CrudRepository<UserInvite, Integer>{
	/*@Modifying
	@Transactional
	@Query(value="insert into UserInvite(userId,pollId,invite) values(:userId,:pollId,:init) ",nativeQuery=true)
	void startInvite(int userId,int pollId,int init);
    */
	@Modifying
	@Transactional
	@Query("update UserInvite set invite=invite+1 where invite=0")
	void updateInvite(int userId,int pollId);

	@Query("select pollId from UserInvite where invite=1")
	List<UserInvite> findByUserIdandpollId(int pollId);
	
	@Query("select ui from UserInvite ui where ui.userId = ?1")
	List<UserInvite> findByUserId(int userId);
	
	@Modifying
	@Transactional
	@Query("update UserInvite ui set ui.invite=0 where ui.userId = ?1 AND ui.pollId = ?2")
	void deactivateInvites(int userId, int pollId);
}
