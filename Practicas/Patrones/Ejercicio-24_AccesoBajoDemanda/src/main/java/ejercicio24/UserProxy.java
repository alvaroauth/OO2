package ejercicio24;

import java.util.ArrayList;
import java.util.List;

public class UserProxy implements PersistableUser {
	private PersistableUser user;
    private PostRepository repositorioPosts;
    private List<Post> posts;


	public UserProxy(PersistableUser user) {
        this.user = user;
        this.repositorioPosts = new PostRepository();
        this.posts = null;
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public String getEmail() {
        return user.getEmail();
    }

    @Override
    public List<Post> getPosts() {
        if (posts == null) {
            posts = repositorioPosts.findPostsByUsername(user.getUsername());
        }
        return this.posts;
    }
}
