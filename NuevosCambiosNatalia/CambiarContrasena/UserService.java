@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean cambiarContrasena(String username, String nuevaContrasena) {
        User user = userRepository.findByUsername(username);

        if (user != null) {
            user.setPassword(nuevaContrasena);
            userRepository.save(user);
            return true;
        }

        return false;
    }
}
