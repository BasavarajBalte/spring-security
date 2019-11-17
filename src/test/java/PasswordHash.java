import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import junit.framework.TestCase;

public class PasswordHash extends TestCase {

	public void testMD5Hash() {
		String password = "test";
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		String hashpassword = encoder.encodePassword(password, null);
		System.out.println(hashpassword);
	}

	public void testBcryotHash() {
		String password = "test";
		BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
		String bcryptEncode = encode.encode(password);
		System.out.println(bcryptEncode	);
	}
}
