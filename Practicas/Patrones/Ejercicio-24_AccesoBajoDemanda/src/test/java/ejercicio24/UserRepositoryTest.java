package ejercicio24;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class UserRepositoryTest {

	@Test
	public void testFindUserByUsername() {
		UserRepository userRepository = new UserRepository();
		
		PersistableUser user = userRepository.findUserByUsername("john_doe");
		assertEquals("john_doe", user.getUsername());
		assertEquals("john.doe@example.com", user.getEmail());

		 assertEquals(1, user.getPosts().size());
		 assertTrue(user.getPosts().stream()
			.anyMatch(post -> post.getText().equals("¡Acabo de publicar mi primer post!")));
	}

}
