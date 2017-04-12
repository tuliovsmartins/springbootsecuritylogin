package login.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import login.Converter.UserConverter;
import login.Entity.User;
import login.View.Model.UserDataVM;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private UserConverter userConverter;

	public void create(UserDataVM userDataVM) {

		entityManager.persist(userConverter.convert(userDataVM));
		return;

	}

	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		return entityManager.createQuery("from Model").getResultList();
	}

	public UserDataVM getByEmail(String email) {

		User user = new User();
		Query got = entityManager.createQuery("from User where email = :email");
		got.setParameter("email", email);
		try {
			user = (User) got.getSingleResult();
			return userConverter.convert(user);
		} catch (Exception ex) {
			return userConverter.convert(user);
		}

	}

	public User getByConfirmCode(String confirmcode) {

		User user = new User();
		Query got = entityManager.createQuery("from User where confirmcode = :confirmcode");
		try {
			user = (User) got.getSingleResult();
			return user;
		} catch (Exception ex) {
			return user;
		}

	}

	public User getById(long id) {
		return entityManager.find(User.class, id);
	}

	public void update(User user) {
		entityManager.merge(userConverter.convert(user));
		return;
	}

}
