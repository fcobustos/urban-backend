package cl.duoc.urban.controller;

import cl.duoc.urban.security.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Autenticacion", description = "Login con generacion de token JWT y roles")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    @Operation(summary = "Iniciar sesion y obtener token JWT")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credenciales) {
        String email = credenciales.get("email");
        String password = credenciales.get("password");

        if ("admin@urban.cl".equalsIgnoreCase(email) && "admin123".equals(password)) {
            String token = jwtUtil.generarToken(email, "ADMIN");
            return ResponseEntity.ok(Map.of(
                "token", token,
                "nombre", "Administrador Urban",
                "email", email,
                "rol", "ADMIN"
            ));
        } else if ("cliente@urban.cl".equalsIgnoreCase(email) && "cliente123".equals(password)) {
            String token = jwtUtil.generarToken(email, "CLIENTE");
            return ResponseEntity.ok(Map.of(
                "token", token,
                "nombre", "Cliente Urban",
                "email", email,
                "rol", "CLIENTE"
            ));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("mensaje", "Credenciales invalidas"));
    }
}
