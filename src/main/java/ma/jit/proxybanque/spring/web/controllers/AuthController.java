package ma.jit.proxybanque.spring.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.jit.proxybanque.spring.security.JwtTokenUtil;
import ma.jit.proxybanque.spring.services.IGerantServices;
import ma.jit.proxybanque.spring.services.jwt.JwtUserDetailsService;
import ma.jit.proxybanque.spring.web.models.jwt.JwtRequest;
import ma.jit.proxybanque.spring.web.models.jwt.JwtResponse;

/**
 * 
 * <h3>AuthController</h3>
 * <p>Le point d'entrée de toutes requetes d'authentification</p>
 * <p>@RestController : envoyer les resultats sous format JSON par default</p>
 * <p>PostMapping</p> : l'ajout, les requete http/post</p>
 *
 * @author proxybanque
 * @version 1.0
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/authenticate")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	private IGerantServices gerantServicess;

	@PostMapping
	public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token, this.gerantServicess.getUser(userDetails.getUsername())));
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	}