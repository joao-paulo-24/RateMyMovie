@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public AuthController(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail());

        if (user == null) {
            return "Invalid credentials";
        }

        if (!encoder.matches(request.getPassword(), user.getPassword())) {
            return "Invalid credentials";
        }

        return "LOGIN SUCCESS (JWT will go here later)";
    }
}