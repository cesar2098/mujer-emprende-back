@RestController
@RequestMapping("/usuarios")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/{username}/contrasena")
    public ResponseEntity<String> cambiarContrasena(@PathVariable String username, @RequestBody String nuevaContrasena) {
        if (userService.cambiarContrasena(username, nuevaContrasena)) {
            return ResponseEntity.ok("Contraseña cambiada exitosamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
